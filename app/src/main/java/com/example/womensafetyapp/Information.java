package com.example.womensafetyapp;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.example.womensafetyapp.model.ClassUserInfo;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.UserProfileChangeRequest;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

public class Information extends AppCompatActivity {
    private static final String TAG = "InformationActivity";
    EditText name, number, fathersname, address, emergency1, emergency2;
    Button updatebtn;

    String userId;

    String Name = null;
    long Number;
    String Mothers_Name = null;
    String Fathers_Name = null;
    String Permanent_Address = null;
    String Present_Address = null;
    String District = null;

    FirebaseAuth mAuth;
    FirebaseFirestore firestore;
    FirebaseDatabase database;
    DocumentReference userRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_information);
        Initialize();

        updatebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String fullName, phone, father, add, emer1, emer2;
                fullName = name.getText().toString();
                phone = number.getText().toString();
                father = fathersname.getText().toString();
                add = address.getText().toString();
                emer1 = emergency1.getText().toString();
                emer2 = emergency2.getText().toString();

                ClassUserInfo upInfo = new ClassUserInfo(fullName, phone, father, emer1, emer2, add, userId);
                userRef.set(upInfo).addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if(task.isSuccessful()){
                            Toast.makeText(Information.this, "Profile Updated", Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(Information.this, HomeActivity.class);
                            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                            startActivity(intent);
                            finish();
                        }else{
                            Toast.makeText(Information.this, task.getException().toString(), Toast.LENGTH_SHORT).show();
                        }
                    }
                });

            }
        });


        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        if (user != null){
            Log.d(TAG,"onCreate:" + user.getDisplayName());
            if (user.getDisplayName() != null){
                name.setText(user.getDisplayName());
                name.setSelection(user.getDisplayName().length());
            }
        }
    }

    public void Initialize(){
        Toolbar toolbar = findViewById(R.id.toolbarid);
        setSupportActionBar(toolbar);
        database = FirebaseDatabase.getInstance();
        mAuth = FirebaseAuth.getInstance();
        firestore = FirebaseFirestore.getInstance();
        userId = mAuth.getUid();

        name = findViewById(R.id.profileName);
        number = findViewById(R.id.profileNumber);
        fathersname = findViewById(R.id.profileFatherName);
        emergency1 = findViewById(R.id.emergencyContact1);
        emergency2 = findViewById(R.id.emergencyContact2);
        address =  findViewById(R.id.profileAddress);
        updatebtn = findViewById(R.id.updateBtn);

        userRef = firestore.collection("Users").document(userId);
        userRef.get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
            @Override
            public void onSuccess(DocumentSnapshot documentSnapshot) {
                ClassUserInfo userInfo = documentSnapshot.toObject(ClassUserInfo.class);
                assert userInfo != null;
                name.setText(userInfo.getName());
                number.setText(userInfo.getPhone());
                fathersname.setText(userInfo.getFatherName());
                emergency1.setText(userInfo.getEmergency1());
                emergency2.setText(userInfo.getEmergency2());
                address.setText(userInfo.getAddress());
            }
        });
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