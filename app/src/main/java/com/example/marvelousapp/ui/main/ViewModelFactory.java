package com.example.marvelousapp.ui.main;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import com.example.marvelousapp.MarvelousApplication;
import com.example.marvelousapp.domain.characters.GetCharactersUseCase;
import com.example.marvelousapp.domain.comics.GetComicsUseCase;
import com.example.marvelousapp.ui.character.CharacterViewModel;

import javax.inject.Inject;

public class ViewModelFactory implements ViewModelProvider.Factory {
    @Inject
    GetCharactersUseCase getCharactersUseCase;
    @Inject
    GetComicsUseCase getComicsUseCase;

    @SuppressWarnings("unchecked")
    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        MarvelousApplication.getMainComponent().inject(this);
        if (modelClass.isAssignableFrom(MainViewModel.class)) {
            return (T) new MainViewModel(getCharactersUseCase, getComicsUseCase);
        } else if (modelClass.isAssignableFrom(CharacterViewModel.class)) {
            return (T) new CharacterViewModel(getCharactersUseCase);
        }
        throw new IllegalArgumentException("Unknown view model class");
    }
}
