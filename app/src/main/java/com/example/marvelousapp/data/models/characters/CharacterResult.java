package com.example.marvelousapp.data.models.characters;

import androidx.annotation.NonNull;

import com.example.marvelousapp.data.models.Result;

import java.util.List;

public final class CharacterResult extends Result<List<CharacterItem>> {

    public CharacterResult(@NonNull List<CharacterItem> data) {
        super(data);
    }
}
