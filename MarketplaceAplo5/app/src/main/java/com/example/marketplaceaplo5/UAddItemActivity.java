package com.example.marketplaceaplo5;

import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

import java.util.HashMap;

public class UAddItemActivity extends AppCompatActivity {

    private Button ProductAddButton;
    private ImageView ProductImageView;
    private EditText TextProductName, TextProductDescription, TextProductPrice;
    ActivityResultLauncher<String> mGetContent;
    private FirebaseAuth mAuth;
    private StorageReference productImageRef;
    private Uri imageUri;
    private String downloadProductURL;
    private DatabaseReference databaseReference;
    private String currentFirebaseUser;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_u_add_item);
        mAuth = FirebaseAuth.getInstance();

        ProductAddButton = (Button) findViewById(R.id.btn_ima_uaia);
        ProductImageView = (ImageView) (ImageView) findViewById(R.id.select_product_image);

        TextProductName = (EditText) findViewById(R.id.product_name);
        TextProductDescription = (EditText) findViewById(R.id.product_description);
        TextProductPrice = (EditText) findViewById(R.id.product_price);

        productImageRef = FirebaseStorage.getInstance().getReference().child("Product Images");

        currentFirebaseUser = FirebaseAuth.getInstance().getCurrentUser().getUid();



        mGetContent = registerForActivityResult(new ActivityResultContracts.GetContent(), new ActivityResultCallback<Uri>() {
            @Override
            public void onActivityResult(Uri imageData) {
                ProductImageView.setImageURI(imageData);
                imageUri = imageData;
            }
        });

        ProductImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mGetContent.launch("image/*");
            }
        });

        ProductAddButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ProductAddButton.setClickable(false);
                InfoStorage();
            }
        });
    }

    @Override
    public void onStart(){
        super.onStart();
        FirebaseUser currentUser = mAuth.getCurrentUser();
        if(currentUser == null) {
            startActivity(new Intent(UAddItemActivity.this, LoginActivity.class));
        }
    }

    private void InfoStorage() {

        String productname = TextProductName.getText().toString();
        String productdescription = TextProductDescription.getText().toString();
        String productprice = TextProductPrice.getText().toString();
        if (TextUtils.isEmpty(productname)) {
            Toast.makeText(this, "No Product Name", Toast.LENGTH_SHORT).show();
        } else if (TextUtils.isEmpty(productdescription)) {
            Toast.makeText(this, "No Product Description", Toast.LENGTH_SHORT).show();
        } else if (TextUtils.isEmpty(productprice)) {
            Toast.makeText(this, "No Product Price", Toast.LENGTH_SHORT).show();
        } else if (imageUri == null) {
            Toast.makeText(this, "No Product Image", Toast.LENGTH_SHORT).show();
        } else {

            Long tsLong = System.currentTimeMillis();
            String ts = tsLong.toString();

            StorageReference filePath = productImageRef.child(imageUri.getLastPathSegment() + ts + ".jpg");

            final UploadTask uploadTask = filePath.putFile(imageUri);


            uploadTask.addOnFailureListener(new OnFailureListener() {
                @Override
                public void onFailure(@NonNull Exception e) {

                    String message = e.toString();
                    Toast.makeText(UAddItemActivity.this, "Error: " + message, Toast.LENGTH_SHORT).show();
                }
            }).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                @Override
                public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {

                    Toast.makeText(UAddItemActivity.this, "Image is Uploaded successfully", Toast.LENGTH_SHORT).show();

                    //getting image url
                    Task<Uri> taskURL = uploadTask.continueWithTask(new Continuation<UploadTask.TaskSnapshot, Task<Uri>>() {
                        @Override
                        public Task<Uri> then(@NonNull Task<UploadTask.TaskSnapshot> task) throws Exception {
                            if (!task.isSuccessful()) {

                                throw task.getException();

                            }

                                /*//filpath uri
                                downloadProductURL = filePath.getDownloadUrl().toString();*/

                            return filePath.getDownloadUrl();
                        }
                    }).addOnCompleteListener(new OnCompleteListener<Uri>() {
                        @Override
                        public void onComplete(@NonNull Task<Uri> task) {

                            if (task.isSuccessful()) {

                                //To get URL of image
                                downloadProductURL = task.getResult().toString();

                                saveProductInfoInDatabase(productname, productdescription, productprice, downloadProductURL, currentFirebaseUser, ts);
                            }
                        }
                    });
                }
            });
        }
    }

    private void saveProductInfoInDatabase(String productName, String productDescription, String productPrice, String downloadProductURL, String sellerID, String listEpoch) {

        String buyerID = null;
        String sellEpoch = "0";
        Boolean isSold = false;
        Boolean isRemoved = false;

        final String pushId = FirebaseDatabase.getInstance().getReference().push().getKey(); //Create new random Id

        HashMap<String, Object> productMap = new HashMap<>();
            productMap.put("pid", pushId);
            productMap.put("productName", productName);
            productMap.put("description", productDescription);
            productMap.put("price", productPrice);
            productMap.put("image", downloadProductURL);
            productMap.put("sellerID", sellerID);
            productMap.put("buyerID", buyerID);
            productMap.put("listEpoch", listEpoch);
            productMap.put("sellEpoch", sellEpoch);
            productMap.put("isSold", isSold);
            productMap.put("isRemoved", isRemoved);

        FirebaseDatabase.getInstance().getReference().child("Products").child(pushId).setValue(productMap).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                Toast.makeText(getApplicationContext(), "Product Added", Toast.LENGTH_LONG).show();
                finish();
                startActivity(new Intent(UAddItemActivity.this, ItemManagementActivity.class));
            }
        });
    }
}