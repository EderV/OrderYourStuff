package com.app.a2.studio.android.stuff.your.order.orderyourstuff.agenda.alarma;

import java.util.Calendar;
import java.util.Date;

// Formato para las horas " hh,mm,ss;dia;mes;año "

public class Alarma {
    //  Atributos
    
    private long _uniqueID;
    private String _nombre;
    private String _descripcion;

    private boolean _haSonado1;
    private boolean _haSonado2;
    private boolean _haSonado3;

    private String _horaProgramada1;
    private String _horaProgramada2;
    private String _horaProgramada3;


    //  Constructores
    public Alarma(String _nombre, String _descripcion, String _horaProgramada1){
        this._nombre=_nombre;
        this._descripcion=_descripcion;
        this._horaProgramada1=_horaProgramada1;
        this._horaProgramada2="NULL";
        this._horaProgramada3="NULL";
        this._haSonado1=false;
        this._haSonado2=false;
        this._haSonado3=false;
    }

    public Alarma(String _nombre, String _descripcion, String _horaProgramada1, String _horaProgramada2){
        this._nombre=_nombre;
        this._descripcion=_descripcion;
        this._horaProgramada1=_horaProgramada1;
        this._horaProgramada2=_horaProgramada2;
        this._horaProgramada3="NULL";
        this._haSonado1=false;
        this._haSonado2=false;
        this._haSonado3=false;
    }

    public Alarma(String _nombre, String _descripcion, String _horaProgramada1, String _horaProgramada2, String _horaProgramada3){
        this._nombre=_nombre;
        this._descripcion=_descripcion;
        this._horaProgramada1=_horaProgramada1;
        this._horaProgramada2=_horaProgramada2;
        this._horaProgramada3=_horaProgramada3;
        this._haSonado1=false;
        this._haSonado2=false;
        this._haSonado3=false;
    }


    //  Metodos
    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Alarma)){
            return false;
        }else {
            if (((Alarma) obj)._uniqueID == this._uniqueID)
                return true;
            if (((Alarma) obj)._nombre.equals((this._nombre)))
                return true;
            return false;
        }
    }

    /*
    public boolean esAlarmaPerdida(){
        Calendar c=null;
        c.setTime(new Date());
        return this._horaAlarma.after(c);
    }
    */

    //  Getters
    public long get_uniqueID() {
        return _uniqueID;
    }

    public String get_nombre() {
        return _nombre;
    }

    public String get_descripcion() {
        return _descripcion;
    }

    public boolean is_haSonado1() {
        return _haSonado1;
    }

    public boolean is_haSonado2() {
        return _haSonado2;
    }

    public boolean is_haSonado3() {
        return _haSonado3;
    }

    public String get_horaProgramada1() {
        return _horaProgramada1;
    }

    public String get_horaProgramada2() {
        return _horaProgramada2;
    }

    public String get_horaProgramada3() {
        return _horaProgramada3;
    }


    //  Setters
    public void set_uniqueID(long _uniqueID) {
        this._uniqueID = _uniqueID;
    }

    public void set_nombre(String _nombre) {
        this._nombre = _nombre;
    }

    public void set_descripcion(String _descripcion) {
        this._descripcion = _descripcion;
    }

    public void set_haSonado1(boolean _haSonado1) {
        this._haSonado1 = _haSonado1;
    }

    public void set_haSonado2(boolean _haSonado2) {
        this._haSonado2 = _haSonado2;
    }

    public void set_haSonado3(boolean _haSonado3) {
        this._haSonado3 = _haSonado3;
    }

    public void set_horaProgramada1(String _horaProgramada1) {
        this._horaProgramada1 = _horaProgramada1;
    }

    public void set_horaProgramada2(String _horaProgramada2) {
        this._horaProgramada2 = _horaProgramada2;
    }

    public void set_horaProgramada3(String _horaProgramada3) {
        this._horaProgramada3 = _horaProgramada3;
    }
}
