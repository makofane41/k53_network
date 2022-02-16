package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.ktx.Firebase;

public class addDriving extends AppCompatActivity {

    EditText drivingName,location,contact;
    Button add;

    private FirebaseDatabase db = FirebaseDatabase.getInstance();
    private DatabaseReference root = db.getReference().child("DrivingSchool");
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_driving);

        drivingName = findViewById(R.id.inputDrivingName);
        location = findViewById(R.id.inputLocation);
        contact = findViewById(R.id.inputContact);
        add = findViewById(R.id.btnAdd);

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = drivingName.getText().toString();
                root.setValue(drivingName);

            }
        });

    }
}