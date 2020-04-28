package com.example.marvelousapp.ui.main.adapter.items;

import androidx.annotation.NonNull;

import com.example.marvelousapp.data.models.BaseItem;

import java.util.List;

public final class CharactersListItem extends ParentListItem {

    public CharactersListItem(@NonNull List<BaseItem> data) {
        super(Category.CHARACTERS, data);
    }
}
