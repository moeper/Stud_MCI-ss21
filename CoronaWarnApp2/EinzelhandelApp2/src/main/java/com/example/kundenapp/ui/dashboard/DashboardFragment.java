package com.example.kundenapp.ui.dashboard;

import android.app.AlertDialog;
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

import com.example.kundenapp.Global;
import com.example.kundenapp.R;
import com.example.kundenapp.databinding.FragmentDashboardBinding;
import com.example.kundenapp.databinding.FragmentHomeBinding;
import com.example.kundenapp.databinding.FragmentQrcodeanzeigenBinding;

public class DashboardFragment extends Fragment {

    private DashboardViewModel dashboardViewModel;
    private FragmentDashboardBinding binding;
    private FragmentQrcodeanzeigenBinding binding1;


    public static Integer flaeche, dauer;
    public static String name;

    EditText inputFlaeche;
    EditText inputDauer;
    EditText inputName;


    Button button;

    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentDashboardBinding.inflate(inflater, container, false);
        binding1 = FragmentQrcodeanzeigenBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        if (Global.isQrCodeCreated() == true){
            root = binding1.getRoot();
        }

        inputFlaeche = binding.inputFlaeche;
        inputName = binding.inputName;
        inputDauer = binding.inputDauer;

        button = binding.erstellen;
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(!inputFlaeche.getText().toString().isEmpty() && !inputDauer.getText().toString().isEmpty() && !inputName.getText().toString().isEmpty()) {
                    flaeche = Integer.parseInt(inputFlaeche.getText().toString());
                    Global.setFlaeche(flaeche);
                    dauer = Integer.parseInt(inputDauer.getText().toString());
                    Global.setDauer(dauer);
                    name = inputName.getText().toString();
                    Global.setName(name);
                    Global.setQrCodeCreated(true);
                    Navigation.findNavController(v).navigate(R.id.action_navigation_dashboard_to_qrcodeanzeigen);
                }else{
                    AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
                    builder.setTitle("Fehlgeschlagen!");
                    builder.setMessage("Bitte geben Sie die Fläche Ihres Ladenlokales, sowie der Name und die typische Aufenthaltsdauer");
                    builder.setIcon(R.drawable.problem);
                    builder.setPositiveButton(
                            "OK", (dialogInterface, i) -> dialogInterface.dismiss());
                    builder.show();
                }
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