package com.example.bck_poniepet.API;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class APIClient {
    public static final String BASE_URL="";
    public static Retrofit retrofit = null;
    public static APIClientpm create(){
        return getClient(BASE_URL).create(APIClientpm.class);
    }

    public static Retrofit getClient(String url){
        if (retrofit == null){
            retrofit = new Retrofit.Builder().baseUrl(url)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }
}
