package com.example.kundenapp.ui.dashboard;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import com.example.kundenapp.MyApp;
import com.example.kundenapp.R;
import com.example.kundenapp.State;
import com.example.kundenapp.databinding.FragmentCheckindurationBinding;
import com.example.kundenapp.databinding.FragmentCheckinrenewalBinding;


public class CheckindurationFragment extends Fragment {
    private FragmentCheckindurationBinding binding;
    private State state;
    private Integer duration;
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
        binding = FragmentCheckindurationBinding.inflate(inflater, container, false);
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

        changeButtonColor(R.id.acceptId185, view);
        duration = 20;

        binding.acceptId68.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                state.checkin_duration = duration;

                buttonFocus = null;
                Navigation.findNavController(v).navigate(R.id.action_checkindurationFragment_to_checkinsFragment);

            }
        });



        // 10min
        binding.acceptId181.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                duration = 10;
                changeButtonColor(R.id.acceptId181, v);
            }
        });

        //30min
        binding.acceptId182.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                duration = 30;
                changeButtonColor(R.id.acceptId182, v);
            }
        });

        //60min
        binding.acceptId183.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                duration = 60;
                changeButtonColor(R.id.acceptId183, v);
            }
        });

        //180min
        binding.acceptId184.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                duration = 180;
                changeButtonColor(R.id.acceptId184, v);
            }
        });
        // ende
        binding.acceptId185.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                duration = 20;
                changeButtonColor(R.id.acceptId185, v);
            }
        });
    }
}