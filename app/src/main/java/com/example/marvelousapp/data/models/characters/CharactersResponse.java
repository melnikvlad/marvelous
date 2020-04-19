package com.example.marvelousapp.data.models.characters;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.marvelousapp.internals.utils.StringUtils;
import com.google.gson.annotations.SerializedName;

public final class CharactersResponse {
    @SerializedName("code")
    @Nullable
    private Integer code;
    @SerializedName("attributionText")
    @Nullable
    private String attributionText;
    @SerializedName("data")
    @Nullable
    private CharactersData data;

    @Nullable
    public Integer getCode() {
        return code;
    }

    @Nullable
    public String getAttributionText() {
        return attributionText;
    }

    @Nullable
    public CharactersData getData() {
        return data;
    }

    @NonNull
    @Override
    public String toString() {
        final String result = new StringBuilder()
                .append("Code")
                .append(StringUtils.COLON_WITH_SPACE)
                .append(code != null ? code : "Error Code")
                .append(StringUtils.NEW_LINE)
                .append(data != null ? data.toString() : "No data")
                .toString();

        return result;
    }
}
