package com.example.marvelousapp.data.models.comics.response;

import androidx.annotation.Nullable;

import com.google.gson.annotations.SerializedName;

public final class ComicsResponse {
    @SerializedName("code")
    private int code;
    @SerializedName("data")
    @Nullable
    private ComicsData data;

    public int getCode() {
        return code;
    }

    @Nullable
    public ComicsData getData() {
        return data;
    }
}
