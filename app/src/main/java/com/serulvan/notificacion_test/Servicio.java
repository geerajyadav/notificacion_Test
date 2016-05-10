package com.serulvan.notificacion_test;

import android.app.Service;
import android.content.Intent;

import android.os.IBinder;
import android.widget.Toast;

public class Servicio extends Service {

    private boolean active;
    private HiloNotificacion hn;

    @Override
    public void onCreate() {
        Toast.makeText(this, "service created", Toast.LENGTH_SHORT).show();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Toast.makeText(this, "service starting", Toast.LENGTH_SHORT).show();
        /*active=true;
        hn = new HiloNotificacion(this);
        hn.execute();*/
        return START_STICKY;
    }

    @Override
    public IBinder onBind(Intent intent) {
        // We don't provide binding, so return null
        return null;
    }

    @Override
    public void onDestroy() {
        Toast.makeText(this, "service done", Toast.LENGTH_SHORT).show();
    }

    public boolean isActive() {
        return active;
    }

    public void setInActive(boolean active) {
        this.active = false;
    }
}
