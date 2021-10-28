package com.example.bck_poniepet.Adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.bck_poniepet.Interfaces.ISearchListOnClick;
import com.example.bck_poniepet.R;

import java.util.List;

public class AdapterRecyclerViewSearch extends RecyclerView.Adapter<AdapterRecyclerViewSearch.ViewHolder> {

    List<String> list;
    ISearchListOnClick iSearchListOnClick;

    public AdapterRecyclerViewSearch(List<String> list) {
        this.list = list;
    }

    public void setiSearchListOnClick(ISearchListOnClick iSearchListOnClick) {
        this.iSearchListOnClick = iSearchListOnClick;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_search,parent,false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.itemSearch.setText(list.get(position));

        holder.itemSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                iSearchListOnClick.onItemSearchClick(list.get(position));
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView itemSearch;
        public ViewHolder(View itemView) {
            super(itemView);
            itemSearch = itemView.findViewById(R.id.tvItemSearch);
        }
    }
}
