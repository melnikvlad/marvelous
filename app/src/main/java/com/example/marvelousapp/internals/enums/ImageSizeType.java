package com.example.marvelousapp.internals.enums;

import androidx.annotation.NonNull;

public enum ImageSizeType {

    PORTRAIT_SMALL("portrait_medium"),

    PORTRAIT_XLARGE("portrait_xlarge"),

    PORTRAIT_FULL("portrait_fantastic"),

    LANDSCAPE_FULL("landscape_incredible");

    @NonNull
    private String type;

    ImageSizeType(@NonNull String serverImageType) {
        type = serverImageType;
    }

    @NonNull
    public String getType() {
        return type;
    }
}

