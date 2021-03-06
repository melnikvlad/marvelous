package com.example.marvelousapp.data.network;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.marvelousapp.MarvelousApplication;
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

import java.util.concurrent.TimeUnit;

import javax.inject.Inject;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiFactory {
    @Nullable
    private static ApiFactory INSTANCE;

    private static final String URL = "https://gateway.marvel.com/v1/public/";

    private ApiFactory() { }

    public static synchronized ApiFactory getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new ApiFactory();
        }
        return INSTANCE;
    }

    public ApiService create() {
        final OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .addNetworkInterceptor(new CustomNetworkInterceptor())
                .addInterceptor(new RequestParamsInterceptor())
                .readTimeout(15, TimeUnit.SECONDS)
                .build();

        final Retrofit retrofit = new Retrofit.Builder()
                .client(okHttpClient)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(URL)
                .build();

        return retrofit.create(ApiService.class);
    }
}
