package com.example.marvelousapp.data.models;

import androidx.annotation.NonNull;

import com.example.marvelousapp.internals.utils.StringUtils;

import java.io.Serializable;

public final class ReferenceData implements Serializable {
    @NonNull
    Type type;
    @NonNull
    private int id;
    @NonNull
    private String name;

    public ReferenceData(@NonNull Type type, int id, @NonNull String name) {
        this.type = type;
        this.id = id;
        this.name = name;
    }

    @NonNull
    public Type getType() {
        return type;
    }

    public int getId() {
        return id;
    }

    @NonNull
    public String getName() {
        return name;
    }

    @NonNull
    @Override
    public String toString() {
        String result = new StringBuilder()
                .append("Reference")
                .append(StringUtils.COLON_WITH_SPACE)
                .append("type")
                .append(StringUtils.COLON_WITH_SPACE)
                .append(this.type)
                .append(StringUtils.SPACE)
                .append("id")
                .append(StringUtils.COLON_WITH_SPACE)
                .append(this.id)
                .append(StringUtils.SPACE)
                .append("name")
                .append(StringUtils.COLON_WITH_SPACE)
                .append(this.name)
                .toString();
        return result;
    }

    public enum Type {
        COMICS,
        STORIES,
        SERIES,
        EVENTS;
    }
}
