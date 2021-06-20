package com.example.myapp;

import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    private Button home;
    private Button qrCode;
    private Button verlauf;
    private ImageView info;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        home = findViewById(R.id.startseite);
        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openStartseite();
            }
        });

        qrCode = findViewById(R.id.qrseite);
        qrCode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openQrSeite();
            }
        });

        verlauf = findViewById(R.id.verlauf);
        verlauf.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openVerlauf();
            }
        });

        info = findViewById(R.id.info);
        info.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openInfo();
            }
        });
    }

    public void openStartseite(){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    public void openQrSeite(){
        Intent intent = new Intent(this, ActivityQrSeite.class);
        startActivity(intent);
    }

    public void openVerlauf(){
        Intent intent = new Intent(this, ActivityVerlauf.class);
        startActivity(intent);
    }

    public void openInfo(){
        Intent intent = new Intent(this, ActivityInfo.class);
        startActivity(intent);
    }

}
