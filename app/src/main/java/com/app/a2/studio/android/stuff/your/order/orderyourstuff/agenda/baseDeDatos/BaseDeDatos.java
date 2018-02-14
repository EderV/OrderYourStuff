package com.app.a2.studio.android.stuff.your.order.orderyourstuff.agenda.baseDeDatos;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

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
}
