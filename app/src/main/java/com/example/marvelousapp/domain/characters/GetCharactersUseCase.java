package com.example.marvelousapp.domain.characters;

import androidx.annotation.NonNull;

import com.example.marvelousapp.data.models.characters.CharactersResponse;

import io.reactivex.Single;

public interface GetCharactersUseCase {

    @NonNull
    Single<CharactersResponse> getCharacters();
}
