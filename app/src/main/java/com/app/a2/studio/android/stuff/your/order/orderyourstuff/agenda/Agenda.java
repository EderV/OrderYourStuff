package com.app.a2.studio.android.stuff.your.order.orderyourstuff.agenda;

import android.content.Context;
import com.app.a2.studio.android.stuff.your.order.orderyourstuff.agenda.alarma.Alarma;
import com.app.a2.studio.android.stuff.your.order.orderyourstuff.agenda.baseDeDatos.BaseDeDatos;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class Agenda {

    // Atributos
    private BaseDeDatos db;
    private List<Alarma> list;
    private Alarma alarma;
    private static Agenda _ag=null;

    // Constructor
    private Agenda(Context context){
        db = new BaseDeDatos(context);
        list = new ArrayList<>();
    }
    // Singleton
    public Agenda getAgenda(Context context){
        if (_ag == null){
            _ag = new Agenda(context);
        }
        return _ag;
    }

    // Metodos
    public void createNewAlarm(String nombre, String descipcion, String horaProgramada1){
        if(list.isEmpty()){
            // Si el array esta vacio, lo rellenamos con toda la BBDD
            list = Arrays.asList(db.getAllAlarmsFromTable());
        }

        // Creamos la alarma y la añadimos a la BBDD y al List
        alarma = new Alarma(nombre, descipcion, horaProgramada1);
        db.insertAlarm(alarma);
        list.add(alarma);
    }

    public void createNewAlarm(String nombre, String descipcion, String horaProgramada1, String horaProgramada2){
        if(list.isEmpty()){
            // Si el array esta vacio, lo rellenamos con toda la BBDD
            list = Arrays.asList(db.getAllAlarmsFromTable());
        }

        // Creamos la alarma y la añadimos a la BBDD y al List
        alarma = new Alarma(nombre, descipcion, horaProgramada1, horaProgramada2);
        db.insertAlarm(alarma);
        list.add(alarma);
    }

    public void createNewAlarm(String nombre, String descipcion, String horaProgramada1, String horaProgramada2, String horaProgramada3){
        if(list.isEmpty()){
            // Si el array esta vacio, lo rellenamos con toda la BBDD
            list = Arrays.asList(db.getAllAlarmsFromTable());
        }

        // Creamos la alarma y la añadimos a la BBDD y al List
        alarma = new Alarma(nombre, descipcion, horaProgramada1, horaProgramada2, horaProgramada3);
        db.insertAlarm(alarma);
        list.add(alarma);
    }

    public void deleteAlarm(long ID){

    }

    public int getNumeroAlarmas(){
        return (list.size());
    }

}
