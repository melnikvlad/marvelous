package com.example.marvelousapp.data.repository;

import androidx.annotation.NonNull;

import com.example.marvelousapp.data.models.characters.CharactersResponse;

import io.reactivex.Single;

public interface CharactersRepository {

    @NonNull
    Single<CharactersResponse> getCharacters();
}
