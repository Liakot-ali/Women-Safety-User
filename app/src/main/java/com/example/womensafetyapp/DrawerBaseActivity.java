package com.example.womensafetyapp;

import android.content.Intent;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import com.example.womensafetyapp.Chatting.ActivityChatMessage;
import com.example.womensafetyapp.Support.ActivitySupportMessage;
import com.google.android.material.navigation.NavigationView;
import com.google.firebase.auth.FirebaseAuth;


public class DrawerBaseActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    DrawerLayout drawerLayout;


    @Override
    public void setContentView(View view) {
        drawerLayout = (DrawerLayout) getLayoutInflater().inflate(R.layout.activity_drawer_base, null);
        FrameLayout container = drawerLayout.findViewById(R.id.activityContainer);
        container.addView(view);
        super.setContentView(drawerLayout);

        Toolbar toolbar = drawerLayout.findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        NavigationView navigationView = drawerLayout.findViewById(R.id.navigationview);
        navigationView.setNavigationItemSelectedListener(this);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.open, R.string.close);

        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        drawerLayout.closeDrawer(GravityCompat.START);
        switch (item.getItemId()) {
            case R.id.nav_home:
                startActivity(new Intent(this, HomeActivity.class));
                overridePendingTransition(0, 0);
                break;
            case R.id.nav_profile:
                startActivity(new Intent(this, ProfileActivity.class));
                overridePendingTransition(0, 0);
                break;
            case R.id.nav_complaint:
                startActivity(new Intent(this, ComplaintActivity.class));
                overridePendingTransition(0, 0);
                break;
            case R.id.nav_chat:
                startActivity(new Intent(this, ActivityChatMessage.class));
                overridePendingTransition(0, 0);
                break;
            case R.id.nav_support:
                startActivity(new Intent(this, ActivitySupportMessage.class));
                overridePendingTransition(0, 0);
                break;
            case R.id.nav_danger:
                startActivity(new Intent(this, Emergency1.class));
                overridePendingTransition(0, 0);
                break;
            case R.id.nav_sign_out:
                FirebaseAuth auth = FirebaseAuth.getInstance();
                auth.signOut();
                onBackPressed();
        }
        return false;
    }
    protected void allocateActivityTitle(String titleString) {
        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle(titleString);
        }
    }
}