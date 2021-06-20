package com.example.myapp;

import android.content.Intent;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class ActivityQrErstellen extends AppCompatActivity {
    private Button buttonPdf;
    private Button buttonZeigen;

    private Button home;
    private Button qrCode;
    private Button verlauf;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_qr_erstellen);

        buttonPdf = findViewById(R.id.buttonQrPdf);
        buttonPdf.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openQrPdf();
            }
        });

        buttonZeigen = findViewById(R.id.buttonQrZeigen);
        buttonZeigen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openQrZeigen();
            }
        });

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
                openQrCode();
            }
        });

        verlauf = findViewById(R.id.verlauf);
        verlauf.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openVerlauf();
            }
        });
    }

    public void openQrPdf(){
        Intent intent = new Intent(this, ActivityPdf.class);
        startActivity(intent);
    }

    public void openQrZeigen(){
        Intent intent = new Intent(this, ActivityQrZeigen.class);
        startActivity(intent);
    }

    public void openStartseite(){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    public void openQrCode(){
        Intent intent = new Intent(this, ActivityQrSeite.class);
        startActivity(intent);
    }

    public void openVerlauf(){
        Intent intent = new Intent(this, ActivityVerlauf.class);
        startActivity(intent);
    }
}
