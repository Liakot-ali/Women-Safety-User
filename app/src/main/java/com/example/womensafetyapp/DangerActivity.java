package com.example.womensafetyapp;

import android.os.Bundle;

import com.example.womensafetyapp.databinding.ActivityDangerBinding;


public class DangerActivity extends DrawerBaseActivity {
    ActivityDangerBinding activityDangerBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityDangerBinding= ActivityDangerBinding.inflate(getLayoutInflater());
        setContentView(activityDangerBinding.getRoot());
        allocateActivityTitle("Danger");
    }
}