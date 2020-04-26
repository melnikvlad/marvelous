package com.example.marvelousapp.data.models.comics.response;

import androidx.annotation.Nullable;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public final class ComicsData {
    @SerializedName("results")
    @Nullable
    private List<Comics> comicsList;

    @Nullable
    public List<Comics> getComicsList() {
        return comicsList;
    }
}
