package com.example.marvelousapp.internals.utils;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.marvelousapp.data.models.comics.response.ComicsPrice;
import com.example.marvelousapp.data.models.common.CreatorData;

import java.util.ArrayList;
import java.util.List;

public final class StringUtils {
    public static final String EMPTY = "";
    public static final String SPACE = " ";
    public static final String DOT = ".";
    public static final String DOT_WITH_SPACE = ". ";
    public static final String COMMA = ",";
    public static final String COMMA_WITH_SPACE = ", ";
    public static final String COLON = ":";
    public static final String COLON_WITH_SPACE = ": ";
    public static final String DASH = "-";
    public static final String DASH_WITH_SPACES = " - ";
    public static final String SLASH = "/";
    public static final String NEW_LINE = "\n";
    public static final String DOUBLE_NEW_LINE = "\n\n";

    public static int parseReferenceId(@NonNull String url) {
        int lastSlashPos = url.lastIndexOf(SLASH);
        return Integer.valueOf(url.substring(lastSlashPos + 1));
    }

    public static List<String> parseCreators(@Nullable List<CreatorData> list) {
        if (list != null && list.size() > 0) {
            List<String> result = new ArrayList<>();
            for (CreatorData creator : list) {
                result.add(new StringBuilder()
                        .append(creator.getRole())
                        .append(COLON_WITH_SPACE)
                        .append(creator.getName())
                        .toString());
            }
            return result;
        } else {
            return new ArrayList<>();
        }
    }

    public static List<String> parsePrices(@Nullable List<ComicsPrice> list) {
        if (list != null && list.size() > 0) {
            List<String> result = new ArrayList<>();
            for (ComicsPrice price : list) {
                result.add(new StringBuilder()
                        .append(price.getType())
                        .append(COLON_WITH_SPACE)
                        .append(price.getPrice())
                        .toString());
            }
            return result;
        } else {
            return new ArrayList<>();
        }
    }
}
