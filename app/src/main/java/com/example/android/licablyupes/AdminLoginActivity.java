package com.example.android.licablyupes;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.android.licablyupes.Fragments.AdminLoginFragment;

public class AdminLoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.container_layout);
        getSupportFragmentManager().beginTransaction().replace(R.id.container, new AdminLoginFragment()).commit();
    }
}
