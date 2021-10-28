package com.example.bck_poniepet.API;

import com.example.bck_poniepet.Objects.Product;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface APIClientpm {
    @GET("onProduct")
    Call<List<Product>> onGetProduct();
}
