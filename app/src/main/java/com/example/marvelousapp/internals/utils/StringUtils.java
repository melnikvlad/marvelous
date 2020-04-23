package com.example.marvelousapp.internals.utils;

import androidx.annotation.NonNull;

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
}
