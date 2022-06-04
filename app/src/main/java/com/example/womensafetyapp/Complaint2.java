package com.example.womensafetyapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Complaint2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_complaint2);

        EditText inputText = findViewById(R.id.EditText);
        TextView outputText = findViewById(R.id.output);
        Button Add = findViewById(R.id.add);
        Button submit = findViewById(R.id.submit);

        Add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String Value = inputText.getText().toString();
                outputText.setText(Value);
            }
        });
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String Data = outputText.getText().toString();
                Intent intent = new Intent(com.example.womensafetyapp.Complaint2.this,ComplaintShow.class);
                intent.putExtra("ABC",Data);
                startActivity(intent);
                finish();
            }
        });
    }
}