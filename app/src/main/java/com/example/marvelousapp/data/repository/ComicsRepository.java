package com.example.marvelousapp.data.repository;

import com.example.marvelousapp.data.models.BaseItem;

import java.util.List;

import io.reactivex.Observable;

public interface ComicsRepository {
    Observable<List<BaseItem>> getComics();
}
