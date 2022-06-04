package com.example.womensafetyapp;

import android.os.Bundle;

import com.example.womensafetyapp.databinding.ActivitySupportBinding;


public class SupportActivity extends DrawerBaseActivity {
    ActivitySupportBinding activitySupportBinding;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activitySupportBinding= ActivitySupportBinding.inflate(getLayoutInflater());
        setContentView(activitySupportBinding.getRoot());
        allocateActivityTitle("Support");

    }
}