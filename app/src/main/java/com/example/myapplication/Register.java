package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.ktx.Firebase;

public class Register extends AppCompatActivity {

    TextView noAccount;
    TextView inputEmail, inputPassword,inputConfirmPassword;
    Button btnRegister;
    String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";
    ProgressDialog progressDialog;

    //firebase variable
    FirebaseAuth mAuth;
    FirebaseUser mUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        noAccount = findViewById(R.id.noAccount);
        noAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent noAccountIntent = new Intent(getBaseContext(),Home.class);
                startActivity(noAccountIntent);
            }
        });


        //Initialize input field
        inputEmail = findViewById(R.id.inputEmail);
        //inputName = findViewById(R.id.inputName);
        inputPassword = findViewById(R.id.inputPassword);
        inputConfirmPassword = findViewById(R.id.inputConfirmPassword);
        btnRegister = findViewById(R.id.btnRegister);
        progressDialog = new ProgressDialog(this);
        
        //initialize firebase
        mAuth = FirebaseAuth.getInstance();
        mUser = mAuth.getCurrentUser();


        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                perfomAuth();
            }
        });


    }

    private void perfomAuth() {
        String email = inputEmail.getText().toString();
        //String name = inputName.getText().toString();
        String password = inputPassword.getText().toString();
        String confirmPassword = inputConfirmPassword.getText().toString();

        if(!email.matches(emailPattern)){
            inputEmail.setError("incorrect email!");
        }
        else if(password.isEmpty() ){
            inputPassword.setError("enter password");
        }
        else if(password.length()<6){
            inputPassword.setError("minimum length is 6");
        }
        else if(!password.equals(confirmPassword)){
            inputConfirmPassword.setError("Password not matched");
        }else{
            progressDialog.setMessage("Wait, Your registration is in Progress!");
            progressDialog.setTitle("Registration");
            progressDialog.setCanceledOnTouchOutside(false);
            progressDialog.show();
            
            mAuth.createUserWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if(task.isSuccessful()){
                        progressDialog.dismiss();
                        sendUserToNextActivity();
                        Toast.makeText(Register.this, "Registration Successful", Toast.LENGTH_SHORT).show();
                    }else{
                        progressDialog.dismiss();
                        Toast.makeText(Register.this, ""+task.getException(), Toast.LENGTH_SHORT).show();
                    }
                }
            });

        }


    }

    private void sendUserToNextActivity() {
        Intent intent = new Intent(Register.this,Home.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK|Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
    }
}