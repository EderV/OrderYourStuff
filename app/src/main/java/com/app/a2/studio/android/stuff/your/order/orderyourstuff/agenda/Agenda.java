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
    private static Agenda _ag = null;
    private static int IDforNewAlarm;

    // Constructor
    private Agenda(Context context){
        db = new BaseDeDatos(context);
        list = new ArrayList<>();
        IDforNewAlarm = 0;
    }
    // Singleton
    public Agenda getAgenda(Context context){
        if (_ag == null){
            _ag = new Agenda(context);
        }
        return _ag;
    }

    // Metodos
    public boolean createNewAlarm(String nombre, String descipcion, String horaProgramada1){
        if(list.isEmpty()){
            // Si el array esta vacio, lo rellenamos con toda la BBDD
            list = Arrays.asList(db.getAllAlarmsFromTable());
        }

        // Creamos la alarma y la añadimos a la BBDD y al List
        alarma = new Alarma(nombre, descipcion, horaProgramada1);
        boolean a = db.insertAlarm(alarma);
        if (a) {
            // Establecemos la ID a la nueva alarma e incrementamos el ID para una nueva futura alarma
            alarma.set_uniqueID(IDforNewAlarm);
            IDforNewAlarm++;
            list.add(alarma);
            return true;
        }
        else {
            return false;
        }
    }

    public boolean createNewAlarm(String nombre, String descipcion, String horaProgramada1, String horaProgramada2){
        if(list.isEmpty()){
            // Si el array esta vacio, lo rellenamos con toda la BBDD
            list = Arrays.asList(db.getAllAlarmsFromTable());
        }

        // Creamos la alarma y la añadimos a la BBDD y al List
        alarma = new Alarma(nombre, descipcion, horaProgramada1, horaProgramada2);
        boolean a = db.insertAlarm(alarma);
        if (a) {
            // Establecemos la ID a la nueva alarma e incrementamos el ID para una nueva futura alarma
            alarma.set_uniqueID(IDforNewAlarm);
            IDforNewAlarm++;
            list.add(alarma);
            return true;
        }
        else {
            return false;
        }
    }

    public boolean createNewAlarm(String nombre, String descipcion, String horaProgramada1, String horaProgramada2, String horaProgramada3){
        if(list.isEmpty()){
            // Si el array esta vacio, lo rellenamos con toda la BBDD
            list = Arrays.asList(db.getAllAlarmsFromTable());
        }

        // Creamos la alarma y la añadimos a la BBDD y al List
        alarma = new Alarma(nombre, descipcion, horaProgramada1, horaProgramada2, horaProgramada3);
        boolean a = db.insertAlarm(alarma);
        if (a) {
            // Establecemos la ID a la nueva alarma e incrementamos el ID para una nueva futura alarma
            alarma.set_uniqueID(IDforNewAlarm);
            IDforNewAlarm++;
            list.add(alarma);
            return true;
        }
        else {
            return false;
        }
    }

    public void deleteAlarm(int ID){

    }

    public void updateAlarm(int ID, String nombre, String descripcion, String hora1, String hora2, String hora3){
        // Obtenemos el index para acceder al list
        int index = obtainIndex(ID);

        if(list.isEmpty()){
            // Si el array esta vacio, lo rellenamos con toda la BBDD
            list = Arrays.asList(db.getAllAlarmsFromTable());
        }
        // Actualizamos la alarma dentro de la BBDD
        db.updateAlarm(ID, nombre, descripcion, hora1, hora2, hora3);

        // Actualizamos la alarma dentro del list
        list.get(index).set_nombre(nombre);
        list.get(index).set_descripcion(descripcion);
        list.get(index).set_horaProgramada1(hora1);
        list.get(index).set_horaProgramada2(hora2);
        list.get(index).set_horaProgramada3(hora3);
    }

    public int getNumeroAlarmas(){
        return (list.size());
    }

    private int obtainIndex(int alarmID){
        int index = 0;
        boolean founded = false;

        do {
            if (list.get(index).get_uniqueID() == alarmID){
                founded = true;
            }
            else {
                index++;
            }
        }while (index <= list.size() - 1 || founded);

        return index;
    }

}
