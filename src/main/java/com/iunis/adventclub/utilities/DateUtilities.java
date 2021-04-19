package com.iunis.adventclub.utilities;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateUtilities {
    /**
     * Metodo para calcular la edad a partir de la fecha de nacimiento
     * @param fechaNac
     * @return edad
     */
    public static String calcEdadByFechaNac(Date fechaNac){

        Calendar fechaNacimiento = Calendar.getInstance();
        //Se crea un objeto con la fecha actual
        Calendar fechaActual = Calendar.getInstance();
        //Se asigna la fecha recibida a la fecha de nacimiento.
        fechaNacimiento.setTime(fechaNac);

        int anio = fechaActual.get(Calendar.YEAR)- fechaNacimiento.get(Calendar.YEAR);
        int mes =fechaActual.get(Calendar.MONTH)- fechaNacimiento.get(Calendar.MONTH);
        int dia = fechaActual.get(Calendar.DATE)- fechaNacimiento.get(Calendar.DATE);

        //Se ajusta el anio dependiendo el mes y el día
        if(mes<0 || (mes==0 && dia<0)){
            anio--;
        }
        return  Integer.toString(anio);
    }

    //Converti la fecha a string
    public static String dateToString(Date fecha){

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

        return sdf.format(fecha);
    }

}
