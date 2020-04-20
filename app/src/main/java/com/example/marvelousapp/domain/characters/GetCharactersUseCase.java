package com.example.marvelousapp.domain.characters;

import androidx.annotation.NonNull;

import com.example.marvelousapp.data.models.characters.CharacterItem;

import java.util.List;

import io.reactivex.Observable;
import io.reactivex.Single;

public interface GetCharactersUseCase {

    @NonNull
    Observable<List<CharacterItem>> getCharacters();
}
