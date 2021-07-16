package com.example.kundenapp.ui.notifications;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.os.Build;
import android.os.Bundle;

import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.kundenapp.Global;
import com.example.kundenapp.R;
import com.example.kundenapp.databinding.FragmentCheckinBinding;
import com.example.kundenapp.databinding.FragmentTestmeBinding;


public class TestmeFragment extends Fragment {
    FragmentTestmeBinding binding;

    ImageView imageView;
    public TestmeFragment() {
        // Required empty public constructor
    }


    public static TestmeFragment newInstance(String param1, String param2) {
        TestmeFragment fragment = new TestmeFragment();

        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentTestmeBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        if (Build.VERSION.SDK_INT>= Build.VERSION_CODES.O){
            NotificationChannel channel = new NotificationChannel("My Notification", "My Notification", NotificationManager.IMPORTANCE_DEFAULT );
            NotificationManager manager = getContext().getSystemService(NotificationManager.class);
            manager.createNotificationChannel(channel);
        }

        imageView  = root.findViewById(R.id.imageView5);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Global.setNotify(true);
                NotificationCompat.Builder builder = new NotificationCompat.Builder(getContext(), "My Notification");
                builder.setContentTitle("Warnung");
                builder.setContentText("Warnung, bitte lassen Sie sich so schnell wie möglich testen. Das Risiko, dass Sie mit einem Infizierten begegnet haben ist sehr hoch!");
                builder.setSmallIcon(R.drawable.ic_positiv);

                NotificationManagerCompat managerCompat = NotificationManagerCompat.from(getContext());
                managerCompat.notify(1,builder.build());
            }
        });

        return root;

    }

    public void onViewCreated(View view, Bundle savedInstanceState){
        super.onViewCreated(view, savedInstanceState);

        binding.acceptId377.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Navigation.findNavController(v).navigate(R.id.action_fragment_testnegativ_to_navigation_notifications);
            }
        });


    }
}