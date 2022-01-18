package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

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
        TextView textViewBookNow = (TextView)findViewById(R.id.textViewBookNow);
        TextView textViewBookRequirement = findViewById(R.id.textViewBookRequirement);
        TextView textViewForms=findViewById(R.id.textViewForms);


        textViewForms.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent textViewForms=new Intent(getBaseContext(),formsActivity.class);
                startActivity(textViewForms);
            }
        });


        textViewBookRequirement.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent textViewBookRequirement = new Intent(getBaseContext(),bookingRequirementActivity.class);
                startActivity(textViewBookRequirement);
            }
        });


        textViewBookNow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent textViewBookNow= new Intent(getBaseContext(),bookNowActivity.class);
                startActivity(textViewBookNow);
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