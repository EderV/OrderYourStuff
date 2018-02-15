package com.app.a2.studio.android.stuff.your.order.orderyourstuff.agenda.baseDeDatos;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.app.a2.studio.android.stuff.your.order.orderyourstuff.agenda.alarma.Alarma;

// Base de datos unica de la app

public class BaseDeDatos extends SQLiteOpenHelper {

    public BaseDeDatos(Context context) {
        super(context, StringsBaseDeDatos.DATABASE_NAME, null, StringsBaseDeDatos.DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {

    }

    // Obtenemos toda la tabla de alarmas con un vector de Alarmas[]
    public Alarma[] getAllAlarmsTable(){
        // Instancia de la clase alarma
        Alarma alarma[];

        // Datos de las columnas
        int ID;
        String nombre, descripcion, horaProgramada;

        // Columnas de la tabla
        String clumnasAlarmas[] = {StringsBaseDeDatos.PRIMARY_KEY,
                                    StringsBaseDeDatos.NOMBRE_ALARMA,
                                    StringsBaseDeDatos.DESCRIPCION_ALARMA,
                                    StringsBaseDeDatos.HORA_PROGRAMADA};

        // Cursor para recorrer las filas
        Cursor c = this.getReadableDatabase().query(StringsBaseDeDatos.TABLA_1, clumnasAlarmas, null, null, null, null, null);

        // Recorremos la tabla con el cursor

        int cnt = 0;

        if(c.moveToFirst()){
            do{
                ID = c.getInt(0);
                nombre = c.getString(1);
                descripcion = c.getString(2);
                horaProgramada = c.getString(3);

                // Falta rellenar array de alarmas y convertir la string de horaProgramada a Calendar

                cnt++;
            }while (c.moveToNext());
        }

        return null;
    }

    // Insertar una alarma devuelve true si la ha insertado
    public boolean insertAlarm(Alarma alarma){
        return false;
    }
}
