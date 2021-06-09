package com.example.test_zentrum;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;

public class AddTestActivity extends AppCompatActivity {

    Button kunScan;
    Button tesScan;

    TestsActivity testsActivity;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_test);

        kunScan = findViewById(R.id.kundeQrCodeId);
        tesScan = findViewById(R.id.testQrCodeId);

        tesScan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                IntentIntegrator intentIntegrator = new IntentIntegrator(
                        AddTestActivity.this
                );

                intentIntegrator.setPrompt("Drücken Sie auf Lauter Taste, um das Flash anzuschalten");
                intentIntegrator.setBeepEnabled(true);
                intentIntegrator.setOrientationLocked(true);
                intentIntegrator.setCaptureActivity(Capture.class);
                intentIntegrator.initiateScan();
            }
        });


        kunScan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                IntentIntegrator intentIntegrator = new IntentIntegrator(
                        AddTestActivity.this
                );

                intentIntegrator.setPrompt("Drücken Sie auf Lauter Taste, um das Flash anzuschalten");
                intentIntegrator.setBeepEnabled(true);
                intentIntegrator.setOrientationLocked(true);
                intentIntegrator.setCaptureActivity(Capture.class);
                intentIntegrator.initiateScan();
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        IntentResult intentResult = IntentIntegrator.parseActivityResult(
                requestCode,resultCode,data
        );
        if(intentResult.getContents() != null){
            AlertDialog.Builder builder = new AlertDialog.Builder(
                    AddTestActivity.this
            );

            builder.setTitle("Result");
            Test test = new Test();
            test.setPersonId(intentResult.getContents());
            testsActivity.tests.add(test);
            builder.setMessage(intentResult.getContents());
            builder.setPositiveButton(
                    "OK", (dialogInterface, i) -> dialogInterface.dismiss());
            builder.show();
        }else {
            Toast.makeText(getApplicationContext(), "Sie haben leider nichts gescannt!", Toast.LENGTH_SHORT).show();
        }
    }
}