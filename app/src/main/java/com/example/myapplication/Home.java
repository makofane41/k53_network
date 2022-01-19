package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Home extends AppCompatActivity {

    TextView drivingSchool;
    TextView textViewNatisOnline;
    TextView textViewTestingCentre;
    TextView textViewBookNow;
    TextView textViewBookRequirement;
    TextView textViewForms;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView drivingSchool = findViewById(R.id.textViewDrivingSchool);
        TextView textViewNatisOnline = findViewById(R.id.textViewNatisOnline);
        TextView textViewTestingCentre = (TextView)findViewById(R.id.textViewTestingCentre);
        TextView textViewDriversLicense = (TextView)findViewById(R.id.textViewDriversLicense);
        TextView textViewForms=findViewById(R.id.textViewForms);
        TextView textViewLeanersLicense= findViewById(R.id.textViewLeanersLicense);


        textViewLeanersLicense.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent textViewLeanersLicense= new Intent(getBaseContext(),LearnersActivity.class);
                startActivity(textViewLeanersLicense);
            }
        });

        textViewDriversLicense.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent textViewDriversLicense= new Intent(getBaseContext(),driversActivity.class);
                startActivity(textViewDriversLicense);
            }
        });
        textViewForms.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent textViewForms=new Intent(getBaseContext(),formsActivity.class);
                startActivity(textViewForms);
            }
        });







        textViewTestingCentre.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent textViewTestingCentre= new Intent(getBaseContext(),testingCentreActivity.class);
                startActivity(textViewTestingCentre);
            }
        });

        textViewNatisOnline.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent textViewNatisOnlineIntent= new Intent(getBaseContext(),NatisImplicIntentActivity.class);
                startActivity(textViewNatisOnlineIntent);
            }
        });

        drivingSchool.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent drivingSchoolIntent = new Intent(getBaseContext(),drivingSchoolActivity.class);
                startActivity(drivingSchoolIntent);
            }
        });
    }
}