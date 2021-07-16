package com.example.kundenapp.ui.home;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import androidx.annotation.NonNull;
import androidx.core.app.NotificationCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.navigation.Navigation;

import com.example.kundenapp.FaqActivity;
import com.example.kundenapp.FirstStartActivity;
import com.example.kundenapp.NotificationActivity;
import com.example.kundenapp.R;
import com.example.kundenapp.databinding.FragmentHomeBinding;
import com.example.kundenapp.databinding.FragmentNotificationsBinding;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment {

    private HomeViewModel homeViewModel;
    private FragmentHomeBinding binding;
    Button rules;
    Spinner spnBl1;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        binding.warnlogoId.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String message = "Warnung! bitte lassen Sie sich schnell wie möglich testen, das Risiko, dass Sie mit einem Infizierten in Kontakt waren";
                NotificationCompat.Builder builder = new NotificationCompat.Builder(getContext()).setSmallIcon(R.drawable.ic_positiv)
                        .setContentTitle("Warnung")
                        .setContentText(message)
                        .setAutoCancel(true);
                Intent intent = new Intent(getContext(), NotificationActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                intent.putExtra("message", message);
                PendingIntent pendingIntent = PendingIntent.getActivity(getContext(),0,intent,PendingIntent.FLAG_UPDATE_CURRENT);
                builder.setContentIntent(pendingIntent);
                NotificationManager notificationManager = (NotificationManager)getContext().getSystemService(Context.NOTIFICATION_SERVICE);
            }
        });
        /*homeViewModel =
                new ViewModelProvider(this).get(HomeViewModel.class);

        binding = FragmentHomeBinding.inflate(inflater, container, false);
        View root = binding.getRoot();



        //final TextView textView = binding.textHome;
        homeViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                //textView.setText(s);
            }
        });
        return root;*/

        //binding = FragmentHomeBinding.inflate(getLayoutInflater());
        //return binding.getRoot();
        binding = FragmentHomeBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        spnBl1 = root.findViewById(R.id.spinnerbl1);
        List<String> bl = new ArrayList<>();
        bl.add("Baden Württemberg");
        bl.add("Bayern");
        bl.add("Berlin");
        bl.add("Brandenburg");
        bl.add("Bremen");
        bl.add("Hamburg");
        bl.add("Hessen");
        bl.add("Mecklenburg-Vorpommern");
        bl.add("Niedersachsen");
        bl.add("Nordrhein Westfalen");
        bl.add("Rheinland-Pfalz");
        bl.add("Saarland");
        bl.add("Sachsen");
        bl.add("Sachsen-Anhalt");
        bl.add("Schleswig-Holstein");
        bl.add("Thüringen");

        ArrayAdapter<String> blAdapter = new ArrayAdapter<>(this.getActivity(), R.layout.spinner1, bl);
        blAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spnBl1.setAdapter(blAdapter);
        return root;
    }

    public void onViewCreated(View view, Bundle savedInstanceState){
        super.onViewCreated(view, savedInstanceState);



        binding.button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivity();
            }
        });

    }
    public void openActivity(){
        Intent intent = new Intent(getContext(), FaqActivity.class);
        startActivity(intent);

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

    /*public void onDestroy(){
        super.onDestroy();
        binding = null;
    }*/
}