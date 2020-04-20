package com.example.marvelousapp.ui.main;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import com.example.marvelousapp.MarvelousApplication;
import com.example.marvelousapp.domain.characters.GetCharactersUseCase;

import javax.inject.Inject;

public class ViewModelFactory implements ViewModelProvider.Factory {
    @Inject
    GetCharactersUseCase getCharactersUseCase;

    @SuppressWarnings("unchecked")
    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        MarvelousApplication.getMainComponent().inject(this);
        if (modelClass.isAssignableFrom(MainViewModel.class)) {
            return (T) new MainViewModel(getCharactersUseCase);
        }
        throw new IllegalArgumentException("Unknown view model class");
    }
}
