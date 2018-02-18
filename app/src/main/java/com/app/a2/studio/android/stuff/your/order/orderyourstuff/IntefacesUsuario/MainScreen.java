package com.app.a2.studio.android.stuff.your.order.orderyourstuff.IntefacesUsuario;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import com.app.a2.studio.android.stuff.your.order.orderyourstuff.R;
import com.app.a2.studio.android.stuff.your.order.orderyourstuff.agenda.baseDeDatos.BaseDeDatos;

public class MainScreen extends AppCompatActivity {

    private int anInt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_screen);

        anInt = 32;
    }
}
