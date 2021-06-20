package com.example.kundenapp;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.kundenapp.databinding.FragmentCheckinrenewalBinding;
import com.example.kundenapp.databinding.FragmentCheckinsBinding;


public class checkinrenewalFragment extends Fragment {
    private FragmentCheckinrenewalBinding binding;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentCheckinrenewalBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        return root;
    }

    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        binding.acceptId6.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Navigation.findNavController(v).navigate(R.id.action_checkinrenewalFragment2_to_checkinsFragment);

            }
        });
    }
}