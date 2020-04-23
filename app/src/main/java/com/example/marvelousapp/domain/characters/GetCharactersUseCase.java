package com.example.marvelousapp.domain.characters;

import androidx.annotation.NonNull;

import com.example.marvelousapp.data.models.BaseItem;

import java.util.List;

import io.reactivex.Observable;

public interface GetCharactersUseCase {

    @NonNull
    Observable<List<BaseItem>> getCharacters();

    @NonNull
    Observable<List<BaseItem>> getCharacters(@NonNull Integer count);
}
