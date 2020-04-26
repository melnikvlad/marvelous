package com.example.marvelousapp.data.repository;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.marvelousapp.data.models.BaseItem;
import com.example.marvelousapp.data.models.common.ImageData;
import com.example.marvelousapp.data.models.characters.response.CharacterInfo;
import com.example.marvelousapp.data.models.characters.CharacterItem;
import com.example.marvelousapp.data.models.common.ReferenceInfo;
import com.example.marvelousapp.data.models.characters.response.CharacterReferences;
import com.example.marvelousapp.data.models.characters.response.CharactersData;
import com.example.marvelousapp.data.models.characters.response.CharactersResponse;
import com.example.marvelousapp.data.network.ApiService;
import com.example.marvelousapp.internals.exceptions.ResponseErrorException;
import com.example.marvelousapp.internals.utils.ParseUtils;
import com.example.marvelousapp.internals.utils.StringUtils;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observable;

public final class CharactersRepositoryImpl implements CharactersRepository {

    @NonNull
    private ApiService apiService;

    @Inject
    public CharactersRepositoryImpl(@NonNull ApiService apiService) {
        this.apiService = apiService;
    }

    @NonNull
    @Override
    public Observable<List<BaseItem>> getCharacters(@NonNull Integer count) {
        return apiService.getCharacters(count, null, null)
                .map(this::parseResponse);
    }

    @NonNull
    private List<BaseItem> parseResponse(@NonNull CharactersResponse response) throws ResponseErrorException {
        final CharactersData data = response.getData();

        if (data == null)
            throw new ResponseErrorException("Something went wrong! Request error. Try again later.");

        if (data.getCharacters() != null && data.getCount() != null && data.getCount() > 0) {
            final List<BaseItem> result = new ArrayList<>();
            final List<CharacterInfo> characters = data.getCharacters();

            for (CharacterInfo character : characters) {
                if (character.getId() != null && character.getName() != null && character.getImage() != null) {
                    final CharacterItem item = new CharacterItem(
                            character.getId(),
                            character.getName(),
                            character.getDescription(),
                            checkImage(character.getImage()),
                            ParseUtils.parseReference(character.getComics().getItems(), com.example.marvelousapp.data.models.ReferenceData.Type.COMICS),
                            ParseUtils.parseReference(character.getStories().getItems(), com.example.marvelousapp.data.models.ReferenceData.Type.STORIES),
                            ParseUtils.parseReference(character.getSeries().getItems(), com.example.marvelousapp.data.models.ReferenceData.Type.SERIES),
                            ParseUtils.parseReference(character.getEvents().getItems(), com.example.marvelousapp.data.models.ReferenceData.Type.EVENTS));
                    result.add(item);
                }
            }
            return result;
        } else {
            throw new ResponseErrorException("No characters found.");
        }
    }

    @Nullable
    private ImageData checkImage(@NonNull ImageData imageData) {
        if (imageData.getPath() == null || imageData.getExtension() == null) {
            return null;
        }
        return imageData;
    }
}
