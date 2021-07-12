package com.example.application.listview;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;

import android.os.Bundle;

public class TestScannActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_scann);
    }

    private Handler handler = new Handler();


//        Timer timer;

    private Runnable runnable = () -> {
        if (!isFinishing()) {
            startActivity(new Intent(getApplicationContext(), AddTestActivity.class));
            finish();
        }
    };

    @Override
    protected void onResume() {
        super.onResume();
        handler.postDelayed(runnable, 1000);
    }

    @Override
    protected void onPause() {
        super.onPause();
        handler.removeCallbacks(runnable);

    }
}