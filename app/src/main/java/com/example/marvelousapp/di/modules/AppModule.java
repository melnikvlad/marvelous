package com.example.marvelousapp.di.modules;

import android.content.Context;

import com.example.marvelousapp.ui.main.ViewModelFactory;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class AppModule {
    private Context context;

    public AppModule(Context context) {
        this.context = context;
    }

    @Provides
    Context provideContext() {
        return context;
    }

    @Provides
    @Singleton
    ViewModelFactory provideViewModelFactory() {
        return new ViewModelFactory();
    }
}
