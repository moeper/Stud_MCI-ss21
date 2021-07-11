package com.example.application.listview;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import static com.example.application.listview.MainActivity.testList;

public class testEvaluate extends AppCompatActivity {

    TextView textView;
    Button positivButton;
    Button negativButton;

    Test test;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_evaluate);

        textView = findViewById(R.id.id);
        positivButton = findViewById(R.id.positivButton);
        negativButton = findViewById(R.id.negativButton);

        Intent intent = getIntent();



        if (intent.getExtras() != null){
            test = (Test) intent.getSerializableExtra("test");

            textView.setText(test.getTestId());
        }

        positivButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                for (int i=0; i<testList.size();i++){
                    if (testList.get(i).getTestId().equals(test.getTestId())){
                        testList.get(i).setTestResult(TestState.POSITIV);
                        testList.get(i).setIcon(R.drawable.ic_positiv);

                    }
                }
                openActivity();

            }
        });

        negativButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                for (int i=0; i<testList.size();i++){
                    if (testList.get(i).getTestId().equals(test.getTestId())){
                        testList.get(i).setTestResult(TestState.NEGATIV);
                        testList.get(i).setIcon(R.drawable.ic_negativ);

                    }
                }
                openActivity();
            }
        });

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.infos, menu);

        return true;
    }
    public void openActivity(){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}