package com.example.marvelousapp.data.models.common;

import androidx.annotation.Nullable;

import com.google.gson.annotations.SerializedName;

public final class ReferenceInfo {
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
