package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

public class drivingSchoolActivity extends AppCompatActivity {

    RecyclerView recyclerViewDriving;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_driving_school);

        recyclerViewDriving = findViewById(R.id.recyclerViewDriving);
        recyclerViewDriving.setLayoutManager(new LinearLayoutManager(this));
    }
}