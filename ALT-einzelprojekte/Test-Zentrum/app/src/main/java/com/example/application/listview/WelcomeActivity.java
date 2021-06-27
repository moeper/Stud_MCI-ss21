package com.example.application.listview;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;

public class WelcomeActivity extends AppCompatActivity {


        private Handler handler = new Handler();


//        Timer timer;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_welcome);
        }

        private Runnable runnable = () -> {
            if (!isFinishing()) {
                startActivity(new Intent(getApplicationContext(), PrivacyActivity.class));
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
