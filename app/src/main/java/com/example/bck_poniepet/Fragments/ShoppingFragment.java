package com.example.bck_poniepet.Fragments;

import android.graphics.Paint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.bck_poniepet.API.APIClient;
import com.example.bck_poniepet.API.APIClientpm;
import com.example.bck_poniepet.Adapters.AdapterRecyclerViewSPNB;
import com.example.bck_poniepet.Adapters.AdapterRecyclerViewSearch;
import com.example.bck_poniepet.Interfaces.IProductOnClick;
import com.example.bck_poniepet.Interfaces.ISearchListOnClick;
import com.example.bck_poniepet.Objects.Product;
import com.example.bck_poniepet.R;
import com.example.bck_poniepet.databinding.FragmentShoppingBinding;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ShoppingFragment extends Fragment {
    FragmentShoppingBinding binding;
    List<Product> list;
    AdapterRecyclerViewSearch adapterRecyclerViewSearch;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_shopping,container,false);

        list = new ArrayList<>();
        adapterRecyclerViewSearch = new AdapterRecyclerViewSearch(getListItemSearch());
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext(),RecyclerView.HORIZONTAL,false);
        binding.rvSearchList.setLayoutManager(layoutManager);
        binding.rvSearchList.setAdapter(adapterRecyclerViewSearch);
        adapterRecyclerViewSearch.setiSearchListOnClick(new ISearchListOnClick() {
            @Override
            public void onItemSearchClick(String str) {
                Toast.makeText(getContext(),str,Toast.LENGTH_SHORT).show();
            }
        });

        binding.tvSeeAllSpnb.setPaintFlags(binding.tvSeeAllSpnb.getPaintFlags() | Paint.UNDERLINE_TEXT_FLAG);
        binding.tvSeeAllSpnb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(),"See all",Toast.LENGTH_SHORT).show();
            }
        });

        Call<List<Product>> call = APIClient.create().onGetProduct();
        call.enqueue(new Callback<List<Product>>() {
            @Override
            public void onResponse(Call<List<Product>> call, Response<List<Product>> response) {
                list = response.body();
                AdapterRecyclerViewSPNB adapterRecyclerViewSPNB = new AdapterRecyclerViewSPNB(list);
                RecyclerView.LayoutManager layoutManager1 = new GridLayoutManager(getContext(),2,RecyclerView.VERTICAL,false);
                binding.rvSanPhamNoiBat.setLayoutManager(layoutManager1);
                binding.rvSanPhamNoiBat.setAdapter(adapterRecyclerViewSPNB);

                adapterRecyclerViewSPNB.setiProductOnClick(new IProductOnClick() {
                    @Override
                    public void onItemProductClick(Product product) {
                        Toast.makeText(getContext(),product.getName(),Toast.LENGTH_SHORT).show();
                    }
                });
            }

            @Override
            public void onFailure(Call<List<Product>> call, Throwable t) {
                Toast.makeText(getContext(),t.getMessage(),Toast.LENGTH_SHORT).show();
            }
        });

        binding.tvSeeAllUdnb.setPaintFlags(binding.tvSeeAllUdnb.getPaintFlags() | Paint.UNDERLINE_TEXT_FLAG);
        binding.tvSeeAllUdnb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(),"See all",Toast.LENGTH_SHORT).show();
            }
        });

        return binding.getRoot();
    }

    private List<String> getListItemSearch(){
        List<String> list = new ArrayList<>();
        list.add("All");
        list.add("Thức ăn");
        list.add("Đồ dùng, phụ kiện");
        list.add("Vệ sinh, chăm sóc");
        return list;
    }
}
