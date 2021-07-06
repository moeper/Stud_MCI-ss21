package com.example.kundenapp.ui.dashboard;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;

import com.example.kundenapp.R;
import com.example.kundenapp.databinding.FragmentDashboardBinding;
import com.example.kundenapp.databinding.FragmentHomeBinding;

public class DashboardFragment extends Fragment {

    private DashboardViewModel dashboardViewModel;
    private FragmentDashboardBinding binding;

    public static int flaeche, dauer;
    public static String name;

    EditText inputFlaeche;
    EditText inputDauer;
    EditText inputName;


    Button button;

    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentDashboardBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        inputFlaeche = binding.inputFlaeche;
        inputName = binding.inputName;
        inputDauer = binding.inputDauer;

        button = binding.erstellen;
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                flaeche = Integer.parseInt(inputFlaeche.getText().toString());
                dauer = Integer.parseInt(inputDauer.getText().toString());
                name = inputName.getText().toString();
                Navigation.findNavController(v).navigate(R.id.action_navigation_dashboard_to_qrcodeanzeigen);
            }
        });




        return root;
    }

//    public void onViewCreated(View view, Bundle savedInstanceState) {
//        super.onViewCreated(view, savedInstanceState);
//
//        button.setOnClickListener(new View.OnClickListener() {
//            public void onClick(View v) {
//                Navigation.findNavController(v).navigate(R.id.action_navigation_dashboard_to_checkinFragment);
//            }
//        });
//    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}