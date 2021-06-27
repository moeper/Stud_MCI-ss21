package com.example.kundenapp;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class InfosFirstActivity extends AppCompatActivity {

    Button acceptBut;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();
        setContentView(R.layout.activity_infos_first);
        acceptBut = findViewById(R.id.acceptBut);

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
