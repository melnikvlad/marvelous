package com.example.marvelousapp.data.models.characters.response;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.marvelousapp.data.models.characters.response.CharacterInfo;
import com.example.marvelousapp.internals.utils.StringUtils;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public final class CharactersData {
    @SerializedName("offset")
    @Nullable
    private Integer offset;
    @SerializedName("limit")
    @Nullable
    private Integer limit;
    @SerializedName("total")
    @Nullable
    private Integer total;
    @SerializedName("count")
    @Nullable
    private Integer count;
    @SerializedName("results")
    @Nullable
    private List<CharacterInfo> characters;

    @Nullable
    public Integer getOffset() {
        return offset;
    }

    @Nullable
    public Integer getLimit() {
        return limit;
    }

    @Nullable
    public Integer getTotal() {
        return total;
    }

    @Nullable
    public Integer getCount() {
        return count;
    }

    @Nullable
    public List<CharacterInfo> getCharacters() {
        return characters;
    }

    @NonNull
    @Override
    public String toString() {
        final String result = new StringBuilder()
                .append("Characters")
                .append(StringUtils.COLON_WITH_SPACE)
                .append(StringUtils.NEW_LINE)
                .append("Count")
                .append(StringUtils.COLON_WITH_SPACE)
                .append(count != null ? count : 0)
                .append(StringUtils.NEW_LINE)
                .append(characters != null ? characters.toString() : "No characters")
                .toString();
        return result;
    }
}
