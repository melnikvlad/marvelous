package com.example.marvelousapp.data.models.characters;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.marvelousapp.data.models.BaseItem;
import com.example.marvelousapp.data.models.ReferenceData;
import com.example.marvelousapp.data.models.common.ImageData;

import java.util.List;

public final class CharacterItem extends BaseItem {
    private int id;
    @NonNull
    private String name;
    @Nullable
    private String description;
    @Nullable
    private ImageData image;
    @Nullable
    private List<ReferenceData> comics;
    @Nullable
    private List<ReferenceData> stories;
    @Nullable
    private List<ReferenceData> series;
    @Nullable
    private List<ReferenceData> events;

    public CharacterItem(int id, @NonNull String name, @Nullable String description, @Nullable ImageData image,
                         @Nullable List<ReferenceData> comics, @Nullable List<ReferenceData> stories,
                         @Nullable List<ReferenceData> series, @Nullable List<ReferenceData> events) {
        super(ListItemType.CHARACTER);
        this.id = id;
        this.name = name;
        this.description = description;
        this.image = image;
        this.comics = comics;
        this.stories = stories;
        this.series = series;
        this.events = events;
    }

    public int getId() {
        return id;
    }

    @NonNull
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
    public List<ReferenceData> getComics() {
        return comics;
    }

    @Nullable
    public List<ReferenceData> getStories() {
        return stories;
    }

    @Nullable
    public List<ReferenceData> getSeries() {
        return series;
    }

    @Nullable
    public List<ReferenceData> getEvents() {
        return events;
    }
}
