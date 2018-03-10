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
    public boolean createNewAlarm(String nombre, String descipcion, String horaProgramada1){
        if(list.isEmpty()){
            // Si el array esta vacio, lo rellenamos con toda la BBDD
            list = Arrays.asList(db.getAllAlarmsFromTable());
        }

        // Creamos la alarma y la añadimos a la BBDD y al List
        alarma = new Alarma(nombre, descipcion, horaProgramada1);
        boolean a = db.insertAlarm(alarma);
        if (a) {
            list.add(alarma);
            setIDToNewAlarm();
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
            list.add(alarma);
            setIDToNewAlarm();
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
            list.add(alarma);
            setIDToNewAlarm();
            return true;
        }
        else {
            return false;
        }
    }

    public void deleteAlarm(int ID){

    }

    public void updateAlarm(int ID, String nombre, String descripcion, String hora1, String hora2, String hora3){
        if(list.isEmpty()){
            // Si el array esta vacio, lo rellenamos con toda la BBDD
            list = Arrays.asList(db.getAllAlarmsFromTable());
        }
        // Actualizamos la alarma dentro de la BBDD
        db.updateAlarm(ID, nombre, descripcion, hora1, hora2, hora3);

        // Actualizamos la alarma dentro del list ............Completar.................. y solucionar problema del index
                                                                                            // porque el index no tiene porque coincidir con la UniqueID
    }

    public int getNumeroAlarmas(){
        return (list.size());
    }

    private void setIDToNewAlarm(){

        //................Solucionar bugazo porque no siempre tendremos elementos......................

        // Necesitamos establecer la ID de la alarma manualmente ya que hasta que no entra en la BBDD no se le añade una

        // Obtenemos el index del ultimo elemento del list
        int lastElement = list.size() - 1;

        // Añadimos el ID al ultimo elemento que coincide con la longitud del list
        list.get(lastElement).set_uniqueID(list.size());
    }

}
