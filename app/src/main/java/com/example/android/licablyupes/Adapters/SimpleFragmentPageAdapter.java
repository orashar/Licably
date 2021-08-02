package com.example.android.licablyupes.Adapters;

import android.content.Context;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.example.android.licablyupes.Fragments.AdminLoginFragment;
import com.example.android.licablyupes.Fragments.DriverLoginFragment;

public class SimpleFragmentPageAdapter extends FragmentPagerAdapter {

    private Context mContext;

    public SimpleFragmentPageAdapter(Context context, FragmentManager fm){
        super(fm);
        mContext = context;
    }

    @Override
    public Fragment getItem(int position) {
        if(position == 0){
            return new DriverLoginFragment();
        } else{
            return new AdminLoginFragment();
        }
    }

    @Override
    public int getCount() {
        return 2;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        if(position == 0){
            return "Driver";
        } else{
            return "Admin";
        }
    }
}
