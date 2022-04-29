package com.example.marketplaceaplo5;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;


public class RegistrationActivity extends AppCompatActivity {
    private FirebaseAuth mAuth;
    private EditText email, password;
    private Button btnRegister;
    private TextView textLogin;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
        mAuth = FirebaseAuth.getInstance();
        email = findViewById(R.id.register_email_input);
        password = findViewById(R.id.register_password_input);
        btnRegister = findViewById(R.id.register_button);
        textLogin = findViewById(R.id.text_login);

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Register();
            }
        });

        textLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(RegistrationActivity.this, LoginActivity.class));
            }
        });

    }

    private void Register() {
        String user = email.getText().toString().trim();
        String pass = password.getText().toString().trim();
        if (user.isEmpty()) {
            email.setError("Email can not be empty");
            return;
        }
        if (pass.isEmpty()) {
            password.setError("Password can not be empty");
            return;
        }
            mAuth.createUserWithEmailAndPassword(user, pass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if (task.isSuccessful()) {
                        //send verification link
                        FirebaseUser user1 = mAuth.getCurrentUser();


                            user1.sendEmailVerification().addOnSuccessListener(new OnSuccessListener<Void>() {
                                @Override
                                public void onSuccess(Void unused) {

                                }
                            }).addOnCompleteListener(new OnCompleteListener<Void>() {

                                        @Override

                                        public void onComplete(@NonNull Task<Void> task) {

                            if (task.isSuccessful()) {

                                                Toast.makeText(RegistrationActivity.this ,"Success, Email Verification Sent to Email",Toast.LENGTH_SHORT).show();

                                            }

                                            else {        Toast.makeText(RegistrationActivity.this ,"Fail Email Verification Not sent, Click Verify to send another Email",Toast.LENGTH_SHORT).show();

                            }

                        }



                    });


                        Toast.makeText(RegistrationActivity.this, "User registered successfully", Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(RegistrationActivity.this, MainActivity.class));


                    } else{
                        Toast.makeText(RegistrationActivity.this, "Registration Failed Error: " + task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                    }


            }

        });



    }
}
