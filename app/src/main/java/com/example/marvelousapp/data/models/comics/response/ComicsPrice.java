package com.example.marvelousapp.data.models.comics.response;

import androidx.annotation.Nullable;

import com.google.gson.annotations.SerializedName;

public final class ComicsPrice {
    @SerializedName("price")
    @Nullable
    private Double price;
    @SerializedName("type")
    @Nullable
    private String type;

    @Nullable
    public Double getPrice() {
        return price;
    }

    @Nullable
    public String getType() {
        return type;
    }
}
