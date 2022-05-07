package com.example.marketplaceaplo5.ViewHolderClasses;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

//import com.example.ecommerce.R;

public class PurchaseProductViewHolder extends RecyclerView.ViewHolder {

    public TextView product_name, product_price, product_description;
    public ImageView product_image;


    public PurchaseProductViewHolder(@NonNull View itemView) {
        super(itemView);
/*
        product_name = itemView.findViewById(R.id.productName);
        product_price = itemView.findViewById(R.id.Price);
        product_description = itemView.findViewById(R.id.product_description);
        product_image = itemView.findViewById(R.id.product_image);

 */

    }

}
