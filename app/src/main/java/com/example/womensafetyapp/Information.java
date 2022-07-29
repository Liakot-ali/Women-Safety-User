package com.example.womensafetyapp;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.UserProfileChangeRequest;

public class Information extends AppCompatActivity {
    private static final String TAG = "InformationActivity";
    EditText name, number, fathersname, address, emergency1, emergency2;

    Button updatebtn;

    String Name = null;
    long Number;
    String Mothers_Name = null;
    String Fathers_Name = null;
    String Permanent_Address = null;
    String Present_Address = null;
    String District = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_information);

        Toolbar toolbar = findViewById(R.id.toolbarid);
        setSupportActionBar(toolbar);

        name = findViewById(R.id.nameid);
        number = findViewById(R.id.numberid);
        fathersname = findViewById(R.id.fathersnameid);
        emergency1 = findViewById(R.id.emergencyContact1);
        emergency2 = findViewById(R.id.emergencyContact2);
        address =  findViewById(R.id.address);

        updatebtn = findViewById(R.id.updateBtn);

        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        if (user != null){
            Log.d(TAG,"onCreate:" + user.getDisplayName());
            if (user.getDisplayName() != null){
                name.setText(user.getDisplayName());
                name.setSelection(user.getDisplayName().length());
            }
        }
    }

    public void updateProfile(View view) {
        view.setEnabled(false);
        Name = name.getText().toString();
        FirebaseUser firebaseUser = FirebaseAuth.getInstance().getCurrentUser();
        UserProfileChangeRequest request= new UserProfileChangeRequest.Builder()
                .setDisplayName(Name)
                .build();

        firebaseUser.updateProfile(request)
                .addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void unused) {
                        view.setEnabled(true);
                        Toast.makeText(Information.this, "Successfully updated profile ", Toast.LENGTH_SHORT).show();
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Log.e(TAG,"onFailure:", e.getCause());
                    }
                });
    }
}