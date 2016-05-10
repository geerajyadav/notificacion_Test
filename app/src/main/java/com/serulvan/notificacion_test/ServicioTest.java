package com.serulvan.notificacion_test;


import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.widget.Toast;

public class ServicioTest extends Service {

    private static int i = 0;
    private static boolean runing = false;

    @Override
    public IBinder onBind(Intent arg0) {
        return null;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        runing = true;
        // Let it continue running until it is stopped.
        Toast.makeText(this, "Service Started " + i++, Toast.LENGTH_LONG).show();
        return START_STICKY;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Toast.makeText(this, "Service Destroyed", Toast.LENGTH_LONG).show();
        runing = false;
    }

    public static boolean isRunning(){
        if (runing){
            return runing;
        } else{
            return false;
        }
    }
}
