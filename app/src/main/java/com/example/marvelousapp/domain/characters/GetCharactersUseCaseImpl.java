package com.example.marvelousapp.domain.characters;

import androidx.annotation.NonNull;

import com.example.marvelousapp.data.models.characters.CharactersResponse;
import com.example.marvelousapp.data.repository.CharactersRepository;

import io.reactivex.Single;

public class GetCharactersUseCaseImpl implements GetCharactersUseCase {

    @NonNull
    private CharactersRepository charactersRepository;

    public GetCharactersUseCaseImpl(@NonNull CharactersRepository charactersRepository) {
        this.charactersRepository = charactersRepository;
    }

    @NonNull
    @Override
    public Single<CharactersResponse> getCharacters() {
        return charactersRepository.getCharacters();
    }
}
