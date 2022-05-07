package com.example.marketplaceaplo5.ViewHolderClasses;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.marketplaceaplo5.Interface.ItemClickListener;
import com.example.marketplaceaplo5.R;


public class OrderViewHolder extends RecyclerView.ViewHolder {

    public TextView out_orderID, out_firstname, out_lastname, out_phone, out_address, out_ShippingInfo, out_city, out_state, out_zip, out_productID, out_productName, out_price, out_sellerID, out_buyerID, out_listEpoch, out_sellEpoch, out_cardnumber, out_cvv, out_expiration;

    public OrderViewHolder(@NonNull View orderView) {
        super(orderView);
        out_orderID = orderView.findViewById(R.id.b_orderID);
        //out_productID = orderView.findViewById(R.id.b_productID);
        out_productName = orderView.findViewById(R.id.b_productName);
        out_price = orderView.findViewById(R.id.b_price);
        out_sellerID = orderView.findViewById(R.id.b_sellerID);
        out_buyerID = orderView.findViewById(R.id.b_buyerID);
        out_listEpoch = orderView.findViewById(R.id.b_listEpoch);
        out_sellEpoch = orderView.findViewById(R.id.b_sellEpoch);
        out_firstname = orderView.findViewById(R.id.b_firstname);
        out_lastname = orderView.findViewById(R.id.b_lastname);
        out_phone = orderView.findViewById(R.id.b_phone);
        out_address = orderView.findViewById(R.id.b_address);
        out_city = orderView.findViewById(R.id.b_city);
        out_state = orderView.findViewById(R.id.b_state);
        out_zip = orderView.findViewById(R.id.b_zip);
        out_cardnumber = orderView.findViewById(R.id.b_cardnumber);
        out_cvv = orderView.findViewById(R.id.b_cvv);
        out_expiration = orderView.findViewById(R.id.b_expiration);
    }
}
