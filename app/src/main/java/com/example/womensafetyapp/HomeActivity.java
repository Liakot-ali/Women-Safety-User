package com.example.womensafetyapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.cardview.widget.CardView;

import com.example.womensafetyapp.Scholar.ActivityScholarMessage;
import com.example.womensafetyapp.Support.ActivitySupportMessage;
import com.example.womensafetyapp.databinding.ActivityHomeBinding;


public class HomeActivity extends DrawerBaseActivity implements View.OnClickListener {
    ActivityHomeBinding activityHomeBinding;
    private CardView profile, complaint, scholar, support, danger;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityHomeBinding = ActivityHomeBinding.inflate(getLayoutInflater());
        setContentView(activityHomeBinding.getRoot());
        allocateActivityTitle("Home");

        profile = (CardView) findViewById(R.id.profileid);
        complaint = (CardView) findViewById(R.id.complaintid);
        scholar = (CardView) findViewById(R.id.scholarid);
        support = (CardView) findViewById(R.id.supportid);
        danger = (CardView) findViewById(R.id.dangerid);

        profile.setOnClickListener(this);
        complaint.setOnClickListener(this);
        scholar.setOnClickListener(this);
        support.setOnClickListener(this);
        danger.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        Intent i;

        switch (view.getId()) {
            case R.id.profileid:
                i = new Intent(this, Information.class);
                startActivity(i);
                break;
            case R.id.complaintid:
                i = new Intent(this, Complaint2.class);
                startActivity(i);
                break;
            case R.id.scholarid:
                i = new Intent(this, ActivityScholarMessage.class);
                startActivity(i);
                break;
            case R.id.supportid:
                i = new Intent(this, ActivitySupportMessage.class);
                startActivity(i);
                break;
            case R.id.dangerid:
                i = new Intent(this, Emergency1.class);
                startActivity(i);
                break;
            default:
                break;
        }

    }
}