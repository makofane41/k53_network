package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView drivingSchool;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView drivingSchool = findViewById(R.id.textViewDrivingSchool);

        drivingSchool.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent drivingSchoolIntent = new Intent(getBaseContext(),drivingSchoolActivity.class);
                startActivity(drivingSchoolIntent);
            }
        });
    }
}