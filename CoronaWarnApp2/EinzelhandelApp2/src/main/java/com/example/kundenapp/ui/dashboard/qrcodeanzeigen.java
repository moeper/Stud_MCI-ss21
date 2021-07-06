package com.example.kundenapp.ui.dashboard;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.kundenapp.R;
import com.example.kundenapp.databinding.FragmentQrcodeanzeigenBinding;

public class qrcodeanzeigen extends Fragment {


    private FragmentQrcodeanzeigenBinding binding;

    TextView textView;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        textView = binding.qrcodeInput;
        textView.setText(DashboardFragment.name + DashboardFragment.flaeche + DashboardFragment.dauer);
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_qrcodeanzeigen, container, false);
    }
}