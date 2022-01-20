package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class accountDetails extends AppCompatActivity {

    BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account_details);
        bottomNavigationView= findViewById(R.id.Private_bottom_navigation);
        bottomNavigationView.setSelectedItemId(R.id.account_m);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch (item.getItemId()){



                    case R.id.account_m:

                        return true;

                    case R.id.home_m:
                        startActivity(new Intent(getApplicationContext(),LoggedHome.class));
                        overridePendingTransition(0,0);
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