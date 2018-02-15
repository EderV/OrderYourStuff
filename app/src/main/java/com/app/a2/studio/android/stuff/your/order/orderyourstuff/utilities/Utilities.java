package com.app.a2.studio.android.stuff.your.order.orderyourstuff.utilities;

import java.util.Calendar;

// Clase para declarar metodos y coonstantes utiles en _todo el codigo (si pones _todo sin "_" falla no se porque)

public abstract class Utilities {

    // Constantes


    // Metodos
    public static String calendarToString(Calendar c){
        int hour, minute, second, day, month;
        String s;

        // Separamos dato por dato del Calendar
        hour = c.get(Calendar.HOUR_OF_DAY);
        minute = c.get(Calendar.MINUTE);
        second = c.get(Calendar.SECOND);
        day = c.get(Calendar.DAY_OF_WEEK);
        month = c.get(Calendar.MONTH);

        // Contruimos la cadena ( hh,mm,ss;dd;mes )
        s = String.valueOf(hour) + "," + String.valueOf(minute) + "," + String.valueOf(second) + ";" + String.valueOf(day) + ";" + String.valueOf(month);
        return s;
    }

    public static Calendar stringToCalendar(String s){
        // Formato unico y permitido:  hh,mm,ss;dd;mes

        // Completar

        return null;
    }
}
