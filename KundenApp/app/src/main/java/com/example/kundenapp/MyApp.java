package com.example.kundenapp;

import android.app.Application;
import android.util.Log;

import java.util.ArrayList;

public class MyApp extends Application {

    private State state;

    public MyApp() {
        state = new State();
    }

    public State getState() {
        return state;
    }


}
