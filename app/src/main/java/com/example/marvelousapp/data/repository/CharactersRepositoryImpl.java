package com.example.marvelousapp.data.repository;

import androidx.annotation.NonNull;

import com.example.marvelousapp.data.models.characters.CharactersResponse;
import com.example.marvelousapp.data.network.ApiService;

import io.reactivex.Single;

public final class CharactersRepositoryImpl implements CharactersRepository {
    private static final int DEFAULT_LIMIT = 50;

    @NonNull
    private ApiService apiService;

    public CharactersRepositoryImpl(@NonNull ApiService apiService) {
        this.apiService = apiService;
    }

    @NonNull
    @Override
    public Single<CharactersResponse> getCharacters() {
        return apiService.getCharacters(DEFAULT_LIMIT, null, null);
    }
}
