package com.example.marvelousapp.domain.comics;

import com.example.marvelousapp.ui.main.adapter.ComicsListItem;

import io.reactivex.Observable;

public interface GetComicsUseCase {
    Observable<ComicsListItem> getComics();
}
