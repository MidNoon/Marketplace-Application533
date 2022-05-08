package com.example.marketplaceaplo5;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.marketplaceaplo5.Classes.Products;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.squareup.picasso.Picasso;

import java.util.HashMap;

public class ItemPurchaseActivity extends AppCompatActivity {
/*  ItemPurchaseActivity Guide
*       Get Intent: ID of Product
*       Get User(Auth): uid, email
*       Get User: First Name, Last Name, Phone Number, Address, City, State, Zip Code, Card Number, CVV, Expiration
*       Get Item: Product Name, Product Price, Product Seller, Product List Date, Product List Time
*       Update Item: Buyer, Sold Date, Sold Time, isSold
*       Create Order(What Seller can see in Order): #UniqueOrderID, Product ID, Product Name, Product Price, Seller, List Date, List Time, Buyer, Sold Date, Sold Time, Buyer First Name, Buyer Last Name, Buyer Email, Buyer Phone, Buyer Address, Buyer Card Number, Buyer CVV, Buyer Expiration
*       Create Invoice(What Buyer can see in Invoice): #UniqueInvoiceID, Product ID, Product Name, Product Price, Seller, List Date, List Time, Buyer, Sold Date, Sold Time, Buyer First Name, Buyer Last Name, Buyer Email, Buyer Phone, Buyer Address
* */
    private FirebaseAuth mAuth;

    private  Products productInfoRef;
    private DatabaseReference databaseReference;
    private TextView TextProductName, TextProductPrice;
    private EditText InputFirstName, InputLastName, InputPhone, InputAddress, InputCity, InputState, InputZip, InputCardNumber, InputCVV, InputExpiration;
    private Button ButtonBack, ButtonConfirm;
    private String intentProductID, orderPrice;
    Intent extras;
    private String currentFirebaseUser, pid, productName, productPrice, sellerID, listEpoch;
    private Products productDetail;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_purchase);
        mAuth = FirebaseAuth.getInstance();

        TextProductName = (TextView) findViewById(R.id.textProductName);
        TextProductPrice = (TextView) findViewById(R.id.textProductPrice);

        InputFirstName = (EditText) findViewById(R.id.editTextFirstName);
        InputLastName = (EditText) findViewById(R.id.editTextLastName);
        InputPhone = (EditText) findViewById(R.id.editTextPhone);
        InputAddress = (EditText) findViewById(R.id.editTextPostalAddress);
        InputCity = (EditText) findViewById(R.id.editTextCity);
        InputState = (EditText) findViewById(R.id.editTextState);
        InputZip = (EditText) findViewById(R.id.editTextZip);
        InputCardNumber = (EditText) findViewById(R.id.editTextCardNumber);
        InputCVV = (EditText) findViewById(R.id.editTextCVV);
        InputExpiration = (EditText) findViewById(R.id.editTextExpiration);
        currentFirebaseUser = FirebaseAuth.getInstance().getCurrentUser().getUid();

        ButtonBack = (Button) findViewById(R.id.btn_goback);
        ButtonConfirm = (Button) findViewById(R.id.btn_confirm);

        extras = getIntent();
        intentProductID = extras.getStringExtra("pid");
        //intentProductID = "Example";
        //Log.i("orderPrice:",orderPrice);
        //TextProductName.setText(intentProductID);

        loadClickProductInfo();

        productInfo();

        ButtonBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //GoBack();
                startActivity(new Intent(ItemPurchaseActivity.this, BrowseActivity.class));
            }
        });

        ButtonConfirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ButtonConfirm.setClickable(false);
                Confirmation();
            }
        });
    }
    @Override
    public void onStart(){
        super.onStart();
        FirebaseUser currentUser = mAuth.getCurrentUser();
        if(currentUser == null) {
            startActivity(new Intent(ItemPurchaseActivity.this, LoginActivity.class));
        }
    }

    private void productInfo() {

        databaseReference = FirebaseDatabase.getInstance().getReference().child("Products");

        databaseReference.child(intentProductID).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                productInfoRef = dataSnapshot.getValue(Products.class);

                TextProductName.setText(productInfoRef.getProductName());

                TextProductPrice.setText("Price: " + productInfoRef.getPrice());
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(getApplicationContext(), "Error", Toast.LENGTH_LONG).show();
            }
        });
    }

    private void loadClickProductInfo() {

        databaseReference = FirebaseDatabase.getInstance().getReference().child("Products");

        databaseReference.child(intentProductID).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                productDetail = dataSnapshot.getValue(Products.class);

                pid = productDetail.getPID();
                productName = productDetail.getProductName();
                productPrice = productDetail.getPrice();
                sellerID = productDetail.getSellerID();
                listEpoch = productDetail.getListEpoch();

            }
            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
            }
        });
    }

    private void Confirmation() {
        String firstname = InputFirstName.getText().toString();
        String lastname = InputLastName.getText().toString();
        String phone = InputPhone.getText().toString();
        String address = InputAddress.getText().toString();
        String city = InputCity.getText().toString();
        String state = InputState.getText().toString();
        String zip = InputZip.getText().toString();
        String cardnumber = InputCardNumber.getText().toString();
        String cvv = InputCVV.getText().toString();
        String expiration = InputExpiration.getText().toString();


        Long tsLong = System.currentTimeMillis();
        String ts = tsLong.toString();

        // UserID
        // UserEmail

        // Product Name
        // Product Price
        // Product Seller
        // Product List Date
        // Product List Time

        // IsSold (Update Product in database)


        if (TextUtils.isEmpty(firstname)) {
            Toast.makeText(this, "No First Name", Toast.LENGTH_SHORT).show();
        }
        else if (TextUtils.isEmpty(lastname)) {
            Toast.makeText(this, "No Last Name", Toast.LENGTH_SHORT).show();
        }
        else if (TextUtils.isEmpty(phone)) {
            Toast.makeText(this, "No Phone", Toast.LENGTH_SHORT).show();
        }
        else if (TextUtils.isEmpty(address)) {
            Toast.makeText(this, "No Address", Toast.LENGTH_SHORT).show();
        }
        else if (TextUtils.isEmpty(city)) {
            Toast.makeText(this, "No City", Toast.LENGTH_SHORT).show();
        }
        else if (TextUtils.isEmpty(state)) {
            Toast.makeText(this, "No State", Toast.LENGTH_SHORT).show();
        }
        else if (TextUtils.isEmpty(zip)) {
            Toast.makeText(this, "No Zip Code", Toast.LENGTH_SHORT).show();
        }
        else if (TextUtils.isEmpty(cardnumber)) {
            Toast.makeText(this, "No Card Number", Toast.LENGTH_SHORT).show();
        }
        else if (TextUtils.isEmpty(cvv)) {
            Toast.makeText(this, "No CVV", Toast.LENGTH_SHORT).show();
        }
        else if (TextUtils.isEmpty(expiration)) {
            Toast.makeText(this, "No Expiration", Toast.LENGTH_SHORT).show();
        }
        else {
            Order(currentFirebaseUser, firstname, lastname, phone, address, city, state, zip, cardnumber, cvv, expiration, ts);
        }
    }


    private void Order(String buyerID, String firstname, String lastname, String phone, String address, String city, String state, String zip, String cardnumber, String cvv, String expiration, String sellEpoch){
        final DatabaseReference RootRef;
        RootRef = FirebaseDatabase.getInstance().getReference();

        //DatabaseReference newRootRef = RootRef.push();

        //String orderID = newRootRef.getKey();


        RootRef.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                final String pushId = FirebaseDatabase.getInstance().getReference().push().getKey(); //Create new random Id

                HashMap<String, Object> orderMap = new HashMap<>();
                    orderMap.put("orderID", pushId);
                    orderMap.put("firstname", firstname);
                    orderMap.put("lastname", lastname);
                    orderMap.put("phone", phone);
                    orderMap.put("address", address);
                    orderMap.put("city", city);
                    orderMap.put("state", state);
                    orderMap.put("zip", zip);
                    orderMap.put("cardnumber", cardnumber);
                    orderMap.put("cvv", cvv);
                    orderMap.put("expiration", expiration);
                    orderMap.put("pid", pid);
                    orderMap.put("productName", productName);
                    orderMap.put("price", productPrice);
                    orderMap.put("sellerID", sellerID);
                    orderMap.put("buyerID", buyerID);
                    orderMap.put("listEpoch", listEpoch);
                    orderMap.put("sellEpoch", sellEpoch);

                    FirebaseDatabase.getInstance().getReference().child("Orders").child(sellerID).child(pushId).setValue(orderMap).addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task) {
                            Invoice(buyerID, firstname, lastname, phone, address, city, state, zip, productName, productPrice, sellerID, listEpoch, sellEpoch);
                        }
                    });
            }
            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

    }
    private void Invoice(String buyerID, String firstname, String lastname, String phone, String address, String city, String state, String zip, String productName, String productPrice, String sellerID, String listEpoch, String sellEpoch){
        final DatabaseReference RootRef;
        RootRef = FirebaseDatabase.getInstance().getReference();

        //DatabaseReference newRootRef = RootRef.push();

        //String orderID = newRootRef.getKey();


        RootRef.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                final String rushId = FirebaseDatabase.getInstance().getReference().push().getKey(); //Create new random Id

                HashMap<String, Object> invoiceMap = new HashMap<>();
                invoiceMap.put("invoiceID", rushId);
                invoiceMap.put("firstname", firstname);
                invoiceMap.put("lastname", lastname);
                invoiceMap.put("phone", phone);
                invoiceMap.put("address", address);
                invoiceMap.put("city", city);
                invoiceMap.put("state", state);
                invoiceMap.put("zip", zip);
                invoiceMap.put("pid", pid);
                invoiceMap.put("productName", productName);
                invoiceMap.put("price", productPrice);
                invoiceMap.put("sellerID", sellerID);
                invoiceMap.put("buyerID", buyerID);
                invoiceMap.put("listEpoch", listEpoch);
                invoiceMap.put("sellEpoch", sellEpoch);

                FirebaseDatabase.getInstance().getReference().child("Invoice").child(buyerID).child(rushId).setValue(invoiceMap).addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        DeleteData();
                    }
                });
            }
            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
    private void DeleteData() {
        databaseReference = FirebaseDatabase.getInstance().getReference()
                .child("Products").child(pid);
        databaseReference.removeValue();
        Toast.makeText(getApplicationContext(), "Invoice Created", Toast.LENGTH_LONG).show();
        finish();
        startActivity(new Intent(ItemPurchaseActivity.this, InvoiceActivity.class));
    }
}