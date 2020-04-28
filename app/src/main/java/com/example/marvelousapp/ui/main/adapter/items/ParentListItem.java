package com.example.marvelousapp.ui.main.adapter.items;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.marvelousapp.data.models.BaseItem;

import java.util.List;

public class ParentListItem {
    @NonNull
    private Category category;
    @Nullable
    private List<BaseItem> data;

    ParentListItem(@NonNull Category category, @Nullable List<BaseItem> data) {
        this(category);
        this.data = data;
    }

    ParentListItem(@NonNull Category category) {
        this.category = category;
    }

    @Nullable
    public List<BaseItem> getData() {
        return data;
    }

    @NonNull
    public Category getCategory() {
        return category;
    }

    public enum Category {
        HEADER(0),
        CHARACTERS(1),
        COMICS(2);

        private int id;

        Category(int id) {
            this.id = id;
        }

        public int getId() {
            return id;
        }
    }
}
