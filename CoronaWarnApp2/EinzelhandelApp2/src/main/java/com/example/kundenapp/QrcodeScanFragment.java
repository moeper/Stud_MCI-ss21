package com.example.kundenapp;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


public class QrcodeScanFragment extends Fragment {

    private Handler handler = new Handler();

    private Runnable runnable = () -> {

            Navigation.findNavController(this.getView()).navigate(R.id.action_qrcodeScanFragment_to_checkinFragment);

    };

    /*@Override
    protected void onResume() {
        super.onResume();
        handler.postDelayed(runnable,2000);
    }
    @Override
    protected void onPause(){
        super.onPause();
        handler.removeCallbacks(runnable);
    }*/

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        handler.postDelayed(runnable, 1000);
        return inflater.inflate(R.layout.fragment_qrcode_scan, container, false);
    }
}