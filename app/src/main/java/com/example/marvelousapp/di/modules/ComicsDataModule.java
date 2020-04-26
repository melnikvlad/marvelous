package com.example.marvelousapp.di.modules;

import com.example.marvelousapp.data.network.ApiService;
import com.example.marvelousapp.data.repository.ComicsRepository;
import com.example.marvelousapp.data.repository.ComicsRepositoryImpl;
import com.example.marvelousapp.domain.comics.GetComicsUseCase;
import com.example.marvelousapp.domain.comics.GetComicsUseCaseImpl;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class ComicsDataModule {

    @Provides
    @Singleton
    ComicsRepository provideGetCharacterRepository(ApiService apiService) {
        return new ComicsRepositoryImpl(apiService);
    }

    @Provides
    @Singleton
    GetComicsUseCase provideGetCharacterUseCase(ComicsRepository comicsRepository) {
        return new GetComicsUseCaseImpl(comicsRepository);
    }
}
