package com.app.a2.studio.android.stuff.your.order.orderyourstuff.IntefacesUsuario;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.app.a2.studio.android.stuff.your.order.orderyourstuff.R;

public class SplashScreen extends AppCompatActivity {
    //  Atributtes


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

    }


    private void metodo(){
        int a = 0, b = 0;
        a = a + 2;
        b = b + a;
    }

}
