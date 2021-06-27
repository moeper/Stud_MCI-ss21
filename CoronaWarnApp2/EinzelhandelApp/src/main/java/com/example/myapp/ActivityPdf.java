package com.example.myapp;

import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class ActivityPdf extends AppCompatActivity {
    private ImageView pdf;

    private Button home;
    private Button qrCode;
    private Button verlauf;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pdf);

        pdf = findViewById(R.id.pdf);
        pdf.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openPdfErfolgreich();
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

    public void openPdfErfolgreich(){
        Intent intent = new Intent(this, ActivityPdf2.class);
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
