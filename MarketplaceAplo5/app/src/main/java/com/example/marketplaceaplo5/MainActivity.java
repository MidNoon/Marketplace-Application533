package com.example.marketplaceaplo5;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity extends AppCompatActivity {


    private FirebaseAuth mAuth;
    private Button button_logout;
    private Button button_main_browse;
<<<<<<< Updated upstream
    private Button rdCode;

=======
    private Button button_main_item;
    private Button button_main_invoices;
    private Button button_main_settings;
>>>>>>> Stashed changes


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mAuth = FirebaseAuth.getInstance();
        button_logout = findViewById(R.id.button_logout);
        button_main_browse = findViewById(R.id.button_main_browse);
<<<<<<< Updated upstream
        rdCode = (Button) findViewById(R.id.resendCode);



        FirebaseUser user = mAuth.getCurrentUser();






            rdCode.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    FirebaseUser user1 = mAuth.getCurrentUser();

                    user1.sendEmailVerification().addOnCompleteListener(new OnCompleteListener<Void>() {


                        @Override

                        public void onComplete(@NonNull Task<Void> task) {

                            if (task.isSuccessful()) {

                                Toast.makeText(MainActivity.this ,"success",Toast.LENGTH_SHORT).show();

                            }

                            else {        Toast.makeText(MainActivity.this ,"Fail",Toast.LENGTH_SHORT).show();

                            }

                        }



                    });


                }

            });



=======
        button_main_item = findViewById(R.id.button_main_item);
        button_main_invoices = findViewById(R.id.button_main_invoices);
        button_main_settings = findViewById(R.id.button_main_settings);
>>>>>>> Stashed changes

        button_logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                logout();
            }
        });

        button_main_browse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, BrowseActivity.class));
            }
        });
        button_main_item.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, ItemManagementActivity.class));
            }
        });
        button_main_invoices.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, InvoiceActivity.class));
            }
        });
        button_main_settings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, SettingsActivity.class));
            }
        });
    }

    @Override
    public void onStart(){
        super.onStart();
        FirebaseUser currentUser = mAuth.getCurrentUser();
        if(currentUser == null) {
            startActivity(new Intent(MainActivity.this, LoginActivity.class));
        }
    }

    public void logout() {
        FirebaseAuth.getInstance().signOut();
        startActivity(new Intent(MainActivity.this, LoginActivity.class));
    }
}