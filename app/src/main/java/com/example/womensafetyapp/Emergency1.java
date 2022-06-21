package com.example.womensafetyapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

public class Emergency1 extends AppCompatActivity implements View.OnClickListener {
    private CardView location,police,hospital;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_emergency1);

        location = (CardView) findViewById(R.id.locationid);
        police =(CardView) findViewById(R.id.policeid);
        hospital =(CardView) findViewById(R.id.hospitalid);

        location.setOnClickListener(this);
        police.setOnClickListener(this);
        hospital.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        Intent i;

        switch (view.getId()){
            case R.id.locationid : i= new Intent(this,CurrentLocation.class);startActivity(i); break;
            case R.id.policeid : i= new Intent(this,NearbyPolice.class);startActivity(i); break;
            case R.id.hospitalid : i= new Intent(this,NearbyHospital.class);startActivity(i); break;
            default:break;
        }


    }
}


