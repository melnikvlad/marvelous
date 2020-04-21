package com.example.marvelousapp.internals.utils;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.marvelousapp.data.models.characters.response.CharacterImage;
import com.example.marvelousapp.internals.enums.ImageSizeType;

public final class ImageUtils {

    @Nullable
    public static String createImagePath(@NonNull CharacterImage characterImage, @NonNull ImageSizeType imageType) {
        if (characterImage.getPath() == null || characterImage.getExtension() == null) {
            return null;
        } else {
            return new StringBuilder()
                    .append(characterImage.getPath())
                    .append(StringUtils.SLASH)
                    .append(imageType.getType())
                    .append(StringUtils.DOT)
                    .append(characterImage.getExtension())
                    .toString();
        }
    }
}
