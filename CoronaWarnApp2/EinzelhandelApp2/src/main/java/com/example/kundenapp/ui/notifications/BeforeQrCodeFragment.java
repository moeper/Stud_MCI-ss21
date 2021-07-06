package com.example.kundenapp.ui.notifications;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.kundenapp.R;
import com.example.kundenapp.databinding.FragmentBeforeQrCodeBinding;
import com.example.kundenapp.databinding.FragmentQrcodeanzeigenBinding;

public class BeforeQrCodeFragment extends Fragment {

    private FragmentBeforeQrCodeBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentBeforeQrCodeBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        // Inflate the layout for this fragment
        return root;
    }
}