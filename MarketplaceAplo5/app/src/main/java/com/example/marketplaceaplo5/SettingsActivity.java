package com.example.marketplaceaplo5;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class SettingsActivity extends AppCompatActivity {

    private FirebaseAuth mAuth;
    private Button buttonPass;
    private Button buttonDelete;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
        mAuth = FirebaseAuth.getInstance();

        buttonPass = (Button) findViewById(R.id.button);
        buttonPass.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                openResetPasswordActivity();
            }
        });
        //buttonDelete = (Button) findViewById(R.id.button2);
        //buttonDelete.setOnClickListener(new View.OnClickListener(){
        //    @Override
        //    public void onClick(View v)
        //    openResetEmailActivity();
        //    }
        //});
    }

    public void openResetPasswordActivity() {
        Intent intent = new Intent(this, ResetPasswordActivity.class);
        startActivity(intent);
    }
    //public void openResetEmailActivity() {
    //    Intent intent = new Intent(this, DeleteAccountActivity.class);
    //    startActivity(intent);
    //}
    @Override
    public void onStart(){
        super.onStart();
        FirebaseUser currentUser = mAuth.getCurrentUser();
        if(currentUser == null) {
            startActivity(new Intent(SettingsActivity.this, LoginActivity.class));

        }
    }
}