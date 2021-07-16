package com.example.kundenapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class NotoficationActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notofication);

        TextView textView = findViewById(R.id.notification);
        String message = getIntent().getStringExtra("message");
        textView.setText(message);
    }
}