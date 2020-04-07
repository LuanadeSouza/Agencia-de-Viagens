package com.example.agenciaapplication.util;

public class DiaUtils {
    public static final String DIA = "dia";
    public static final String DIAS = DIA + "s";

    public static String getDias(int quantidadeDeDias) {
        if (quantidadeDeDias > 1) {
            return quantidadeDeDias + " " + DIAS;
        }
        return quantidadeDeDias + " " + DIA;

    }

}
