package com.example.kundenapp;

import android.os.Bundle;

import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;

import com.example.kundenapp.databinding.ActivityFaqBinding;

public class FaqActivity extends AppCompatActivity {

    private ActivityFaqBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityFaqBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


    }
}