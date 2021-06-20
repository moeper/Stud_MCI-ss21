package com.example.kundenapp.ui.dashboard;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.kundenapp.R;
import com.example.kundenapp.databinding.FragmentCheckinBinding;
import com.example.kundenapp.databinding.FragmentCheckinsBinding;
import com.example.kundenapp.databinding.FragmentDashboardBinding;


public class CheckinsFragment extends Fragment {

    private FragmentCheckinsBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentCheckinsBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        return root;
    }

    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        binding.acceptId5.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                /*Fragment testnegativeFragment = new TestnegativFragment();
                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.nav_host_fragment_activity_main, testnegativeFragment);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();*/

                Navigation.findNavController(v).navigate(R.id.action_checkinsFragment_to_qrcodeScanFragment);


            }
        });
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

}