package com.example.myapp;

import android.content.Intent;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class ActivityInfo extends AppCompatActivity {
    private Button home;
    private Button qrCode;
    private Button verlauf;

    private Button nutzungsbedingung;
    private Button impressum;
    private Button datenschutz;
    private Button ueberApp;
    private Button faq;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);

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

        nutzungsbedingung = findViewById(R.id.nutzungbedingung);
        nutzungsbedingung.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openNutzungsbedingung();
            }
        });

        impressum = findViewById(R.id.impressum);
        impressum.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openImpressum();
            }
        });

        datenschutz = findViewById(R.id.datenschutz);
        datenschutz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openDatenschutz();
            }
        });

        ueberApp = findViewById(R.id.ueberApp);
        ueberApp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openUeberApp();
            }
        });

        faq = findViewById(R.id.faq);
        faq.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openFaq();
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

    public void openNutzungsbedingung(){
        Intent intent = new Intent(this, ActivityNutzungsbedingung.class);
        startActivity(intent);
    }

    public void openImpressum(){
        Intent intent = new Intent(this, ActivityImpressum.class);
        startActivity(intent);
    }

    public void openDatenschutz(){
        Intent intent = new Intent(this, ActivityDatenschutz.class);
        startActivity(intent);
    }

    public void openUeberApp(){
        Intent intent = new Intent(this, ActivityUeberApp.class);
        startActivity(intent);
    }

    public void openFaq(){
        Intent intent = new Intent(this, ActivityFaq.class);
        startActivity(intent);
    }
}
