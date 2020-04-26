package com.example.marvelousapp.data.models.common;

import android.media.Image;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.marvelousapp.data.models.characters.CharacterItem;
import com.example.marvelousapp.internals.utils.ImageUtils;
import com.example.marvelousapp.internals.utils.StringUtils;
import com.google.gson.annotations.SerializedName;

public final class ImageData {
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
