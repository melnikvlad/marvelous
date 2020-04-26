package com.example.marvelousapp.data.models.characters.response;

import androidx.annotation.Nullable;

import com.example.marvelousapp.data.models.common.ReferenceInfo;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public final class CharacterReferences {
    @SerializedName("available")
    @Nullable
    private Integer available;
    @SerializedName("returned")
    @Nullable
    private Integer returned;
    @SerializedName("collectionURI")
    @Nullable
    private String uri;
    @SerializedName("items")
    @Nullable
    private List<ReferenceInfo> items;

    @Nullable
    public Integer getAvailable() {
        return available;
    }

    @Nullable
    public Integer getReturned() {
        return returned;
    }

    @Nullable
    public String getUri() {
        return uri;
    }

    @Nullable
    public List<ReferenceInfo> getItems() {
        return items;
    }
}
