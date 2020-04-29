package com.example.marvelousapp.domain.characters;

import androidx.annotation.NonNull;

import com.example.marvelousapp.data.models.BaseItem;
import com.example.marvelousapp.data.repository.CharactersRepository;
import com.example.marvelousapp.ui.main.adapter.items.CharactersListItem;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class GetCharactersUseCaseImpl implements GetCharactersUseCase {
    private static final int DEFAULT_LIMIT = 15;

    @NonNull
    private CharactersRepository charactersRepository;

    @Inject
    public GetCharactersUseCaseImpl(@NonNull CharactersRepository charactersRepository) {
        this.charactersRepository = charactersRepository;
    }

    @NonNull
    @Override
    public Observable<CharactersListItem> getCharacters() {
        return charactersRepository.getCharacters(DEFAULT_LIMIT)
                .map(CharactersListItem::new)
                .subscribeOn(Schedulers.io());
    }

    @NonNull
    @Override
    public Observable<List<BaseItem>> getCharacters(@NonNull Integer count) {
        return charactersRepository.getCharacters(count)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }

    @NonNull
    @Override
    public Observable<BaseItem> getCharacter(int characterId) {
        return charactersRepository.getCharacter(characterId);
    }
}
