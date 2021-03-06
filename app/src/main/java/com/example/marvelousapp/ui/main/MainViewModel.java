package com.example.marvelousapp.ui.main;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.marvelousapp.domain.characters.GetCharactersUseCase;
import com.example.marvelousapp.domain.comics.GetComicsUseCase;
import com.example.marvelousapp.internals.exceptions.EncodeParamsException;
import com.example.marvelousapp.internals.exceptions.NoInternetException;
import com.example.marvelousapp.internals.exceptions.ResponseErrorException;
import com.example.marvelousapp.ui.main.adapter.items.CharactersListItem;
import com.example.marvelousapp.ui.main.adapter.items.ComicsListItem;
import com.example.marvelousapp.ui.main.adapter.items.ParentListItem;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;

public final class MainViewModel extends ViewModel {
    @NonNull
    private GetCharactersUseCase getCharactersUseCase;
    @NonNull
    private GetComicsUseCase getComicsUseCase;

    @NonNull
    private CompositeDisposable subscriptions = new CompositeDisposable();

    private MutableLiveData<Boolean> mutableIsLoading = new MutableLiveData<>();
    private LiveData<Boolean> isLoading = mutableIsLoading;

    private MutableLiveData<ParentListItem> mutableCharacters = new MutableLiveData<>();
    private LiveData<ParentListItem> characters = mutableCharacters;

    private MutableLiveData<ParentListItem> mutableComics = new MutableLiveData<>();
    private LiveData<ParentListItem> comics = mutableComics;

    MainViewModel(@NonNull GetCharactersUseCase getCharactersUseCase,
                  @NonNull GetComicsUseCase getComicsUseCase) {
        this.getCharactersUseCase = getCharactersUseCase;
        this.getComicsUseCase = getComicsUseCase;
    }

    void load() {
        subscriptions.add(Observable.merge(
                getCharactersUseCase.getCharacters(),
                getComicsUseCase.getComics())
                .doOnSubscribe(__ -> mutableIsLoading.postValue(true))
                .doOnComplete(() -> mutableIsLoading.postValue(false))
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                        listItem -> {
                            if (listItem instanceof CharactersListItem) {
                                mutableCharacters.setValue(listItem);
                            } else if (listItem instanceof ComicsListItem) {
                                mutableComics.setValue(listItem);
                            }
                        },
                        error -> {
                            if (error instanceof ResponseErrorException) {

                            } else if (error instanceof NoInternetException) {

                            } else if (error instanceof EncodeParamsException) {

                            }
                        }
                ));
    }

    void clearSubscriptions() {
        subscriptions.clear();
    }

    @Override
    protected void onCleared() {
        super.onCleared();
        clearSubscriptions();
    }

    public LiveData<ParentListItem> getCharacters() {
        return characters;
    }

    public LiveData<ParentListItem> getComics() {
        return comics;
    }

    public LiveData<Boolean> isLoading() {
        return isLoading;
    }
}
