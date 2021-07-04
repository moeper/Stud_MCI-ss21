package com.example.kundenapp.ui.dashboard;

import android.content.Context;
import android.os.Bundle;

import androidx.core.content.ContextCompat;
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


public class CheckinrenewalFragment extends Fragment {
    private FragmentCheckinrenewalBinding binding;
    private State state;
    private Integer durationextention;
    View root;
    private Integer buttonFocus;
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

    private void changeButtonColor(Integer id, View v){
        if(buttonFocus != null) {
            ((Button) root.findViewById(buttonFocus)).
                    setBackgroundTintList(ContextCompat.getColorStateList(v.getContext(), R.color.AppGrey));
        }

        buttonFocus = id;
        ((Button) root.findViewById(id)).
                setBackgroundTintList(ContextCompat.getColorStateList(v.getContext(), R.color.AppGruenDunkel));
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
                buttonFocus = null;
                Navigation.findNavController(v).navigate(R.id.action_checkinrenewalFragment2_to_checkinsFragment);

            }
        });



        // 10min
        binding.acceptId101.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                durationextention = 10;
                changeButtonColor(R.id.acceptId101, v);
            }
        });

        //30min
        binding.acceptId102.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                durationextention = 30;
                changeButtonColor(R.id.acceptId102, v);
            }
        });

        //60min
        binding.acceptId103.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                durationextention = 60;
                changeButtonColor(R.id.acceptId103, v);
            }
        });

        //180min
        binding.acceptId104.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                durationextention = 180;
                changeButtonColor(R.id.acceptId104, v);
            }
        });
        // ende
        binding.acceptId105.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                durationextention = 0;
                changeButtonColor(R.id.acceptId105, v);
            }
        });
    }
}