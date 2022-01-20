package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class LoggedHome extends AppCompatActivity {

    BottomNavigationView bottomNavigationView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_logged_home);

        bottomNavigationView= findViewById(R.id.Private_bottom_navigation);
        bottomNavigationView.setSelectedItemId(R.id.home_m);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch (item.getItemId()){



                    case R.id.account_m:
                        startActivity(new Intent(getApplicationContext(),accountDetails.class));
                        overridePendingTransition(0,0);
                        return true;

                    case R.id.home_m:
                        return true;

                    case R.id.support_m:
                        startActivity(new Intent(getApplicationContext(),supportActivity.class));
                        overridePendingTransition(0,0);
                        return true;
                }

                return false;
            }
        });
    }
}