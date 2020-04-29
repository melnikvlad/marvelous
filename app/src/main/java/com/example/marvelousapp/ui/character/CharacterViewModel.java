package com.example.marvelousapp.ui.character;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.ViewModel;

import com.example.marvelousapp.data.models.characters.CharacterItem;
import com.example.marvelousapp.domain.characters.GetCharactersUseCase;

import io.reactivex.disposables.CompositeDisposable;

public class CharacterViewModel extends ViewModel {
    @NonNull
    private GetCharactersUseCase getCharactersUseCase;
    private CompositeDisposable subscriptions = new CompositeDisposable();

    public CharacterViewModel(@NonNull GetCharactersUseCase getCharactersUseCase) {
        this.getCharactersUseCase = getCharactersUseCase;
    }

    void loadCharacter(@Nullable CharacterItem character) {
        if (character != null) {

//            subscriptions.add(
//                    getCharactersUseCase.getCharacter(character.getId())
//                            .subscribe());
        } else {
            /* render null state */
        }
    }
}
