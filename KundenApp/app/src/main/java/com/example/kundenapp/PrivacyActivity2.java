package com.example.kundenapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

public class PrivacyActivity2 extends AppCompatActivity {

    Button acceptBut;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();
        setContentView(R.layout.activity_privacy2);

        acceptBut = findViewById(R.id.acceptId);

        acceptBut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivity();
            }
        });

    }
    public void openActivity(){
        Intent intent = new Intent(this, FirstStartActivity.class);
        startActivity(intent);
    }
}