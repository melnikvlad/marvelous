package com.example.marvelousapp.data.models;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class Result<T> {
    @Nullable
    private T data;
    @Nullable
    private Exception error;

    public Result(@NonNull Exception error) {
        this(null, error);
    }

    public Result(@NonNull T data) {
        this(data, null);
    }

    private Result(@Nullable T data, @Nullable Exception error) {
        this.data = data;
        this.error = error;
    }

    public boolean isValid() {
        return error == null && data != null;
    }

    @Nullable
    public T getData() {
        return data;
    }

    @Nullable
    public Exception getError() {
        return error;
    }
}
