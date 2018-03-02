package com.app.a2.studio.android.stuff.your.order.orderyourstuff.IntefacesUsuario;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.speech.RecognizerIntent;
import android.support.design.internal.NavigationMenu;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.app.a2.studio.android.stuff.your.order.orderyourstuff.R;

import java.util.ArrayList;

import io.github.yavski.fabspeeddial.FabSpeedDial;

public class MainScreen extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener, View.OnClickListener, FabSpeedDial.MenuListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_screen);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FabSpeedDial fab = (FabSpeedDial) findViewById(R.id.ms_fab_fabBtn);
        fab.setMenuListener(this);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main_screen, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_camera) {
            // Handle the camera action
        } else if (id == R.id.nav_gallery) {

        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_manage) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){

            default:
                break;
        }
    }

    ///////////////////////////////////////////////
    // Floating action button speed dial listener
    @Override
    public boolean onPrepareMenu(NavigationMenu navigationMenu) {
        return true;
    }

    @Override
    public boolean onMenuItemSelected(MenuItem menuItem) {
        switch (menuItem.getItemId()){
            // Pulsado microfono
            case(R.id.fabm_btn_mic):
                // Intent de reconocimiento de voz
                Intent intentRecognitionVoice = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);

                // Le decimos que solo escuche y devuelva el idioma castellano
                intentRecognitionVoice.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL, "es-ES");
                intentRecognitionVoice.putExtra(RecognizerIntent.EXTRA_LANGUAGE, "es");
                intentRecognitionVoice.putExtra(RecognizerIntent.EXTRA_LANGUAGE_PREFERENCE, "es");
                intentRecognitionVoice.putExtra(RecognizerIntent.EXTRA_ONLY_RETURN_LANGUAGE_PREFERENCE,"es");
                intentRecognitionVoice.putExtra(RecognizerIntent.EXTRA_PROMPT,"Habla para crear tu nota...");

                try{
                    startActivityForResult(intentRecognitionVoice, 1);
                } catch (ActivityNotFoundException e){
                    makeText("Tu dispositivo no soporta reconocimiento de voz", "long");
                }
                break;

            // Pulsado lapiz
            case(R.id.fabm_btm_pencil):
                makeText("Escirbir nota", "short");
                break;

                default:
                    break;
        }
        return true;
    }

    @Override
    public void onMenuClosed() {

    }
    ///////////////////////////////////////////////

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data){
        super.onActivityResult(requestCode, resultCode, data);

        switch (requestCode){
            // Caso de que el resultado venga del reconocimiento de voz
            case 1:
                if (resultCode == RESULT_OK && null != data){
                    ArrayList<String> speech = data.getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS);
                    String strSpeech = speech.get(0);

                    makeText(strSpeech, "long");
                }
                break;
        }
    }

    private void makeText(String text, String duration){
        if (duration == "short"){
            Toast.makeText(getApplicationContext(), text, Toast.LENGTH_SHORT).show();
        }
        else{
            Toast.makeText(getApplicationContext(), text, Toast.LENGTH_LONG).show();
        }
    }
}
