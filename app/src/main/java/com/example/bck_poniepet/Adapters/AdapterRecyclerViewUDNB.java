package com.example.bck_poniepet.Adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.bck_poniepet.Interfaces.IProductOnClick;
import com.example.bck_poniepet.Objects.Product;
import com.example.bck_poniepet.R;

import java.util.List;

public class AdapterRecyclerViewUDNB extends RecyclerView.Adapter<AdapterRecyclerViewUDNB.Viewholder> {
    List<Product> list;
    IProductOnClick iProductOnClick;

    public AdapterRecyclerViewUDNB(List<Product> list) {
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
        holder.saleIcon.setImageResource(R.drawable.sale);
        Glide.with(holder.itemView.getContext()).load(list.get(position).getImage()).into(holder.imageProduct);
        holder.nameProduct.setText(list.get(position).getName());
        holder.priceProduct.setText("₫"+list.get(position).getPrice());
        holder.salePrice.setText("₫"+list.get(position).getSaleprice());
        holder.salePrice.setVisibility(View.VISIBLE);
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
        ImageView imageProduct,saleIcon;
        TextView nameProduct,priceProduct,salePrice;
        RelativeLayout item;
        public Viewholder(View itemView) {
            super(itemView);
            saleIcon = itemView.findViewById(R.id.ivSaleIcon);
            imageProduct = itemView.findViewById(R.id.ivImageProduct);
            nameProduct = itemView.findViewById(R.id.tvNameProduct);
            salePrice = itemView.findViewById(R.id.tvSalePrice);
            priceProduct = itemView.findViewById(R.id.tvPriceProduct);
            item = itemView.findViewById(R.id.itemProduct);
        }
    }
}
