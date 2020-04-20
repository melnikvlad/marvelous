package com.example.marvelousapp;

import android.app.Application;

import com.example.marvelousapp.di.DaggerMainComponent;
import com.example.marvelousapp.di.MainComponent;
import com.example.marvelousapp.di.modules.AppModule;
import com.example.marvelousapp.di.modules.CharactersDataModule;
import com.example.marvelousapp.di.modules.NetworkModule;

public final class MarvelousApplication extends Application {

    private static MainComponent mainComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        mainComponent = DaggerMainComponent.builder()
                .appModule(new AppModule(this))
                .charactersDataModule(new CharactersDataModule())
                .networkModule(new NetworkModule())
                .build();
    }

    public static MainComponent getMainComponent() {
        return mainComponent;
    }
}
