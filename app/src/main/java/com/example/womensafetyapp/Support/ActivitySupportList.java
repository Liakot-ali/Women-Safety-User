package com.example.womensafetyapp.Support;

import android.os.Bundle;

import com.example.womensafetyapp.DrawerBaseActivity;
import com.example.womensafetyapp.databinding.ActivitySupportListBinding;


public class ActivitySupportList extends DrawerBaseActivity {
    ActivitySupportListBinding activitySupportBinding;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activitySupportBinding = ActivitySupportListBinding.inflate(getLayoutInflater());
        setContentView(activitySupportBinding.getRoot());
        allocateActivityTitle("Support");
    }
}