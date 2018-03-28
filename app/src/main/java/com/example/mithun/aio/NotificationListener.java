package com.example.mithun.aio;

import android.content.Context;
import android.os.Build;
import android.os.VibrationEffect;
import android.os.Vibrator;
import android.service.notification.NotificationListenerService;
import android.service.notification.StatusBarNotification;
import android.util.Log;
import android.widget.Toast;

/**
 * Created by mithun on 28/3/18.
 */

public class NotificationListener extends NotificationListenerService {
    //public static String TAG = "NotificationListenerTesting";
    //private StatusBarNotification[] mStatusBarNotification;
    Context context;
    @Override
    public void onCreate(){
        super.onCreate();
        context = getApplicationContext();
        Log.v("NotificationTesting", "Inside on create");
    }
    /*@Override
    public IBinder onBind(Intent intent) {
        return super.onBind(intent);
    }*/
    @Override
    public void onNotificationPosted(StatusBarNotification sbn) {
        Log.v("NotificationTesting", "Inside onNotificationPosted");
        //TAG = "onNotificationPosted";
        Log.v("onNotificationPosted", "Package Name : " + sbn.getPackageName() +
                "Title : " + sbn.getNotification().extras.getString("android.title"));
        Toast.makeText(context,sbn.getNotification().extras.getString("android.title"),Toast.LENGTH_SHORT).show();
        Vibrator v = (Vibrator) context.getSystemService(Context.VIBRATOR_SERVICE);
        if (Build.VERSION.SDK_INT >= 26) {
            v.vibrate(VibrationEffect.createOneShot(2000,10));
        } else {
            v.vibrate(2000);
        }
    }
    @Override
    public void onNotificationRemoved(StatusBarNotification sbn) {
        //TAG = "onNotificationRemoved";
        Log.v("onNotificationRemoved", "id = " + sbn.getId() + "Package Name" + sbn.getPackageName() +
                "Post time = " + sbn.getPostTime() + "Tag = " + sbn.getTag());

    }
}