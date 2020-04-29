package com.example.marvelousapp.ui.character;

import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.marvelousapp.MarvelousApplication;
import com.example.marvelousapp.R;
import com.example.marvelousapp.data.models.characters.CharacterItem;
import com.example.marvelousapp.ui.main.MainViewModel;
import com.example.marvelousapp.ui.main.ViewModelFactory;

import javax.inject.Inject;

public class CharacterFragment extends Fragment {

    public static final String TAG = "CharacterFragmentTag";
    public static final String ARGUMENTS_KEY = "character data";

    @Inject
    ViewModelFactory viewModelFactory;
    private CharacterViewModel characterViewModel;

    TextView test;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        MarvelousApplication.getMainComponent().inject(this);
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_character, container, false);
        test = view.findViewById(R.id.tvTest);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        characterViewModel = new ViewModelProvider(this, viewModelFactory).get(CharacterViewModel.class);
        if (getArguments() != null) {
            final CharacterItem character = (CharacterItem) getArguments().getSerializable(ARGUMENTS_KEY);
            test.setText(character.getName());
            characterViewModel.loadCharacter(character);
        }
    }
}
