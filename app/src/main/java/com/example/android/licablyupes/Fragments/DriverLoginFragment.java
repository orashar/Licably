package com.example.android.licablyupes.Fragments;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.android.licablyupes.DriverHomePage;
import com.example.android.licablyupes.DriverRegisterActivity;
import com.example.android.licablyupes.R;

public class DriverLoginFragment extends Fragment {

    public DriverLoginFragment(){}

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View driverLoginView = inflater.inflate(R.layout.driver_login_layout, container, false);

        Button btn = driverLoginView.findViewById(R.id.driver_login_btn);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), DriverHomePage.class);
                startActivity(intent);
            }
        });

        Button regBtn = driverLoginView.findViewById(R.id.driver_register_btn);
        regBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), DriverRegisterActivity.class);
                startActivity(intent);
            }
        });

        return driverLoginView;
    }
}
