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


import com.example.marketplaceaplo5.Classes.Orders;
import com.example.marketplaceaplo5.ViewHolderClasses.OrderViewHolder;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.squareup.picasso.Picasso;

public class OrderActivity extends AppCompatActivity {

    private FirebaseAuth mAuth;
    private DatabaseReference OrdersRef;
    private RecyclerView recyclerView;
    RecyclerView.LayoutManager layoutManager;
    private String currentFirebaseUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);
        mAuth = FirebaseAuth.getInstance();
        mAuth = FirebaseAuth.getInstance();


        recyclerView = findViewById(R.id.recycler_menu);
        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        currentFirebaseUser = FirebaseAuth.getInstance().getCurrentUser().getUid();
        OrdersRef = FirebaseDatabase.getInstance().getReference().child("Orders").child(currentFirebaseUser);
    }
    @Override
    public void onStart(){
        super.onStart();
        FirebaseUser currentUser = mAuth.getCurrentUser();
        if(currentUser == null) {
            startActivity(new Intent(OrderActivity.this, LoginActivity.class));
        }

        FirebaseRecyclerOptions<Orders> query =
                new FirebaseRecyclerOptions.Builder<Orders>().setQuery(OrdersRef, Orders.class).build();


        FirebaseRecyclerAdapter<Orders, OrderViewHolder> adapter = new FirebaseRecyclerAdapter<Orders, OrderViewHolder>(query) {
            @Override
            protected void onBindViewHolder(@NonNull OrderViewHolder holder, int position, @NonNull final Orders model) {
                holder.out_orderID.setText(model.getOrderID());
                holder.out_firstname.setText(model.getFirstname());
                holder.out_lastname.setText(model.getLastname());
                holder.out_phone.setText(model.getPhone());
                holder.out_address.setText(model.getAddress());
                holder.out_city.setText(model.getCity());
                holder.out_state.setText(model.getState());
                holder.out_zip.setText(model.getZip());
                //holder.out_productID.setText(model.getProductID());
                holder.out_productName.setText(model.getProductName());
                holder.out_price.setText(model.getPrice());
                holder.out_sellerID.setText(model.getSellerID());
                holder.out_buyerID.setText(model.getBuyerID());
                holder.out_listEpoch.setText(model.getListEpoch());
                holder.out_sellEpoch.setText(model.getSellEpoch());
                holder.out_cardnumber.setText(model.getCardnumber());
                holder.out_cvv.setText(model.getCvv());
                holder.out_expiration.setText(model.getExpiration());
            }

            @NonNull
            @Override
            public OrderViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
                View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.order_layout,viewGroup,false);
                OrderViewHolder holder = new OrderViewHolder(view);
                return holder;
            }
        };

        recyclerView.setAdapter(adapter);
        adapter.startListening();
    }
}