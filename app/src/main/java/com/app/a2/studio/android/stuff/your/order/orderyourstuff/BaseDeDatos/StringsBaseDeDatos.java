package com.app.a2.studio.android.stuff.your.order.orderyourstuff.BaseDeDatos;


// Clase para definir las strings necesarias para la base de datos

public abstract class StringsBaseDeDatos {

    // Definicion de la base de datos
    public static final String DATABASE_NAME = "OrderYurStuffDataBase.db";
    public static final int DATABASE_VERSION = 1;
    public static final String TABLA_ALRMAS = "Tabla de alarmas";

    // Garai me la come del reves

    // Columnas de la tabla
    public static final int PRIMARY_KEY = 0;
    public static final String NOMBRE_ALARMA = "Nombre";
    public static final String DESCRIPCION_ALARMA = "Descripcion";
    public static final String HORA_PROGRAMADA = "Hora";

    // String creadora de la tabla
    public static final String TABLA_1 = "CREATE TABLE + " + TABLA_ALRMAS + " ("
                                        + PRIMARY_KEY + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                                        + NOMBRE_ALARMA + " TEXT NOT NULL,"
                                        + DESCRIPCION_ALARMA + " TEXT NOT NULL,"
                                        + HORA_PROGRAMADA + " TEXT NOT NULL )";
}
