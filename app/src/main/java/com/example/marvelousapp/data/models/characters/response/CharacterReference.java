package com.example.marvelousapp.data.models.characters.response;

import androidx.annotation.Nullable;

import com.google.gson.annotations.SerializedName;

public final class CharacterReference {
    @SerializedName("resourceURI")
    @Nullable
    private String uri;
    @SerializedName("name")
    @Nullable
    private String name;

    @Nullable
    public String getUri() {
        return uri;
    }

    @Nullable
    public String getName() {
        return name;
    }
}