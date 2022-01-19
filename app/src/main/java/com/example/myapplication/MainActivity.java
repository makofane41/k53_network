package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Button btnNoAccount;
    TextView gotoRegister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnNoAccount = findViewById(R.id.btnNoAccount);
        gotoRegister = findViewById(R.id.gotoRegister);

        gotoRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent gotoRegisterIntent = new Intent(getBaseContext(),Register.class);
                startActivity(gotoRegisterIntent);
            }
        });

        btnNoAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent btnNoAccountIntent = new Intent(getApplicationContext(),Home.class);
                startActivity(btnNoAccountIntent);
            }
        });






    }
}