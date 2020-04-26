package com.example.marvelousapp.data.models.characters.response;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.marvelousapp.data.models.common.ImageData;
import com.example.marvelousapp.internals.utils.StringUtils;
import com.google.gson.annotations.SerializedName;

public final class CharacterInfo {
    @SerializedName("id")
    @Nullable
    private Integer id;
    @SerializedName("name")
    @Nullable
    private String name;
    @SerializedName("description")
    @Nullable
    private String description;
    @SerializedName("thumbnail")
    @Nullable
    private ImageData image;
    @SerializedName("comics")
    @Nullable
    private CharacterReferences comics;
    @SerializedName("stories")
    @Nullable
    private CharacterReferences stories;
    @SerializedName("events")
    @Nullable
    private CharacterReferences events;
    @SerializedName("series")
    @Nullable
    private CharacterReferences series;

    @Nullable
    public Integer getId() {
        return id;
    }

    @Nullable
    public String getName() {
        return name;
    }

    @Nullable
    public String getDescription() {
        return description;
    }

    @Nullable
    public ImageData getImage() {
        return image;
    }

    @Nullable
    public CharacterReferences getComics() {
        return comics;
    }

    @Nullable
    public CharacterReferences getStories() {
        return stories;
    }

    @Nullable
    public CharacterReferences getEvents() {
        return events;
    }

    @Nullable
    public CharacterReferences getSeries() {
        return series;
    }

    @NonNull
    @Override
    public String toString() {
        final String result = new StringBuilder()
                .append(StringUtils.DOUBLE_NEW_LINE)
                .append("CharacterInfo")
                .append(StringUtils.COLON_WITH_SPACE)
                .append(StringUtils.NEW_LINE)
                .append(id != null ? id : "No id")
                .append(StringUtils.DASH_WITH_SPACES)
                .append(name != null ? name : "No name")
                .append(StringUtils.NEW_LINE)
                .append(description != null ? description : "Mo description")
                .append(StringUtils.NEW_LINE)
                .append("Image")
                .append(StringUtils.COLON_WITH_SPACE)
                .append(image != null ? image.toString() : "No image")
                .toString();
        return result;
    }
}
