package com.aluracursos.Modelos;

import java.util.Map;

public class Operaciones {
    private final Map<String, Double> tasasDeCambio;

    public Operaciones(Map<String, Double> tasasDeCambio) {
        this.tasasDeCambio = tasasDeCambio;
    }

    public double convertirDolarAPesoArgentino(double cantidad) {
        return cantidad * tasasDeCambio.get("ARS");
    }

    public double convertirPesoArgentinoADolar(double cantidad) {
        return cantidad / tasasDeCambio.get("ARS");
    }

    public double convertirDolarARealBrasileno(double cantidad) {
        return cantidad * tasasDeCambio.get("BRL");
    }

    public double convertirRealBrasilenoADolar(double cantidad) {
        return cantidad / tasasDeCambio.get("BRL");
    }

    public double convertirDolarAPesoMexicano(double cantidad) {
        return cantidad * tasasDeCambio.get("MXN");
    }

    public double convertirPesoMexicanoADolar(double cantidad) {
        return cantidad / tasasDeCambio.get("MXN");
    }
}
