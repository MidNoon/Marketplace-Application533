package com.example.marketplaceaplo5.ViewHolderClasses;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.marketplaceaplo5.Interface.ItemClickListener;
import com.example.marketplaceaplo5.R;


public class ProductViewHolder extends RecyclerView.ViewHolder {

    public TextView vproductName, vproductPrice, vproductDescription;
    public ImageView vproductImage;
    public ItemClickListener listener;


    public ProductViewHolder(@NonNull View itemView) {
        super(itemView);

        vproductName = itemView.findViewById(R.id.productName);
        vproductPrice = itemView.findViewById(R.id.productPrice);
        vproductDescription = itemView.findViewById(R.id.productDescription);
        vproductImage = itemView.findViewById(R.id.productImage);

    }

    public void setItemClickListener(ItemClickListener listener) {
        this.listener = listener;
    }

    public void onClick(View view) {
        listener.onClick(view, getAdapterPosition(), false);
    }

}
