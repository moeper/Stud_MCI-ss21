package com.example.kundenapp.ui.notifications;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;
/**--------------------------------------------------------**/

import android.widget.Button;

import android.widget.ListView;
import android.widget.TextView;


import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
/**--------------------------------------------------------**/

import com.example.kundenapp.Global;
import com.example.kundenapp.R;

import com.example.kundenapp.databinding.FragmentBeforeQrCodeBinding;
import com.example.kundenapp.databinding.FragmentNotificationsBinding;

import org.jetbrains.annotations.NotNull;


public class NotificationsFragment extends Fragment{



    TextView textView;

    private NotificationsViewModel notificationsViewModel;
    private FragmentBeforeQrCodeBinding binding1;
    private FragmentNotificationsBinding binding;


    @RequiresApi(api = Build.VERSION_CODES.O)
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        notificationsViewModel =
                new ViewModelProvider(this).get(NotificationsViewModel.class);

        binding = FragmentNotificationsBinding.inflate(inflater, container, false);
        binding1 = FragmentBeforeQrCodeBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        if (Global.isQrCodeCreated()==false){
            root = binding1.getRoot();
        }

        //binding.datumTextViewId.setText(LocalDateTime.now().toString());

        return root;
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }


}