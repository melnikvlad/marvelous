package com.example.marvelousapp.ui.main;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.marvelousapp.data.models.characters.CharacterItem;
import com.example.marvelousapp.data.models.characters.CharacterResult;
import com.example.marvelousapp.data.models.characters.ResponseErrorResult;
import com.example.marvelousapp.domain.characters.GetCharactersUseCase;
import com.example.marvelousapp.internals.exceptions.EncodeParamsException;
import com.example.marvelousapp.internals.exceptions.NoInternetException;
import com.example.marvelousapp.internals.exceptions.ResponseErrorException;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.inject.Inject;

import io.reactivex.disposables.CompositeDisposable;

public final class MainViewModel extends ViewModel {
    @NonNull
    private GetCharactersUseCase getCharactersUseCase;
    @NonNull
    private CompositeDisposable subscriptions = new CompositeDisposable();

    private MutableLiveData<Boolean> mutableIsLoading = new MutableLiveData<>();
    private LiveData<Boolean> isLoading = mutableIsLoading;

    private MutableLiveData<List<CharacterItem>> mutableCharacters = new MutableLiveData<>();
    private LiveData<List<CharacterItem>> characters = mutableCharacters;

    MainViewModel(@NonNull GetCharactersUseCase getCharactersUseCase) {
        this.getCharactersUseCase = getCharactersUseCase;
    }

    void load() {
        loadCharacters();
    }

    private void loadCharacters() {
        subscriptions.add(
                getCharactersUseCase.getCharacters()
                        .doOnSubscribe(__ -> mutableIsLoading.setValue(true))
                        .doOnComplete(() -> mutableIsLoading.setValue(false))
                        .subscribe(
                                result -> {
                                    if (result.size() > 0) {
                                        mutableCharacters.setValue(result);
                                    }
                                },
                                error -> {
                                    if (error instanceof ResponseErrorException) {

                                    } else if (error instanceof NoInternetException) {

                                    } else if (error instanceof EncodeParamsException) {

                                    }
                                }
                        )
        );
    }

    @Override
    protected void onCleared() {
        super.onCleared();
        subscriptions.clear();
    }

    LiveData<List<CharacterItem>> getCharacters() {
        return characters;
    }

    LiveData<Boolean> isLoading() {
        return isLoading;
    }
}
