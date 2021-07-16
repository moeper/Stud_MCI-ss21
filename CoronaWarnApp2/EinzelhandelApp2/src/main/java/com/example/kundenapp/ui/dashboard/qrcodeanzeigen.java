package com.example.kundenapp.ui.dashboard;

import android.app.AlertDialog;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;

import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
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
    ImageView imageView;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentQrcodeanzeigenBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        textView = binding.qrcodeInput;
        textView.setText("Veranstalltungsname: "+Global.getName() + "\nTypische Aufenthaltsdauer: "+ Global.getDauer().toString() +"\nFläche: "+ Global.getFlaeche());
        // Inflate the layout for this fragment

//        if (Build.VERSION.SDK_INT>= Build.VERSION_CODES.O){
//            NotificationChannel channel = new NotificationChannel("My Notification", "My Notification", NotificationManager.IMPORTANCE_DEFAULT );
//            NotificationManager manager = getContext().getSystemService(NotificationManager.class);
//            manager.createNotificationChannel(channel);
//        }

//        binding.imageView7.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//                Global.setNotify(true);
//                        NotificationCompat.Builder builder = new NotificationCompat.Builder(getContext(), "My Notification");
//                        builder.setContentTitle("Warnung");
//                        builder.setContentText("Warnung, bitte lassen Sie sich so schnell wie möglich testen. Das Risiko, dass Sie mit einem Infizierten begegnet haben ist sehr hoch!");
//                        builder.setSmallIcon(R.drawable.ic_positiv);
//
//                        NotificationManagerCompat managerCompat = NotificationManagerCompat.from(getContext());
//                        managerCompat.notify(1,builder.build());
//            }
//        });

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