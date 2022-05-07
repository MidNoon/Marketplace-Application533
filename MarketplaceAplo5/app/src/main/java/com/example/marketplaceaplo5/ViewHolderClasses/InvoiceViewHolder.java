package com.example.marketplaceaplo5.ViewHolderClasses;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.marketplaceaplo5.Interface.ItemClickListener;
import com.example.marketplaceaplo5.R;


public class InvoiceViewHolder extends RecyclerView.ViewHolder {

    public TextView txt_invoiceID, txt_firstname, txt_lastname, txt_phone, txt_address, txt_ShippingInfo, txt_city, txt_state, txt_zip, txt_productID, txt_productName, txt_price, txt_sellerID, txt_buyerID, txt_listEpoch, txt_sellEpoch,s_invoiceID, s_firstname, s_lastname, s_phone, s_address, s_ShippingInfo, s_city, s_state, s_zip, s_productID, s_productName, s_price, s_sellerID, s_buyerID, s_listEpoch, s_sellEpoch;


    public InvoiceViewHolder(@NonNull View invoiceView) {
        super(invoiceView);
        txt_invoiceID = invoiceView.findViewById(R.id.f_invoiceID);
        //txt_productID = invoiceView.findViewById(R.id.f_productID);
        txt_productName = invoiceView.findViewById(R.id.f_productName);
        txt_price = invoiceView.findViewById(R.id.f_price);
        txt_sellerID = invoiceView.findViewById(R.id.f_sellerID);
        txt_buyerID = invoiceView.findViewById(R.id.f_buyerID);
        txt_listEpoch = invoiceView.findViewById(R.id.f_listEpoch);
        txt_sellEpoch = invoiceView.findViewById(R.id.f_sellEpoch);
        txt_ShippingInfo = invoiceView.findViewById(R.id.f_ShippingInfo);
        txt_firstname = invoiceView.findViewById(R.id.f_firstname);
        txt_lastname = invoiceView.findViewById(R.id.f_lastname);
        txt_phone = invoiceView.findViewById(R.id.f_phone);
        txt_address = invoiceView.findViewById(R.id.f_address);
        txt_city = invoiceView.findViewById(R.id.f_city);
        txt_state = invoiceView.findViewById(R.id.f_state);
        txt_zip = invoiceView.findViewById(R.id.f_zip);



        s_invoiceID = invoiceView.findViewById(R.id.x_invoiceID);
        //s_productID = invoiceView.findViewById(R.id.x_productID);
        s_productName = invoiceView.findViewById(R.id.x_productName);
        s_price = invoiceView.findViewById(R.id.x_price);
        s_sellerID = invoiceView.findViewById(R.id.x_sellerID);
        s_buyerID = invoiceView.findViewById(R.id.x_buyerID);
        s_listEpoch = invoiceView.findViewById(R.id.x_listEpoch);
        s_sellEpoch = invoiceView.findViewById(R.id.x_sellEpoch);

        s_firstname = invoiceView.findViewById(R.id.x_firstname);
        s_lastname = invoiceView.findViewById(R.id.x_lastname);
        s_phone = invoiceView.findViewById(R.id.x_phone);
        s_address = invoiceView.findViewById(R.id.x_address);
        s_city = invoiceView.findViewById(R.id.x_city);
        s_state = invoiceView.findViewById(R.id.x_state);
        s_zip = invoiceView.findViewById(R.id.x_zip);
    }
}
