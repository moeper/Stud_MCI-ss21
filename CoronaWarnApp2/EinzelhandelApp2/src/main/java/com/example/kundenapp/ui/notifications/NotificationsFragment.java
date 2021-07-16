package com.example.kundenapp.ui.notifications;

import android.app.AlertDialog;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.DialogInterface;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;
/**--------------------------------------------------------**/

import android.widget.Button;

import android.widget.ListView;
import android.widget.TextView;


import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.UUID;
/**--------------------------------------------------------**/

import com.example.kundenapp.Global;
import com.example.kundenapp.R;

import com.example.kundenapp.databinding.FragmentBeforeQrCodeBinding;
import com.example.kundenapp.databinding.FragmentNotificationsBinding;

import org.jetbrains.annotations.NotNull;


public class NotificationsFragment extends Fragment{



    TextView textView;

    private NotificationsViewModel notificationsViewModel;
    private FragmentBeforeQrCodeBinding binding1;
    private FragmentNotificationsBinding binding;

    Integer increment = 0;


    @RequiresApi(api = Build.VERSION_CODES.O)
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        notificationsViewModel =
                new ViewModelProvider(this).get(NotificationsViewModel.class);

        binding = FragmentNotificationsBinding.inflate(inflater, container, false);
        binding1 = FragmentBeforeQrCodeBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        textView = root.findViewById(R.id.textView16);

        //textView = binding.textView16;

        Random rand = new Random();
        increment= rand.nextInt(20);
        textView.setText(increment.toString());

        if (Build.VERSION.SDK_INT>= Build.VERSION_CODES.O){
            NotificationChannel channel = new NotificationChannel("My Notification", "My Notification", NotificationManager.IMPORTANCE_DEFAULT );
            NotificationManager manager = getContext().getSystemService(NotificationManager.class);
            manager.createNotificationChannel(channel);
        }
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NotificationCompat.Builder builder = new NotificationCompat.Builder(getContext(), "My Notification");
                builder.setContentTitle("Warnung");
                builder.setContentText("Warnung, bitte lassen Sie sich so schnell wie möglich testen. Das Risiko, dass Sie mit einem Infizierten begegnet haben ist sehr hoch!");
                builder.setAutoCancel(true);

                NotificationManagerCompat managerCompat = NotificationManagerCompat.from(getContext());
                managerCompat.notify(1,builder.build());
            }
        });


        if (Global.isQrCodeCreated()==false){
            root = binding1.getRoot();
        }

        //binding.datumTextViewId.setText(LocalDateTime.now().toString());

        return root;
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }


}