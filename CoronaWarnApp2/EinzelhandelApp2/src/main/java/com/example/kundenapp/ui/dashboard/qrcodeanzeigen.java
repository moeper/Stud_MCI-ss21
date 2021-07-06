package com.example.kundenapp.ui.dashboard;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.kundenapp.Global;
import com.example.kundenapp.R;
import com.example.kundenapp.databinding.FragmentBeforeQrCodeBinding;
import com.example.kundenapp.databinding.FragmentQrcodeanzeigenBinding;

public class qrcodeanzeigen extends Fragment {


    private FragmentQrcodeanzeigenBinding binding;
    private FragmentBeforeQrCodeBinding binding1;
    TextView textView;
    Button pdfButton;
    Button deleteQrCodeButton;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentQrcodeanzeigenBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        textView = binding.qrcodeInput;
        textView.setText("Veranstalltungsname: "+Global.getName() + "\nTypische Aufenthaltsdauer: "+ Global.getDauer().toString() +"\nFläche: "+ Global.getFlaeche());
        // Inflate the layout for this fragment

        deleteQrCodeButton = binding.deleteQrCodeButton;
        deleteQrCodeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Global.setQrCodeCreated(false);
                AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
                builder.setTitle("Der QR-Code wurde erfolgreich gelöscht!");
                builder.setIcon(R.drawable.check);
                builder.setPositiveButton(
                        "OK", (dialogInterface, i) -> dialogInterface.dismiss());
                builder.show();
                Navigation.findNavController(v).navigate(R.id.action_qrcodeanzeigen_to_navigation_dashboard);

            }
        });

        pdfButton = binding.pdfButton;
        pdfButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Navigation.findNavController(v).navigate(R.id.action_qrcodeanzeigen_to_showPdfFragment);

            }
        });


        return root;
    }
}