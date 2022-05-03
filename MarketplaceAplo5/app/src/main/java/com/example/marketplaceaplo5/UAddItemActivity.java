package com.example.marketplaceaplo5;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;

public class UAddItemActivity extends AppCompatActivity {
    private String ProductName, ProductDescription, Price;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_u_add_item);

        ProductName = FirebaseDatabase.getInstance().getReference().child("Product Name");
        ProductDescription  = FirebaseDatabase.getInstance().getReference().child("Product Description");
        Price = FirebaseDatabase.getInstance().getReference().child("Price");


    }
    private void SaveProductInfoToDatabase()
    {
        HashMap<String, Object> productMap = new HashMap<>();
        productMap.put("product", ProductName);
        productMap.put("description", ProductDescription);
        productMap.put("price", Price);

    }
}
