package com.example.marvelousapp.domain.characters;

import androidx.annotation.NonNull;

import com.example.marvelousapp.data.models.BaseItem;
import com.example.marvelousapp.ui.main.adapter.items.CharactersListItem;

import java.util.List;

import io.reactivex.Observable;

public interface GetCharactersUseCase {

    @NonNull
    Observable<CharactersListItem> getCharacters();

    @NonNull
    Observable<List<BaseItem>> getCharacters(@NonNull Integer count);

    @NonNull
    Observable<BaseItem> getCharacter(int characterId);
}
