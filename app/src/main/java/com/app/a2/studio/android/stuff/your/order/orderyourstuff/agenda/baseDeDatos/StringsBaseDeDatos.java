package com.app.a2.studio.android.stuff.your.order.orderyourstuff.agenda.baseDeDatos;


// Clase para definir las strings necesarias para la base de datos

public abstract class StringsBaseDeDatos {

    // Definicion de la base de datos
    public static final String DATABASE_NAME = "OrderYurStuffDataBase.db";
    public static final int DATABASE_VERSION = 1;
    public static final String TABLA_ALRMAS = "Tabla de alarmas";

    // Columnas de la tabla
    public static final String ID = "UniqueID";
    public static final String NOMBRE_ALARMA = "Nombre";
    public static final String DESCRIPCION_ALARMA = "Descripcion";
    public static final String HORA_PROGRAMADA_1 = "Hora";
    public static final String HORA_PROGRAMADA_2 = "Hora";
    public static final String HORA_PROGRAMADA_3 = "Hora";

    // String creadora de la tabla
    public static final String TABLA_1 = "CREATE TABLE + " + TABLA_ALRMAS + " ("
                                        + ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                                        + NOMBRE_ALARMA + " TEXT NOT NULL,"
                                        + DESCRIPCION_ALARMA + " TEXT NOT NULL,"
                                        + HORA_PROGRAMADA_1 + " TEXT NOT NULL, "
                                        + HORA_PROGRAMADA_2 + " TEXT NOT NULL, "
                                        + HORA_PROGRAMADA_3 + " TEXT NOT NULL )";

    // Strings de actualizacion de base de datos
}
