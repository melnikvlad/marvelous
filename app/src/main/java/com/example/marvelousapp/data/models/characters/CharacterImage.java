package com.example.marvelousapp.data.models.characters;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.marvelousapp.internals.utils.StringUtils;
import com.google.gson.annotations.SerializedName;

final class CharacterImage {
    @SerializedName("path")
    @Nullable
    private String path;
    @SerializedName("extension")
    @Nullable
    private String extension;

    @Nullable
    public String getPath() {
        return path;
    }

    @Nullable
    public String getExtension() {
        return extension;
    }

    @NonNull
    @Override
    public String toString() {
        final String result = new StringBuilder()
                .append("Image")
                .append(StringUtils.COLON_WITH_SPACE)
                .append(path)
                .append(StringUtils.DOT)
                .append(extension)
                .toString();
        return result;
    }
}
