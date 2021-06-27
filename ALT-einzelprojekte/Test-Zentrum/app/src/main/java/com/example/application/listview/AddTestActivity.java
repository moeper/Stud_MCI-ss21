package com.example.application.listview;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;

import org.jetbrains.annotations.Nullable;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.Comparator;

import static com.example.application.listview.MainActivity.testList;

@RequiresApi(api = Build.VERSION_CODES.O)
public class AddTestActivity extends AppCompatActivity {



    Button kunScan;
    Button tesScan;
    Button save;
    Button cancel;

    EditText editTextKunde;
    EditText editTextTest;
    Test test = new Test(LocalDateTime.now().toString(),"","",TestState.INPROGRESS,R.drawable.ic_inprogress);


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_test);

        kunScan = findViewById(R.id.kundeQrCodeId);
        tesScan = findViewById(R.id.testQrCodeId);
        save = findViewById(R.id.saveId);
        cancel = findViewById(R.id.cancelId);

        tesScan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                IntentIntegrator intentIntegrator = new IntentIntegrator(
                        com.example.application.listview.AddTestActivity.this
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
                        com.example.application.listview.AddTestActivity.this
                );

                intentIntegrator.setPrompt("Drücken Sie auf Lauter Taste, um das Flash anzuschalten");
                intentIntegrator.setBeepEnabled(true);
                intentIntegrator.setOrientationLocked(true);
                intentIntegrator.setCaptureActivity(Capture.class);
                intentIntegrator.initiateScan();
            }
        });



        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivity();
            }
        });


        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (test.getTestId()!=""&& test.getPersonId()!=""){
                    testList.add(test);

                    Collections.sort(testList, new Comparator<Test>() {
                        @Override
                        public int compare(Test o1, Test o2) {
                            return o1.getTestResult().compareTo(o2.getTestResult());
                        }
                    });


                openActivity();
                }
            }
        });
    }
    public void openActivity(){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.infos, menu);

        return true;
    }
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch(item.getItemId()){
            case R.id.aboutApp:
                Intent intent = new Intent(AddTestActivity.this, AboutAppActivity.class);
                startActivity(intent);
                return true;
            case R.id.faq:
                Intent intent2 = new Intent(AddTestActivity.this, FaqActivity.class);
                startActivity(intent2);
                return true;
            case R.id.funkt:
                Intent intent3 = new Intent(AddTestActivity.this, InfosFirstActivity.class);
                startActivity(intent3);
                return true;
            case R.id.privacy:
                Intent intent4 = new Intent(AddTestActivity.this, PrivacyActivity.class);
                startActivity(intent4);
                return true;
            case R.id.howTo:
                Intent intent5 = new Intent(AddTestActivity.this, HowToActivity.class);
                startActivity(intent5);
                return true;
            case R.id.impress:
                Intent intent6 = new Intent(AddTestActivity.this, ImpressActivity.class);
                startActivity(intent6);
                return true;
            default:
                return super.onOptionsItemSelected(item);

        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {

        super.onActivityResult(requestCode, resultCode, data);
        IntentResult intentResult = IntentIntegrator.parseActivityResult(
                requestCode,resultCode,data
        );

        editTextKunde = findViewById(R.id.kundeId_holder);
        editTextTest = findViewById(R.id.testId_holder);

        if(intentResult.getContents() != null){
            AlertDialog.Builder builder = new AlertDialog.Builder(
                    com.example.application.listview.AddTestActivity.this
            );


            builder.setTitle("Result");
            builder.setMessage(intentResult.getContents());
            builder.setPositiveButton(
                    "OK", (dialogInterface, i) -> dialogInterface.dismiss());
            builder.show();

            if (intentResult.getContents().charAt(0) == 'P') {
                editTextKunde.setText(intentResult.getContents());
                test.setPersonId(intentResult.getContents());
            }else if(intentResult.getContents().charAt(0) == 'T'){
                editTextTest.setText(intentResult.getContents());
                test.setTestId(intentResult.getContents());
            }

        }else {
            Toast.makeText(getApplicationContext(), "Sie haben leider nichts gescannt!", Toast.LENGTH_SHORT).show();
        }
    }
}