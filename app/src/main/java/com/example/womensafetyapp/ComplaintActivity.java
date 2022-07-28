package com.example.womensafetyapp;

import android.os.Bundle;

import com.example.womensafetyapp.databinding.ActivityComplaintBinding;


public class ComplaintActivity extends DrawerBaseActivity {
    ActivityComplaintBinding activityComplaintBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityComplaintBinding= ActivityComplaintBinding.inflate(getLayoutInflater());
        setContentView(activityComplaintBinding.getRoot());
        allocateActivityTitle("Complaint");

    }
}