package com.example.marvelousapp.data.models.characters;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public final class CharacterItem {
    private int id;
    @NonNull
    private String name;
    @Nullable
    private String description;
    @NonNull
    private String imageUrl;

    public CharacterItem(int id, @NonNull String name, @Nullable String description, @Nullable String imageUrl) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.imageUrl = imageUrl;
    }

    public int getId() {
        return id;
    }

    @NonNull
    public String getName() {
        return name;
    }

    @Nullable
    public String getDescription() {
        return description;
    }

    @NonNull
    public String getImageUrl() {
        return imageUrl;
    }
}
