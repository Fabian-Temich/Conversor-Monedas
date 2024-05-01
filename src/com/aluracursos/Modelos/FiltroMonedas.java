package com.aluracursos.Modelos;

import java.util.HashSet;
import java.util.Set;

    public class FiltroMonedas {
        private static final Set<String> monedasConversion = new HashSet<>(Set.of("USD", "ARS", "BRL", "MXN"));

        private FiltroMonedas() {
            // Constructor privado para evitar instanciación
        }

        public static boolean esMonedaDeConversion(String moneda) {
            return monedasConversion.contains(moneda);
        }
        public static int getCantidadMonedasDeConversion() {
            return monedasConversion.size();
        }

    }


