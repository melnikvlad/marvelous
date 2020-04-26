package com.example.marvelousapp.ui.main.adapter;

import androidx.annotation.NonNull;

import com.example.marvelousapp.data.models.BaseItem;

import java.util.List;

public final class ComicsListItem extends ParentListItem {
    public ComicsListItem(@NonNull List<BaseItem> data) {
        super(Category.COMICS, data);
    }
}
