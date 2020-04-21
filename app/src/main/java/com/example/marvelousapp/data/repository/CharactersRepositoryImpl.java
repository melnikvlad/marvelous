package com.example.marvelousapp.data.repository;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.marvelousapp.data.models.characters.response.CharacterImage;
import com.example.marvelousapp.data.models.characters.response.CharacterInfo;
import com.example.marvelousapp.data.models.characters.CharacterItem;
import com.example.marvelousapp.data.models.characters.response.CharactersData;
import com.example.marvelousapp.data.models.characters.response.CharactersResponse;
import com.example.marvelousapp.data.network.ApiService;
import com.example.marvelousapp.internals.exceptions.ResponseErrorException;
import com.example.marvelousapp.internals.utils.StringUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.Single;

public final class CharactersRepositoryImpl implements CharactersRepository {
    private static final int DEFAULT_LIMIT = 50;

    @NonNull
    private ApiService apiService;

    @Inject
    public CharactersRepositoryImpl(@NonNull ApiService apiService) {
        this.apiService = apiService;
    }

    @NonNull
    @Override
    public Observable<List<CharacterItem>> getCharacters() {
        return apiService.getCharacters(DEFAULT_LIMIT, null, null)
                .map(this::parseResponse);
    }

    @NonNull
    private List<CharacterItem> parseResponse(@NonNull CharactersResponse response) throws ResponseErrorException {
        final CharactersData data = response.getData();

        if (data == null)
            throw new ResponseErrorException("Something went wrong! Request error. Try again later.");

        if (data.getCharacters() != null && data.getCount() != null && data.getCount() > 0) {
            final List<CharacterItem> result = new ArrayList<>();
            final List<CharacterInfo> characters = data.getCharacters();

            for (CharacterInfo character : characters) {
                // Show characters with the name and image not equals null
                if (character.getId() != null && character.getName() != null && character.getImage() != null) {
                    final CharacterItem item = new CharacterItem(
                            character.getId(),
                            character.getName(),
                            character.getDescription(),
                            checkImage(character.getImage()));
                    result.add(item);
                }
            }
            return result;
        } else {
            throw new ResponseErrorException("No characters found.");
        }
    }

    @Nullable
    private CharacterImage checkImage(@NonNull CharacterImage characterImage) {
        if (characterImage.getPath() == null || characterImage.getExtension() == null) {
            return null;
        }
        return characterImage;
    }
}
