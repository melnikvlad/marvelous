package com.example.marvelousapp.data.network;


import android.content.Context;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.net.NetworkRequest;

import androidx.annotation.NonNull;

import com.example.marvelousapp.internals.exceptions.NoInternetException;

import java.io.IOException;

import javax.inject.Inject;

import okhttp3.Interceptor;
import okhttp3.Response;

public class CustomNetworkInterceptor implements Interceptor {
    @Inject
    Context context;

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
//        boolean hasConnection = true;
//        ConnectivityManager connectivityManager =
//                (ConnectivityManager) context.getApplicationContext().getSystemService(Context.CONNECTIVITY_SERVICE);
//        if (connectivityManager == null) return false;
//        NetworkRequest networkRequest = new NetworkRequest.Builder()
//                .addCapability(NetworkCapabilities.NET_CAPABILITY_INTERNET)
//                .build();
//        connectivityManager.registerNetworkCallback(networkRequest, new ConnectivityManager.NetworkCallback() {
//            @Override
//            public void onAvailable(@NonNull Network network) {
//                return true;
//            }
//        });


    }
}
