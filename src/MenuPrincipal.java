import com.aluracursos.Modelos.Operaciones;
import com.aluracursos.apimonedas.TipoDeCambioApi;

import java.util.Scanner;
import java.util.Map;

public class MenuPrincipal {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        TipoDeCambioApi api = new TipoDeCambioApi();
        Map<String, Double> tasasDeCambio = api.buscarTiposDeCambio();
        Operaciones operaciones = new Operaciones(tasasDeCambio);

        System.out.println("*******************************************");
        System.out.println("¡Bienvenido al Conversor de Moneda!");
        System.out.println("*******************************************");

        String[] opciones = {
                "1. Dólar => Peso argentino",
                "2. Peso argentino => Dólar",
                "3. Dólar => Real brasileño",
                "4. Real brasileño => Dólar",
                "5. Dólar => Peso mexicano",
                "6. Peso mexicano => Dólar",
                "7. Salir"
        };

        boolean salir = false;
        while (!salir) {
            System.out.println("\nElija una opción:");
            for (String opcion : opciones) {
                System.out.println(opcion);
            }
            System.out.print("Opción: ");
            int opcionSeleccionada = scanner.nextInt();

            switch (opcionSeleccionada) {
                case 1:
                    System.out.print("Ingrese la cantidad de dólares a convertir a pesos argentinos: ");
                    double cantidadDolares1 = scanner.nextDouble();
                    double resultado1 = operaciones.convertirDolarAPesoArgentino(cantidadDolares1);
                    System.out.println(cantidadDolares1 + " dólares equivalen a " + resultado1 + " pesos argentinos.");
                    break;
                case 2:
                    System.out.print("Ingrese la cantidad de pesos argentinos a convertir en dólares: ");
                    double cantidadPesosArgentinos2 = scanner.nextDouble();
                    double resultado2 = operaciones.convertirPesoArgentinoADolar(cantidadPesosArgentinos2);
                    System.out.println(cantidadPesosArgentinos2 + " pesos argentinos equivalen a " + resultado2 + " dólares.");
                    break;
                case 3:
                    System.out.print("Ingrese la cantidad de dólares a convertir en reales brasileños: ");
                    double cantidadDolares3 = scanner.nextDouble();
                    double resultado3 = operaciones.convertirDolarARealBrasileno(cantidadDolares3);
                    System.out.println(cantidadDolares3 + " dólares equivalen a " + resultado3 + " reales brasileños.");
                    break;
                case 4:
                    System.out.print("Ingrese la cantidad de reales brasileños a convertir en dólares: ");
                    double cantidadReales4 = scanner.nextDouble();
                    double resultado4 = operaciones.convertirRealBrasilenoADolar(cantidadReales4);
                    System.out.println(cantidadReales4 + " reales brasileños equivalen a " + resultado4 + " dólares.");
                    break;
                case 5:
                    System.out.print("Ingrese la cantidad de dólares a convertir en pesos mexicanos: ");
                    double cantidadDolares5 = scanner.nextDouble();
                    double resultado5 = operaciones.convertirDolarAPesoMexicano(cantidadDolares5);
                    System.out.println(cantidadDolares5 + " dólares equivalen a " + resultado5 + " pesos mexicanos.");
                    break;
                case 6:
                    System.out.print("Ingrese la cantidad de pesos mexicanos a convertir en dólares: ");
                    double cantidadPesosMexicanos6 = scanner.nextDouble();
                    double resultado6 = operaciones.convertirPesoMexicanoADolar(cantidadPesosMexicanos6);
                    System.out.println(cantidadPesosMexicanos6 + " pesos mexicanos equivalen a " + resultado6 + " dólares.");
                    break;
                case 7:
                    salir = true;
                    break;
                default:
                    System.out.println("Opción no válida. Por favor, seleccione una opción válida.");
            }

        }

        System.out.println("¡Gracias por usar el Conversor de Moneda!");
        scanner.close();
    }
}
