package com.example.marvelousapp.di.modules;

import androidx.annotation.NonNull;

import com.example.marvelousapp.data.network.ApiFactory;
import com.example.marvelousapp.data.network.ApiService;
import com.example.marvelousapp.data.network.CustomNetworkInterceptor;
import com.example.marvelousapp.data.network.RequestParamsInterceptor;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class NetworkModule {

    @Provides
    @Singleton
    ApiService providesApiService(ApiFactory apiFactory) {
        return apiFactory.create();
    }

    @Provides
    @Singleton
    ApiFactory providesApiFactory() {
        return ApiFactory.getInstance();
    }

    @Provides
    @Singleton
    CustomNetworkInterceptor providesNetworkInterceptor() {
        return new CustomNetworkInterceptor();
    }

    @Provides
    @Singleton
    RequestParamsInterceptor providesREquestParamsInterceptor() {
        return new RequestParamsInterceptor();
    }
}
