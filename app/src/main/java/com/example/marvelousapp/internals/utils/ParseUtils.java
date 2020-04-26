package com.example.marvelousapp.internals.utils;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.marvelousapp.data.models.ReferenceData;
import com.example.marvelousapp.data.models.common.ReferenceInfo;

import java.util.ArrayList;
import java.util.List;

public final class ParseUtils {

    @Nullable
    public static List<ReferenceData> parseReference(@Nullable List<ReferenceInfo> references, @NonNull com.example.marvelousapp.data.models.ReferenceData.Type type) {
        if (references != null && references.size() > 0) {
            final List<com.example.marvelousapp.data.models.ReferenceData> result = new ArrayList<>();
            for (ReferenceInfo reference : references) {
                int id = reference.getUri() != null ? StringUtils.parseReferenceId(reference.getUri()) : -1;
                final String name = reference.getName() != null ? reference.getName() : StringUtils.EMPTY;

                if (id != -1 && !StringUtils.EMPTY.equals(name)) {
                    final com.example.marvelousapp.data.models.ReferenceData referenceData = new com.example.marvelousapp.data.models.ReferenceData(type, id, name);
                    result.add(referenceData);
                }
            }
            return result;
        } else
            return null;
    }
}
