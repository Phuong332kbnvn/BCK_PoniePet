package com.example.bck_poniepet.Adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.example.bck_poniepet.Interfaces.IActivityOnClick;
import com.example.bck_poniepet.Objects.Activity;
import com.example.bck_poniepet.R;
import com.example.bck_poniepet.databinding.ItemRvactivityBinding;

import java.util.List;

public class AdapterRycyclerViewActivity extends RecyclerView.Adapter<AdapterRycyclerViewActivity.Viewholder> {
    List<Activity> list;
    IActivityOnClick iActivityOnClick;

    public AdapterRycyclerViewActivity(List<Activity> list) {
        this.list = list;
    }

    public void setiActivityOnClick(IActivityOnClick iActivityOnClick) {
        this.iActivityOnClick = iActivityOnClick;
    }

    @Override
    public Viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_rvactivity, parent, false);
        Viewholder viewholder = new Viewholder(view);
        return viewholder;
    }

    @Override
    public void onBindViewHolder(Viewholder holder, int position) {
        holder.imageView.setImageResource(list.get(position).getResourceImg());

        holder.imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                iActivityOnClick.onImageClick(list.get(position));
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class Viewholder extends RecyclerView.ViewHolder {
        ImageView imageView;

        public Viewholder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.ivItemActivity);
        }
    }
}
