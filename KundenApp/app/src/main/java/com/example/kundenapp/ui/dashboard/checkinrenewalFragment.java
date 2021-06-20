package com.example.kundenapp.ui.dashboard;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.kundenapp.MyApp;
import com.example.kundenapp.R;
import com.example.kundenapp.State;
import com.example.kundenapp.databinding.FragmentCheckinrenewalBinding;
import com.example.kundenapp.databinding.FragmentCheckinsBinding;


public class checkinrenewalFragment extends Fragment {
    private FragmentCheckinrenewalBinding binding;
    private State state;
    private Integer durationextention;
    View root;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        state = ((MyApp)getActivity().getApplication()).getState();
        // Inflate the layout for this fragment
        binding = FragmentCheckinrenewalBinding.inflate(inflater, container, false);
        root = binding.getRoot();
        return root;
    }

    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        binding.acceptId6.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if(durationextention == 0){
                    state.checkin_active = false;
                }else{
                    state.checkin_duration += durationextention;
                }

                Navigation.findNavController(v).navigate(R.id.action_checkinrenewalFragment2_to_checkinsFragment);

            }
        });

        // 10min
        binding.acceptId101.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                durationextention = 10;
                //((Button) root.findViewById(R.id.acceptId101)).setBackgroundColor(0xFF5DB075);
            }
        });

        //30min
        binding.acceptId102.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                durationextention = 30;
                //((Button) root.findViewById(R.id.acceptId102)).setBackgroundColor(0xFF5DB075);
            }
        });

        //60min
        binding.acceptId103.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                durationextention = 60;
                //((Button) root.findViewById(R.id.acceptId103)).setBackgroundColor(0xFF5DB075);
            }
        });

        //180min
        binding.acceptId104.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                durationextention = 180;
                //((Button) root.findViewById(R.id.acceptId104)).setBackgroundColor(0xFF5DB075);
            }
        });
        // ende
        binding.acceptId105.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                durationextention = 0;
                //((Button) root.findViewById(R.id.acceptId105)).setBackgroundColor(0xFF5DB075);
            }
        });
    }
}