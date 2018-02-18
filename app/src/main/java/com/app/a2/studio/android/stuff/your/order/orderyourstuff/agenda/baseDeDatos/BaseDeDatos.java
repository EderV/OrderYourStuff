package com.app.a2.studio.android.stuff.your.order.orderyourstuff.agenda.baseDeDatos;

import android.content.ContentValues;
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
    public Alarma[] getAllAlarmsFromTable(){

        // Datos de las columnas
        int ID;
        String nombre, descripcion, horaProgramada1, horaProgramada2, horaProgramada3;

        // Columnas de la tabla
        String clumnasAlarmas[] = {StringsBaseDeDatos.ID,
                                    StringsBaseDeDatos.NOMBRE_ALARMA,
                                    StringsBaseDeDatos.DESCRIPCION_ALARMA,
                                    StringsBaseDeDatos.HORA_PROGRAMADA_1,
                                    StringsBaseDeDatos.HORA_PROGRAMADA_2,
                                    StringsBaseDeDatos.HORA_PROGRAMADA_3};

        // Cursor para recorrer las filas
        Cursor c = this.getReadableDatabase().query(StringsBaseDeDatos.TABLA_1, clumnasAlarmas, null, null, null, null, null);
        // Instancia de la clase alarma
        Alarma[] alarma = new Alarma[c.getCount()];


        // Recorremos la tabla con el cursor
        int cnt = 0;

        if(c.moveToFirst()){
            do{
                // Obtenemos con el cursor todas las columnas
                ID = c.getInt(0);
                nombre = c.getString(1);
                descripcion = c.getString(2);
                horaProgramada1 = c.getString(3);
                horaProgramada2 = c.getString(4);
                horaProgramada3 = c.getString(5);

                // Creamos el array de Alarmas con todas las alarmas de la BBDD
                alarma[cnt] = new Alarma(nombre, descripcion, horaProgramada1, horaProgramada2, horaProgramada3);
                alarma[cnt].set_uniqueID(ID);

                cnt++;
            }while (c.moveToNext());
        }
        c.close();
        return null;
    }

    // Insertar una alarma devuelve true si la ha insertado
    public boolean insertAlarm(Alarma alarma){
        ContentValues contentValues = new ContentValues();
        return false;
    }
}
