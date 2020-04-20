package com.example.marvelousapp.data.models.characters;

import androidx.annotation.NonNull;

import com.example.marvelousapp.data.models.Result;
import com.example.marvelousapp.internals.exceptions.ResponseErrorException;

public final class ResponseErrorResult extends Result<ResponseErrorException> {

    public ResponseErrorResult(@NonNull String message) {
        super(new ResponseErrorException(message));
    }
}
