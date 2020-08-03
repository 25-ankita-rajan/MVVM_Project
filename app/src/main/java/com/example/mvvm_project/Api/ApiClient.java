package com.example.mvvm_project.Api;

import android.content.Context;

import com.example.mvvm_project.AuthInterceptor.AuthInterceptor;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClient {

    public static final String BASE_URL = "https://radiant-chamber-21628.herokuapp.com/api/";
    private static Retrofit retrofit = null;

    public static Retrofit getClient(Context context) {

        OkHttpClient.Builder okHttpBuilder = new OkHttpClient.Builder();
        okHttpBuilder.addInterceptor(new AuthInterceptor(context)).build();


        if (retrofit==null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .client(okHttpBuilder.build())
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }
}
