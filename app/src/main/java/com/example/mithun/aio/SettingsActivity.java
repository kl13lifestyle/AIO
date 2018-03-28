package com.example.mithun.aio;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

public class SettingsActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

    }

    private static final int REQUEST_READ_PHONE_STATE=100;
    private static final int REQUEST_READ_SMS_PERMISSION=101;



    public void getPhoneStatePermission(View view) {
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.READ_PHONE_STATE)!= PackageManager.PERMISSION_GRANTED) {

            ActivityCompat.requestPermissions(this,new String[]{Manifest.permission.READ_PHONE_STATE}, REQUEST_READ_PHONE_STATE);
        }
    }

    public void getSMSPermission(View view) {
        if (ContextCompat.checkSelfPermission(this,Manifest.permission.READ_SMS)!= PackageManager.PERMISSION_GRANTED) {
            Log.v("inside getSMSPermission","inside get");
            ActivityCompat.requestPermissions(this,new String[]{Manifest.permission.READ_SMS}, REQUEST_READ_SMS_PERMISSION);
            Log.v("getSMSPermissonLate",String.valueOf(REQUEST_READ_SMS_PERMISSION));

        }
    }

    public void getNotificationPermission(View view) {
        Intent intent=new Intent("android.settings.ACTION_NOTIFICATION_LISTENER_SETTINGS");
        startActivity(intent);

    }

    @Override
    public void onRequestPermissionsResult(int requestCode,
                                           String permissions[], int[] grantResults) {
        switch (requestCode) {
            case REQUEST_READ_PHONE_STATE: {
                // If request is cancelled, the result arrays are empty.
                if (grantResults.length > 0
                        && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    Toast.makeText(this,"Great. You can get call notifications",Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(this,"Sorry you cant get call notifications",Toast.LENGTH_SHORT).show();
                }
                return;
            }

            case REQUEST_READ_SMS_PERMISSION: {
                // If request is cancelled, the result arrays are empty.
                if (grantResults.length > 0
                        && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    Toast.makeText(this,"Great. You can get sms notifications",Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(this,"Sorry you cant get sms notifications",Toast.LENGTH_SHORT).show();
                }
                return;
            }
        }
    }

    public void openAppList(View view){
        Intent myIntent = new Intent(this,AppGridDisplay.class);
        startActivity(myIntent);
    }

    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        if (hasFocus) {
            getWindow().getDecorView().setSystemUiVisibility(
                    View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                            | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                            | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                            | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                            | View.SYSTEM_UI_FLAG_FULLSCREEN
                            | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY);
        }
    }
}
