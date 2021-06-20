package com.example.kundenapp.ui.dashboard;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.kundenapp.R;
import com.example.kundenapp.databinding.FragmentCheckinBinding;
import com.example.kundenapp.databinding.FragmentHomeBinding;


public class CheckinFragment extends Fragment {
    FragmentCheckinBinding binding;
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

    binding = FragmentCheckinBinding.inflate(inflater, container, false);
    View root = binding.getRoot();
        return root;
}

    public void onViewCreated(View view, Bundle savedInstanceState){
        super.onViewCreated(view, savedInstanceState);

        binding.acceptId4.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Navigation.findNavController(v).navigate(R.id.action_checkinFragment_to_checkinsFragment);
            }
        });
    }



}