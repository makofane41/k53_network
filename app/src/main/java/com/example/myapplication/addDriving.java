package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class addDriving extends AppCompatActivity {

    // creating variables for our button, edit text,
    // firebase database, database reference, progress bar.
    private Button btnAdd;
    private EditText drivingName, location, contacts, alternativeContact, description;
    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;
    private String drivingID;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_driving);
        // initializing all our variables.
        btnAdd = findViewById(R.id.btnAdd);
       drivingName  = findViewById(R.id.inputDrivingName);
        location = findViewById(R.id.inputLocation);
        contacts = findViewById(R.id.inputContact);
        alternativeContact = findViewById(R.id.inputAlternativeContact);
        description = findViewById(R.id.inputDescription);

        firebaseDatabase = FirebaseDatabase.getInstance();
        // on below line creating our database reference.
        databaseReference = firebaseDatabase.getReference("Courses");
        // adding click listener for our add course button.
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String drivingName1 = drivingName.getText().toString();
                String location1 = location.getText().toString();
                String contacts1 = contacts.getText().toString();
                String alternativeContact1 = alternativeContact.getText().toString();
                String description1 = description.getText().toString();

                drivingID = drivingName1;
                // on below line we are passing all data to our modal class.
                DrivingRVModal drivingRVModal = new DrivingRVModal(drivingID, drivingName1,description1,  contacts1, alternativeContact1, location1);
                // on below line we are calling a add value event
                // to pass data to firebase database.
                databaseReference.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        // on below line we are setting data in our firebase database.
                        databaseReference.child(drivingID).setValue(drivingRVModal);
                        // displaying a toast message.
                        Toast.makeText(addDriving.this, "Driving Added..", Toast.LENGTH_SHORT).show();
                        // starting a main activity.
                        startActivity(new Intent(addDriving.this, MainActivity.class));
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {
                        // displaying a failure message on below line.
                        Toast.makeText(addDriving.this, "Fail to add Course..", Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });
    }
}
