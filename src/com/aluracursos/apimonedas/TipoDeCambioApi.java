package com.aluracursos.apimonedas;

import com.aluracursos.Modelos.FiltroMonedas;
import com.google.gson.Gson;

import java.io.FileWriter;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.HashMap;
import java.util.Map;

public class TipoDeCambioApi {
    private static final String API_URL = "https://v6.exchangerate-api.com/v6/86bd083ca61c65aae115561d/latest/USD";
    private static final int HTTP_OK = 200;

    public Map<String, Double> buscarTiposDeCambio() {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(API_URL))
                .build();

        try {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            if (response.statusCode() == HTTP_OK) {
                Map<String, Double> tiposDeCambio = procesarRespuestaJson(response.body());
                guardarTipoCambioEnArchivo(tiposDeCambio, "tipo_de_cambio.json"); // Guardar en archivo JSON
                return tiposDeCambio;
            } else {
                throw new RuntimeException("Error en la solicitud HTTP: " + response.statusCode());
            }
        } catch (Exception e) {
            throw new RuntimeException("Error al realizar la solicitud HTTP", e);
        }
    }

    private Map<String, Double> procesarRespuestaJson(String jsonResponse) {
        Map<String, Double> tiposDeCambioFiltrados = new HashMap<>();
        Gson gson = new Gson();

        // Convertir el JSON a un objeto com.aluracursos.apimonedas.TipoCambio
        TipoCambio tipoCambio = gson.fromJson(jsonResponse, TipoCambio.class);

        // Filtrar las tasas de cambio según las monedas de conversión válidas
        tiposDeCambioFiltrados.put("USD", 1.0); // Agregamos la tasa de cambio de USD a USD
        for (Map.Entry<String, Double> entry : tipoCambio.getConversionRates().entrySet()) {
            String moneda = entry.getKey();
            if (FiltroMonedas.esMonedaDeConversion(moneda)) {
                tiposDeCambioFiltrados.put(moneda, entry.getValue());
            }
        }

        // Verificar si se encontraron todas las tasas de cambio necesarias
        if (tiposDeCambioFiltrados.size() < FiltroMonedas.getCantidadMonedasDeConversion()) {
            throw new RuntimeException("No se encontraron todas las tasas de cambio necesarias en la respuesta de la API");
        }

        return tiposDeCambioFiltrados;
    }

    private void guardarTipoCambioEnArchivo(Map<String, Double> tiposDeCambio, String nombreArchivo) {
        Gson gson = new Gson();
        try (FileWriter writer = new FileWriter(nombreArchivo)) {
            gson.toJson(tiposDeCambio, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
