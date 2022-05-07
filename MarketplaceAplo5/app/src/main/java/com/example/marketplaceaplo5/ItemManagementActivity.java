package com.example.marketplaceaplo5;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class ItemManagementActivity extends AppCompatActivity {

    private FirebaseAuth mAuth;
    private Button button_ima_uaia, button_ima_invoice, button_ima_order;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_managment);
        mAuth = FirebaseAuth.getInstance();

        button_ima_uaia = findViewById(R.id.btn_ima_uaia);
        button_ima_invoice = findViewById(R.id.btn_ima_invoice);
        button_ima_order = findViewById(R.id.btn_ima_order);




        button_ima_uaia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ItemManagementActivity.this, UAddItemActivity.class));
            }
        });

        button_ima_invoice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ItemManagementActivity.this, InvoiceActivity.class));
            }
        });

        button_ima_order.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ItemManagementActivity.this, OrderActivity.class));
            }
        });
    }
    @Override
    public void onStart(){
        super.onStart();
        FirebaseUser currentUser = mAuth.getCurrentUser();
        if(currentUser == null) {
            startActivity(new Intent(ItemManagementActivity.this, LoginActivity.class));
        }
    }
}