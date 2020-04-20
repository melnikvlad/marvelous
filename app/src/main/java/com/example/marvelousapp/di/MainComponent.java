package com.example.marvelousapp.di;

import com.example.marvelousapp.di.modules.AppModule;
import com.example.marvelousapp.di.modules.CharactersDataModule;
import com.example.marvelousapp.di.modules.NetworkModule;
import com.example.marvelousapp.ui.main.MainFragment;
import com.example.marvelousapp.ui.main.ViewModelFactory;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {AppModule.class, CharactersDataModule.class, NetworkModule.class})
public interface MainComponent {

    void inject(MainFragment mainFragment);

    void inject(ViewModelFactory viewModelFactory);

}
