package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class drivingSchoolActivity extends AppCompatActivity {

    RecyclerView recyclerViewDriving;
    List<DrivingSchool> list = new ArrayList<>();
    RecyclerViewAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_driving_school);

        recyclerViewDriving = findViewById(R.id.recyclerViewDriving);
        recyclerViewDriving.setLayoutManager(new LinearLayoutManager(this));

        //array
        String drivingName [] = getResources().getStringArray(R.array.drivingName);
        String drivingLocation [] = getResources().getStringArray(R.array.drivingLocation);
        int drivingProfile []= {R.drawable.driving1,R.drawable.driving2,R.drawable.driving3};

        for (int i=0;i<drivingName.length;i++){
            DrivingSchool drivingSchool= new DrivingSchool(drivingProfile[i],drivingName[i],drivingLocation[i]);
            list.add(drivingSchool);
        }
        adapter = new RecyclerViewAdapter(this,list);
        recyclerViewDriving.setAdapter(adapter);

    }
}