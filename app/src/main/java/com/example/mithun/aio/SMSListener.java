package com.example.mithun.aio;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.VibrationEffect;
import android.os.Vibrator;
import android.provider.Telephony;
import android.telephony.SmsMessage;
import android.util.Log;
import android.widget.Toast;

/**
 * Created by mithun on 28/3/18.
 */

public class SMSListener extends BroadcastReceiver {



    @Override
    public void onReceive(Context context, Intent intent) {
        Log.v("Inside SMS Onreceive","Inside");
        if (Telephony.Sms.Intents.SMS_RECEIVED_ACTION.equals(intent.getAction())) {
            for (SmsMessage smsMessage : Telephony.Sms.Intents.getMessagesFromIntent(intent)) {
                String messageBody = smsMessage.getMessageBody();
                Log.v("Inside If condition",messageBody);
                Toast.makeText(context,messageBody,Toast.LENGTH_SHORT).show();
                Vibrator v = (Vibrator) context.getSystemService(Context.VIBRATOR_SERVICE);
                if (Build.VERSION.SDK_INT >= 26) {
                    v.vibrate(VibrationEffect.createOneShot(2000,10));
                } else {
                    v.vibrate(2000);
                }
            }
        }
    }
}