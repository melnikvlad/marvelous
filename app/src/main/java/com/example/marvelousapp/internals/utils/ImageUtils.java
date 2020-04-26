package com.example.marvelousapp.internals.utils;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.marvelousapp.data.models.common.ImageData;
import com.example.marvelousapp.internals.enums.ImageSizeType;

public final class ImageUtils {

    @Nullable
    public static String createImagePath(@NonNull ImageData imageData, @NonNull ImageSizeType imageType) {
        if (imageData.getPath() == null || imageData.getExtension() == null) {
            return null;
        } else {
            return new StringBuilder()
                    .append(imageData.getPath())
                    .append(StringUtils.SLASH)
                    .append(imageType.getType())
                    .append(StringUtils.DOT)
                    .append(imageData.getExtension())
                    .toString();
        }
    }
}
