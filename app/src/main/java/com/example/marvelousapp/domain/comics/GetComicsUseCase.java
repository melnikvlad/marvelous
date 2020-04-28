package com.example.marvelousapp.domain.comics;

import com.example.marvelousapp.ui.main.adapter.items.ComicsListItem;

import io.reactivex.Observable;

public interface GetComicsUseCase {
    Observable<ComicsListItem> getComics();
}
