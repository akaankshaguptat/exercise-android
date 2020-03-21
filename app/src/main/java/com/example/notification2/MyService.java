package com.example.notification2;

import android.app.Notification;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import static com.example.notification2.App.CHANNEL_ID_1;
import static com.example.notification2.App.CHANNEL_ID_2;

public class MyService extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        //notification channel 1
        NotificationCompat.Builder builder = new NotificationCompat.Builder(context,CHANNEL_ID_1)
                .setSmallIcon(android.R.drawable.ic_dialog_alert) //sets icon in notificaiton
                .setVibrate(new long[]{1000,1000,1000,1000})
                .setContentTitle("Channel 1 ")//title of the notification
                .setContentText("this notification is with sound+vibration "); // Body text
                 builder.setPriority(Notification.PRIORITY_MAX); // PRIORITY_HIGH -- makes phone ring and vibrate with notification popup


        NotificationManagerCompat notificationManager = NotificationManagerCompat.from(context);
        notificationManager.notify(1,builder.build());

        try {  // so that both notification does not occur at the same time.
            Thread.sleep(6000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        //notification channel 2
        NotificationCompat.Builder builder1 = new NotificationCompat.Builder(context,CHANNEL_ID_2)
                .setSmallIcon(android.R.drawable.ic_dialog_alert)
                .setContentTitle("Channel 2")
                .setContentText("this is silent notification");
        //.setPriority(NotificationCompat.PRIORITY_LOW);  // PRIORITY_LOW -- Does not make notification popup
        notificationManager.notify(2,builder1.build());



    }
}
