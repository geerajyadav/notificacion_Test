package com.serulvan.notificacion_test;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import android.support.v4.app.NotificationCompat;

public class HiloNotificacion extends AsyncTask<Void, Void, Void> {

    private Servicio servicio;
    private MainActivity activity;
    private int a;

    public HiloNotificacion(Servicio servicio) {
        this.servicio = servicio;
    }

    public HiloNotificacion(MainActivity activity) {
        this.activity = activity;
    }

    @Override
    protected Void doInBackground(Void... params) {
        a = 0;
        while (a<5){
            try {
                Thread.sleep(1000*2);
                publishProgress();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            a++;
        }
        return null;
    }

    @Override
    protected void onProgressUpdate(Void... values) {
        super.onProgressUpdate(values);
        NotificationCompat.Builder ncb = new NotificationCompat.Builder(activity);
        ncb.setSmallIcon(R.drawable.x_wing_icon);
        ncb.setContentTitle("prueba " + a);
        ncb.setContentText("esto es una prueba " + a);
        ncb.setAutoCancel(true);
        Uri sound = Uri.parse("android.resource://" + activity.getPackageName() + "/" + R.raw.blast_small);
        ncb.setSound(sound);
        ncb.setNumber(a);
        Intent intent = new Intent(activity,MainActivity.class);
        PendingIntent rpi = PendingIntent.getActivity(activity, 0, intent, 0);
        ncb.setContentIntent(rpi);

        int mNotificationId = 0;
        NotificationManager mNotifyMgr = (NotificationManager) activity.getSystemService(Context.NOTIFICATION_SERVICE);
        mNotifyMgr.notify(mNotificationId, ncb.build());
    }

    @Override
    protected void onPostExecute(Void aVoid) {
        super.onPostExecute(aVoid);
    }
}
