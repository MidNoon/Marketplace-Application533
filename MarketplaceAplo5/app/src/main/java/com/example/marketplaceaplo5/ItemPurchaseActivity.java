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

        ButtonBack = (Button) findViewById(R.id.btn_goback);
        ButtonConfirm = (Button) findViewById(R.id.btn_confirm);

        extras = getIntent();
        //intentProductID = extras.getStringExtra("pid");
        intentProductID = "Example";
        //Log.i("orderPrice:",orderPrice);
        //TextProductName.setText(intentProductID);

        productInfo();

        ButtonBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //GoBack();
            }
        });

        ButtonConfirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
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
            Order(firstname, lastname, phone, address, city, state, zip, cardnumber, cvv, expiration);
        }
    }


    private void Order(String firstname, String lastname, String phone, String address, String city, String state, String zip, String cardnumber, String cvv, String expiration){
        final DatabaseReference RootRef;
        RootRef = FirebaseDatabase.getInstance().getReference();

        //DatabaseReference newRootRef = RootRef.push();

        //String orderID = newRootRef.getKey();


        RootRef.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                    HashMap<String, Object> userdataMap = new HashMap<>();

                    userdataMap.put("firstname", firstname);
                    userdataMap.put("lastname", lastname);
                    userdataMap.put("phone", phone);
                    userdataMap.put("address", address);
                    userdataMap.put("city", city);
                    userdataMap.put("state", state);
                    userdataMap.put("zip", zip);
                    userdataMap.put("cardnumber", cardnumber);
                    userdataMap.put("cvv", cvv);
                    userdataMap.put("expiration", expiration);

                    final String pushId = FirebaseDatabase.getInstance().getReference().push().getKey(); //Create new random Id
                    FirebaseDatabase.getInstance().getReference().child("Orders").child(pushId).setValue(userdataMap).addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task) {
                            Toast.makeText(getApplicationContext(), "Order Placed", Toast.LENGTH_LONG).show();
                            finish();
                            startActivity(new Intent(ItemPurchaseActivity.this, ItemPurchaseActivity.class));
                        }
                    });
                    /*
                    RootRef.child("Orders").child(orderID).updateChildren(userdataMap)
                            .addOnCompleteListener(new OnCompleteListener<Void>() {
                                @Override
                                public void onComplete(@NonNull Task<Void> task) {
                                    if (task.isSuccessful()){
                                        Toast.makeText(ItemPurchaseActivity.this, "Congratulations, your new account has been created", Toast.LENGTH_SHORT).show();
                                        Intent intent = new Intent (ItemPurchaseActivity.this, LoginActivity.class);
                                        startActivity(intent);
                                    }
                                    else {
                                        Toast.makeText(ItemPurchaseActivity.this, "There was an error: try again or contact support", Toast.LENGTH_SHORT).show();
                                    }
                                }
                            });

 */


            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

    }
}