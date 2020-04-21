package com.example.marvelousapp.data.models.characters;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.marvelousapp.data.models.characters.response.CharacterImage;

public final class CharacterItem {
    private int id;
    @NonNull
    private String name;
    @Nullable
    private String description;
    @Nullable
    private CharacterImage image;

    public CharacterItem(int id, @NonNull String name, @Nullable String description, @Nullable CharacterImage image) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.image = image;
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

    @Nullable
    public CharacterImage getImage() {
        return image;
    }
}
