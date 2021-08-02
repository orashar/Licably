package com.example.android.licablyupes.Fragments;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.android.licablyupes.AdminHomePage;
import com.example.android.licablyupes.R;

public class AdminLoginFragment extends Fragment {

    public AdminLoginFragment(){}

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View adminLoginView = inflater.inflate(R.layout.admin_login_layout, container, false);

        Button btn = adminLoginView.findViewById(R.id.admin_login_btn);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), AdminHomePage.class);
                startActivity(intent);
            }
        });

        return adminLoginView;
    }
}
