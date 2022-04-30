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
    private Button button_add_new_product;
    private Button button_view_sold_items;
    private Button button_view_active_items;
    private Button button_view_bought_items;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_managment);
        mAuth = FirebaseAuth.getInstance();
        button_add_new_product = findViewById(R.id.add_new_product);
        button_view_sold_items = findViewById(R.id.view_sold_product);
        button_view_active_items = findViewById(R.id.view_active_product);
        button_view_bought_items = findViewById(R.id.view_bought_products);

        button_add_new_product.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ItemManagementActivity.this, UAddItemActivity.class));
            }
        });
        button_view_sold_items.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ItemManagementActivity.this, USoldItemsActivity.class));
            }
        });
        button_view_active_items.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ItemManagementActivity.this, UViewItemsActivity.class));
            }
        });
        button_view_bought_items.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ItemManagementActivity.this, UBoughtItemsActivity.class));
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