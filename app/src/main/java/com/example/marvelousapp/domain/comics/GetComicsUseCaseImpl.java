package com.example.marvelousapp.domain.comics;

import androidx.annotation.NonNull;

import com.example.marvelousapp.data.repository.ComicsRepository;
import com.example.marvelousapp.ui.main.adapter.ComicsListItem;


import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.schedulers.Schedulers;

public final class GetComicsUseCaseImpl implements GetComicsUseCase {

    @NonNull
    private ComicsRepository comicsRepository;

    @Inject
    public GetComicsUseCaseImpl(@NonNull ComicsRepository comicsRepository) {
        this.comicsRepository = comicsRepository;
    }

    @Override
    public Observable<ComicsListItem> getComics() {
        return comicsRepository.getComics()
                .map(ComicsListItem::new)
                .subscribeOn(Schedulers.io());
    }
}
