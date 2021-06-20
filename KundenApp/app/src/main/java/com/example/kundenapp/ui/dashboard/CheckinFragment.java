package com.example.kundenapp.ui.dashboard;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.kundenapp.MyApp;
import com.example.kundenapp.R;
import com.example.kundenapp.State;
import com.example.kundenapp.databinding.FragmentCheckinBinding;



public class CheckinFragment extends Fragment {

    FragmentCheckinBinding binding;
    State state;

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        state = ((MyApp)getActivity().getApplication()).getState();


    binding = FragmentCheckinBinding.inflate(inflater, container, false);
    View root = binding.getRoot();
        return root;
}

    public void onViewCreated(View view, Bundle savedInstanceState){
        super.onViewCreated(view, savedInstanceState);

        binding.acceptId4.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                state.checkin_active = true;
                Navigation.findNavController(v).navigate(R.id.action_checkinFragment_to_checkinsFragment);
            }
        });


    }



}