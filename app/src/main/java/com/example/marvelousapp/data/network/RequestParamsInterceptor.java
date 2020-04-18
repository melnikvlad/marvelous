package com.example.marvelousapp.data.network;

import com.example.marvelousapp.internals.utils.RequestEncodingUtils;

import java.io.IOException;

import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

public final class RequestParamsInterceptor implements Interceptor {

    private static final String PUBLIC_KEY = "684b92e67198efc6069c95cc7ed10954";
    private static final int TS = 21;

    @Override
    public Response intercept(Chain chain) throws IOException {
        Request request = chain.request();

        HttpUrl url = request.url();

        HttpUrl urlBuilder = url.newBuilder()
                .addQueryParameter("apiKey", RequestEncodingUtils.encode(TS, PUBLIC_KEY))
                .build();

        Request newRequest = request.newBuilder().url(urlBuilder).build();

        return chain.proceed(newRequest);
    }
}
