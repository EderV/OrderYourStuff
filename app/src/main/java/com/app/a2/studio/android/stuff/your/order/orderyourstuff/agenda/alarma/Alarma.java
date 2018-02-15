package com.app.a2.studio.android.stuff.your.order.orderyourstuff.agenda.alarma;

import java.util.Calendar;
import java.util.Date;

/**
 * Created by Propietario on 14/02/2018.
 */

public class Alarma {
    //  Atributos
    private static int _totalID = 0;
    private int _myID;
    private String _asunto;
    private String _descripcion;
    private boolean _haSonado;
    private Calendar _horaAlarma;

    //  Constructor sin alarma
    public Alarma(String _asunto, String _descripcion) {
        this._asunto=_asunto;
        this._descripcion=_descripcion;
        _horaAlarma=null;
        _haSonado=false;
        _myID = ++_totalID;
    }

    //  Constructor con alarma
    public Alarma(String _asunto, String _descripcion, Calendar _horaAlarma){
        this._asunto=_asunto;
        this._descripcion=_descripcion;
        this._horaAlarma=_horaAlarma;
        this._haSonado=false;
        _myID = ++_totalID;
    }
    //  Metodos
    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Alarma)) {
            return false;
        } else {
            if (((Alarma) obj)._myID == this._myID) {
                return true;
            } else {
                if (((Alarma) obj)._asunto.equals((this._asunto))) {
                    return true;
                } else {
                    return false;
                }
            }
        }
    }

    //
    public boolean esAlarmaPerdida(){
        Calendar c=null;
        c.setTime(new Date());
        return this._horaAlarma.after(c);
    }

    //  Getters

    //
    public int getID() {
        return _myID;
    }


    //
    public Calendar getHoraAlarma(){
        return _horaAlarma;
    }

    //  Setters

    //
    public void setHaSonado(){
        this._haSonado=true;
    }
}
