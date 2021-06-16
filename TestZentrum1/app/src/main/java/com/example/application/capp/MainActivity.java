package com.example.application.capp;


import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

public class MainActivity extends AppCompatActivity {

    private Handler handler = new Handler();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    private Runnable runnable = () -> {
        if (!isFinishing()){
            startActivity(new Intent(getApplicationContext(), PrivacyActivity.class));
            finish();
        }
    };


    @Override
    protected void onResume() {
        super.onResume();
        handler.postDelayed(runnable,2000);
    }
    @Override
    protected void onPause(){
        super.onPause();
        handler.removeCallbacks(runnable);
    }
}