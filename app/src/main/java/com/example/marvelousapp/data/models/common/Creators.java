package com.example.marvelousapp.data.models.common;

import androidx.annotation.Nullable;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public final class Creators {
    @SerializedName("items")
    @Nullable
    private List<CreatorData> creatorList;

    @Nullable
    public List<CreatorData> getCreatorList() {
        return creatorList;
    }
}
