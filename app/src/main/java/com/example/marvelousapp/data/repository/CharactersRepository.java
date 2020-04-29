package com.example.marvelousapp.data.repository;

import androidx.annotation.NonNull;

import com.example.marvelousapp.data.models.BaseItem;
import com.example.marvelousapp.data.models.characters.CharacterItem;

import java.util.List;

import io.reactivex.Observable;

public interface CharactersRepository {

    @NonNull
    Observable<List<BaseItem>> getCharacters(@NonNull Integer count);

    @NonNull
    Observable<BaseItem> getCharacter(int characterId);
}
