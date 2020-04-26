package com.example.marvelousapp.data.models.common;

import androidx.annotation.Nullable;

import com.google.gson.annotations.SerializedName;

public final class CreatorData {
    @SerializedName("role")
    @Nullable
    private String role;
    @SerializedName("name")
    @Nullable
    private String name;

    @Nullable
    public String getRole() {
        return role;
    }

    @Nullable
    public String getName() {
        return name;
    }
}
