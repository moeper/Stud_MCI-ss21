package com.example.kundenapp.ui.notifications;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.kundenapp.R;
import com.example.kundenapp.databinding.FragmentCheckinBinding;
import com.example.kundenapp.databinding.FragmentTestmeBinding;


public class TestmeFragment extends Fragment {
    FragmentTestmeBinding binding;

    public TestmeFragment() {
        // Required empty public constructor
    }


    public static TestmeFragment newInstance(String param1, String param2) {
        TestmeFragment fragment = new TestmeFragment();

        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentTestmeBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        return root;

    }

    public void onViewCreated(View view, Bundle savedInstanceState){
        super.onViewCreated(view, savedInstanceState);

        binding.acceptId377.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Navigation.findNavController(v).navigate(R.id.action_fragment_testnegativ_to_navigation_notifications);
            }
        });


    }
}