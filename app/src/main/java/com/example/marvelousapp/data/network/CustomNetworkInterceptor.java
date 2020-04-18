package com.example.marvelousapp.data.network;


import com.example.marvelousapp.internals.exceptions.NoInternetException;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Response;

public class CustomNetworkInterceptor implements Interceptor {

    @SuppressWarnings("NullableProblems")
    @Override
    public Response intercept(Chain chain) throws IOException {
        if (!hasConnection()) {
            throw new NoInternetException();
        }

        return chain.proceed(chain.request());
    }

    private boolean hasConnection() {
        return true;
    }
}
