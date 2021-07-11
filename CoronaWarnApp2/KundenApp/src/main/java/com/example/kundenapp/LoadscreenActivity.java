package com.example.kundenapp;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.Window;
import android.view.WindowManager;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

//public class LoadscreenActivity extends Activity {
    public class LoadscreenActivity extends AppCompatActivity {

    private Handler handler = new Handler();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();
        setContentView(R.layout.activity_loadscreen);

    }
    private Runnable runnable = () -> {
        if (!isFinishing()){
            startActivity(new Intent(getApplicationContext(), MainActivity.class));
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