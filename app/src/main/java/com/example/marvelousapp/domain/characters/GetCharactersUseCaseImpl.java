package com.example.marvelousapp.domain.characters;

import androidx.annotation.NonNull;

import com.example.marvelousapp.data.models.characters.CharacterItem;
import com.example.marvelousapp.data.repository.CharactersRepository;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class GetCharactersUseCaseImpl implements GetCharactersUseCase {

    @NonNull
    private CharactersRepository charactersRepository;

    @Inject
    public GetCharactersUseCaseImpl(@NonNull CharactersRepository charactersRepository) {
        this.charactersRepository = charactersRepository;
    }

    @NonNull
    @Override
    public Observable<List<CharacterItem>> getCharacters() {
        return charactersRepository.getCharacters()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }
}
