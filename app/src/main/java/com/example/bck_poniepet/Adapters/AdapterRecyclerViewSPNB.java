package com.example.bck_poniepet.Adapters;

import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.IntentSender;
import android.content.ServiceConnection;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.res.AssetManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.UserHandle;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.bck_poniepet.Fragments.ShoppingFragment;
import com.example.bck_poniepet.Interfaces.IProductOnClick;
import com.example.bck_poniepet.Objects.Product;
import com.example.bck_poniepet.R;
import com.google.android.material.internal.ContextUtils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class AdapterRecyclerViewSPNB extends RecyclerView.Adapter<AdapterRecyclerViewSPNB.Viewholder> {
    List<Product> list;
    IProductOnClick iProductOnClick;

    public AdapterRecyclerViewSPNB(List<Product> list) {
        this.list = list;
    }

    public void setiProductOnClick(IProductOnClick iProductOnClick) {
        this.iProductOnClick = iProductOnClick;
    }

    @Override
    public Viewholder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_product,parent,false);
        Viewholder viewholder = new Viewholder(view);
        return viewholder;
    }

    @Override
    public void onBindViewHolder(Viewholder holder, int position) {
        Glide.with(holder.itemView.getContext()).load(list.get(position).getImage()).into(holder.imageProduct);
        holder.nameProduct.setText(list.get(position).getName());
        holder.priceProduct.setText("₫"+list.get(position).getPrice());

        holder.item.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                iProductOnClick.onItemProductClick(list.get(position));
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class Viewholder extends RecyclerView.ViewHolder {
        ImageView imageProduct;
        TextView nameProduct,priceProduct;
        RelativeLayout item;
        public Viewholder(View itemView) {
            super(itemView);
            imageProduct = itemView.findViewById(R.id.ivImageProduct);
            nameProduct = itemView.findViewById(R.id.tvNameProduct);
            priceProduct = itemView.findViewById(R.id.tvPriceProduct);
            item = itemView.findViewById(R.id.itemProduct);
        }
    }
}
