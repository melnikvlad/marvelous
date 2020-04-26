package com.example.marvelousapp.data.repository;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.marvelousapp.data.models.BaseItem;
import com.example.marvelousapp.data.models.comics.ComicsItem;
import com.example.marvelousapp.data.models.comics.response.Comics;
import com.example.marvelousapp.data.models.comics.response.ComicsData;
import com.example.marvelousapp.data.models.comics.response.ComicsResponse;
import com.example.marvelousapp.data.network.ApiService;
import com.example.marvelousapp.internals.exceptions.ResponseErrorException;
import com.example.marvelousapp.internals.utils.ParseUtils;
import com.example.marvelousapp.internals.utils.StringUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observable;

public final class ComicsRepositoryImpl implements ComicsRepository {

    @NonNull
    private ApiService apiService;

    @Inject
    public ComicsRepositoryImpl(@NonNull ApiService apiService) {
        this.apiService = apiService;
    }

    @Override
    public Observable<List<BaseItem>> getComics() {
        return apiService.getComics()
                .map(this::parseResponse);
    }

    @NonNull
    private List<BaseItem> parseResponse(@Nullable ComicsResponse response) throws ResponseErrorException {
        if (response == null) {
            throw new ResponseErrorException("Something went wrong! Request error. Try again later.");
        }

        final List<BaseItem> result = new ArrayList<>();
        final ComicsData data = response.getData();

        if (data == null) {
            throw new ResponseErrorException("Something went wrong! Request error. Try again later.");
        }

        if (data.getComicsList() != null) {
            for (Comics comics : data.getComicsList()) {
                if (comics.isValid()) {
                    StringBuilder fullDescription = new StringBuilder();
                    if (comics.getVariantDescription() != null) {
                        fullDescription
                                .append(comics.getVariantDescription())
                                .append(StringUtils.DOT_WITH_SPACE);
                    }
                    fullDescription
                            .append(comics.getDescription());

                    result.add(new ComicsItem(
                            comics.getId(),
                            comics.getTitle(),
                            fullDescription.toString(),
                            StringUtils.parseCreators(comics.getCreators().getCreatorList()),
                            comics.getIssueNumber(),
                            StringUtils.parsePrices(comics.getPriceList()),
                            ParseUtils.parseReference(Arrays.asList(comics.getSeries()), com.example.marvelousapp.data.models.ReferenceData.Type.SERIES),
                            comics.getImageList() != null ? comics.getImageList() : new ArrayList<>()
                    ));
                }
            }
        }

        return result;
    }
}
