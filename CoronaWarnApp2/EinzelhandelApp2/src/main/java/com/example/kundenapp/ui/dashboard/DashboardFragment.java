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

    int flaeche, dauer;
    String name;

    EditText inputFlaeche;
    EditText inputDauer;
    EditText inputName;


    Button button;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentDashboardBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        inputFlaeche = binding.input1;
        inputName = binding.input3;
        inputDauer = binding.input2;

        button = binding.erstellen;
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                flaeche = Integer.parseInt(inputFlaeche.getText().toString());
                dauer = Integer.parseInt(inputDauer.getText().toString());
                name = inputName.getText().toString();
            }
        });




        return root;
    }

    /*public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        binding.button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                /*Fragment testnegativeFragment = new TestnegativFragment();
                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.nav_host_fragment_activity_main, testnegativeFragment);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();

                Navigation.findNavController(v).navigate(R.id.action_checkinsFragment_to_qrcodeScanFragment);


            }
        });
    }*/

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}