package com.example.marketplaceaplo5;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.marketplaceaplo5.Classes.Invoice;
import com.example.marketplaceaplo5.ViewHolderClasses.InvoiceViewHolder;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.squareup.picasso.Picasso;

public class InvoiceActivity extends AppCompatActivity {

    private FirebaseAuth mAuth;
    private DatabaseReference InvoicesRef;
    private RecyclerView recyclerView;
    RecyclerView.LayoutManager layoutManager;
    private String currentFirebaseUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_invoice);
        mAuth = FirebaseAuth.getInstance();
        mAuth = FirebaseAuth.getInstance();


        recyclerView = findViewById(R.id.recycler_menu);
        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        currentFirebaseUser = FirebaseAuth.getInstance().getCurrentUser().getUid();
        InvoicesRef = FirebaseDatabase.getInstance().getReference().child("Invoice").child(currentFirebaseUser);
    }
    @Override
    public void onStart(){
        super.onStart();
        FirebaseUser currentUser = mAuth.getCurrentUser();
        if(currentUser == null) {
            startActivity(new Intent(InvoiceActivity.this, LoginActivity.class));
        }

        FirebaseRecyclerOptions<Invoice> query =
                new FirebaseRecyclerOptions.Builder<Invoice>().setQuery(InvoicesRef, Invoice.class).build();

        FirebaseRecyclerAdapter<Invoice, InvoiceViewHolder> adapter = new FirebaseRecyclerAdapter<Invoice, InvoiceViewHolder>(query) {
            @Override
            protected void onBindViewHolder(@NonNull InvoiceViewHolder holder, int position, @NonNull final Invoice model) {
                holder.txt_invoiceID.setText(model.getInvoiceID());
                holder.txt_firstname.setText(model.getFirstname());
                holder.txt_lastname.setText(model.getLastname());
                holder.txt_phone.setText(model.getPhone());
                holder.txt_address.setText(model.getAddress());
                holder.txt_city.setText(model.getCity());
                holder.txt_state.setText(model.getState());
                holder.txt_zip.setText(model.getZip());
                //holder.txt_productID.setText(model.getProductID());
                holder.txt_productName.setText(model.getProductName());
                holder.txt_price.setText(model.getPrice());
                holder.txt_sellerID.setText(model.getSellerID());
                holder.txt_buyerID.setText(model.getBuyerID());
                holder.txt_listEpoch.setText(model.getListEpoch());
                holder.txt_sellEpoch.setText(model.getSellEpoch());
            }

            @NonNull
            @Override
            public InvoiceViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
                View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.invoice_layout,viewGroup,false);
                InvoiceViewHolder holder = new InvoiceViewHolder(view);
                return holder;
            }
        };

        recyclerView.setAdapter(adapter);
        adapter.startListening();
    }
}