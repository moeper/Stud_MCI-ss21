package com.example.application.listview;

import android.app.AlertDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class LoginActivity extends AppCompatActivity {

    EditText email;
    EditText password;
    Button loginButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        email = findViewById(R.id.emailId);
        password = findViewById(R.id.passwortId);

        loginButton = findViewById(R.id.loginId);
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (email.getText().toString().equals("") && password.getText().toString().equals("")){
                    login();
                }else {
                    AlertDialog.Builder builder = new AlertDialog.Builder(LoginActivity.this);
                    builder.setTitle("Anmeldungsproblem!");
                    builder.setMessage("Email Adresse oder das Passwort");
                    builder.setPositiveButton(
                            "OK", (dialogInterface, i) -> dialogInterface.dismiss());
                    builder.show();
                }
            }
        });
    }

    public void login(){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}