package com.serulvan.notificacion_test;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private int i = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btn_ya = (Button) findViewById(R.id.btn_ya);
        btn_ya.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        /*if (ServicioTest.isRunning()){
            startService(new Intent(getBaseContext(), ServicioTest.class));
        } else{
            stopService(v);
        }*/
        new HiloNotificacion(this).execute();
    }

    public void stopService(View view) {
        stopService(new Intent(getBaseContext(), ServicioTest.class));
    }
}