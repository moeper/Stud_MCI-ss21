package com.example.kundenapp;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class FirstStartActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();
        setContentView(R.layout.activity_first_start1);

        Button button = findViewById(R.id.acceptId01);



        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                openActivity();
//                        String message = "Warnung! bitte lassen Sie sich schnell wie möglich testen, das Risiko, dass Sie mit einem Infizierten in Kontakt waren";
//                        NotificationCompat.Builder builder = new NotificationCompat.Builder(FirstStartActivity.this).setSmallIcon(R.drawable.ic_positiv)
//                                .setContentTitle("Warnung")
//                                .setContentText(message)
//                                .setAutoCancel(true);
//                        Intent intent = new Intent(FirstStartActivity.this, NotificationActivity.class);
//                        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
//                        intent.putExtra("message", message);
//                        PendingIntent pendingIntent = PendingIntent.getActivity(FirstStartActivity.this,0,intent,PendingIntent.FLAG_UPDATE_CURRENT);
//                        builder.setContentIntent(pendingIntent);
//                        NotificationManager notificationManager = (NotificationManager)FirstStartActivity.this.getSystemService(Context.NOTIFICATION_SERVICE);
            }
        });

    }
    public void openActivity(){
        Intent intent = new Intent(this, FirstStart2Activity.class);
        startActivity(intent);
    }
}