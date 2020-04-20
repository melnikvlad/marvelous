package com.example.marvelousapp.di.modules;

import com.example.marvelousapp.data.network.ApiService;
import com.example.marvelousapp.data.repository.CharactersRepository;
import com.example.marvelousapp.data.repository.CharactersRepositoryImpl;
import com.example.marvelousapp.domain.characters.GetCharactersUseCase;
import com.example.marvelousapp.domain.characters.GetCharactersUseCaseImpl;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class CharactersDataModule {

    @Provides
    @Singleton
    CharactersRepository provideGetCharacterRepository(ApiService apiService) {
        return new CharactersRepositoryImpl(apiService);
    }

    @Provides
    @Singleton
    GetCharactersUseCase provideGetCharacterUseCase(CharactersRepository charactersRepository) {
        return new GetCharactersUseCaseImpl(charactersRepository);
    }
}
