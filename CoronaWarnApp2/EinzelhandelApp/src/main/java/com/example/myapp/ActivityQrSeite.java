package com.example.myapp;

import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class ActivityQrSeite extends AppCompatActivity {
    int flaeche, dauer, anzahl;
    String ort;

    private Button button;
    private Button home;
    private Button qrCode;
    private Button verlauf;

    EditText inputFlaeche;
    EditText inputDauer;
    EditText inputAnzahl;
    EditText inputOrt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_qr_seite);

        inputFlaeche = findViewById(R.id.flaeche);
        inputDauer = findViewById(R.id.dauer);
        inputAnzahl = findViewById(R.id.kundenAnzahl);
        inputOrt = findViewById(R.id.ort);

        button = findViewById(R.id.buttonQrErstellen);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivityQrErstellen();

                flaeche = Integer.parseInt(inputFlaeche.getText().toString());
                dauer = Integer.parseInt(inputDauer.getText().toString());
                ort = inputOrt.getText().toString();
                anzahl = Integer.parseInt(inputAnzahl.getText().toString());
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

    public void openActivityQrErstellen(){
        Intent intent = new Intent(this, ActivityQrErstellen.class);
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
