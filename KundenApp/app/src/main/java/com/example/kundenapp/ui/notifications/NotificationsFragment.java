package com.example.kundenapp.ui.notifications;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;
/**--------------------------------------------------------**/
import android.content.Intent;

import android.widget.Button;

import android.widget.ListView;


import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
/**--------------------------------------------------------**/

import com.example.kundenapp.FaqActivity;
import com.example.kundenapp.R;
import com.example.kundenapp.Test;
import com.example.kundenapp.TestState;
import com.example.kundenapp.TestergebnisNegativActivity;
import com.example.kundenapp.TestmeActivity;
import com.example.kundenapp.databinding.FragmentNotificationsBinding;

import org.jetbrains.annotations.NotNull;


public class NotificationsFragment extends Fragment implements AdapterView.OnItemClickListener{

    Button testRegist;
    ListView listView;
    List<Test> listOfTests = new ArrayList<>();
    public static List<String> testList = new ArrayList<>();

    private NotificationsViewModel notificationsViewModel;
    private FragmentNotificationsBinding binding;

    private String testToString(Test test){
        return test.getTestId().substring(0,20) + " - " + test.getTestResult() + " - " + test.getDateOf();
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        notificationsViewModel =
                new ViewModelProvider(this).get(NotificationsViewModel.class);

        binding = FragmentNotificationsBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        testRegist = binding.newTest;
        testRegist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Test newTest = new Test(LocalDateTime.now().toString(),UUID.randomUUID().toString(),UUID.randomUUID().toString(),TestState.NEGATIV,R.drawable.ic_negativ);
                listOfTests.add(newTest);
                testList.add(testToString(newTest));
                Navigation.findNavController(v).navigate(R.id.action_navigation_notifications_to_fragment_testnegativ);

            }
        });

        return root;
    }

    @Override
    public void onViewCreated(@NonNull @NotNull View view, @Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);



        listView = binding.viewList;
        ArrayAdapter<String> adapter = new ArrayAdapter<>(getActivity(), android.R.layout.simple_list_item_1,testList);

        listView.setAdapter(adapter);
        listView.setOnItemClickListener(this);



    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        if (position==0){
            binding.viewList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                private void onClick(DialogInterface dialogInterface, int i) {
                    dialogInterface.dismiss();
                }

                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    Test getTest = listOfTests.get(position);
                    if (getTest.getTestResult().equals(TestState.NEGATIV)) {
                        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
                        builder.setTitle("Test Ergebnis");
                        builder.setMessage("Ihre Test am " + getTest.getDateOf() + " ist " + getTest.getTestResult().toString());
                        builder.setIcon(R.drawable.ic_negativ);
                        builder.setPositiveButton(
                                "OK", (dialogInterface, i) -> dialogInterface.dismiss());
                        builder.show();
                    }else {
                        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
                        builder.setTitle("Test Ergebnis");
                        builder.setMessage("Ihre Test am " + getTest.getDateOf() + " ist " + getTest.getTestResult().toString());
                        builder.setIcon(R.drawable.ic_positiv);
                        builder.setPositiveButton(
                                "OK", this::onClick);
                        builder.show();
                    }
                }
            });
        }
    }
}