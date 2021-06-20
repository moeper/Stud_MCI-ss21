package com.example.kundenapp.ui.dashboard;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.kundenapp.MyApp;
import com.example.kundenapp.R;
import com.example.kundenapp.State;
import com.example.kundenapp.databinding.FragmentCheckinBinding;
import com.example.kundenapp.databinding.FragmentCheckinsBinding;
import com.example.kundenapp.databinding.FragmentDashboardBinding;


public class CheckinsFragment extends Fragment {

    private FragmentCheckinsBinding binding;
    View root;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        binding = FragmentCheckinsBinding.inflate(inflater, container, false);
        root = binding.getRoot();

        //((TextView) root.findViewById(R.id.textView35)).setVisibility(View.GONE);
        ((TextView) root.findViewById(R.id.textView35)).setText("Kein Checkin registriert");
        ((TextView) root.findViewById(R.id.textView36)).setVisibility(View.GONE);
        ((TextView) root.findViewById(R.id.textView37)).setVisibility(View.GONE);
        ((TextView) root.findViewById(R.id.textView38)).setVisibility(View.GONE);
        ((TextView) root.findViewById(R.id.textView24)).setVisibility(View.GONE);
        ((TextView) root.findViewById(R.id.textView39)).setVisibility(View.GONE);
        ((Button) root.findViewById(R.id.acceptId12)).setVisibility(View.GONE);

        /**/


        /*TextView text = (TextView) root.findViewById(R.id.textView35);
        text.setText("test");*/
        return root;
    }

    public void onResume() {

        super.onResume();
        State state = ((MyApp)getActivity().getApplication()).getState();

        if(state.checkin_active == true) {

            //((TextView) root.findViewById(R.id.textView35)).setVisibility(View.VISIBLE);
            ((TextView) root.findViewById(R.id.textView35)).setText("H&M - Köln");
            ((TextView) root.findViewById(R.id.textView36)).setVisibility(View.VISIBLE);
            ((TextView) root.findViewById(R.id.textView37)).setVisibility(View.VISIBLE);
            ((TextView) root.findViewById(R.id.textView38)).setVisibility(View.VISIBLE);
            ((TextView) root.findViewById(R.id.textView24)).setVisibility(View.VISIBLE);
            ((TextView) root.findViewById(R.id.textView39)).setVisibility(View.VISIBLE);
            ((Button) root.findViewById(R.id.acceptId12)).setVisibility(View.VISIBLE);
        }else{
            ((TextView) root.findViewById(R.id.textView35)).setText("Kein Checkin registriert");
            ((TextView) root.findViewById(R.id.textView36)).setVisibility(View.GONE);
            ((TextView) root.findViewById(R.id.textView37)).setVisibility(View.GONE);
            ((TextView) root.findViewById(R.id.textView38)).setVisibility(View.GONE);
            ((TextView) root.findViewById(R.id.textView24)).setVisibility(View.GONE);
            ((TextView) root.findViewById(R.id.textView39)).setVisibility(View.GONE);
            ((Button) root.findViewById(R.id.acceptId12)).setVisibility(View.GONE);
        }
    }

    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        //((TextView) view.findViewById(R.id.textView35)).setText("");


        binding.acceptId5.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Navigation.findNavController(v).navigate(R.id.action_checkinsFragment_to_qrcodeScanFragment);

            }
        });

        binding.acceptId12.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Navigation.findNavController(v).navigate(R.id.action_checkinsFragment_to_checkinrenewalFragment2);

            }
        });
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

}