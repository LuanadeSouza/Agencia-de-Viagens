package com.example.agenciaapplication.util;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class DataUtil {

    private static final String DIA_E_MES = "dd/MM";

    public static String periodoEmTexto(int dias) {
        Calendar dataIda = Calendar.getInstance();
        Calendar dataVolta = Calendar.getInstance();
        dataVolta.add(Calendar.DATE, dias);
        SimpleDateFormat dateFormat = new SimpleDateFormat(DIA_E_MES);
        String dataFormatadaIda = dateFormat.format(dataIda.getTime());
        String dataFormatadaVolta = dateFormat.format(dataVolta.getTime());
        return dataFormatadaIda + " - " + dataFormatadaVolta + " de " + dataVolta.get(Calendar.YEAR);
    }

}
