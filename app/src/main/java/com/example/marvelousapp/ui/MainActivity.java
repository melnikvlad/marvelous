package com.example.marvelousapp.ui;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;
import android.widget.FrameLayout;

import com.example.marvelousapp.R;
import com.example.marvelousapp.data.models.characters.CharacterItem;
import com.example.marvelousapp.data.models.comics.ComicsItem;
import com.example.marvelousapp.ui.character.CharacterFragment;
import com.example.marvelousapp.ui.main.MainFragment;

public class MainActivity extends AppCompatActivity implements MainFragment.OnOpenFragmentListener {

    FrameLayout container;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        container = findViewById(R.id.container);

        initViews();
    }

    @Override
    public void showComicsFragment(@NonNull ComicsItem comicsItem) {

    }

    @Override
    public void showCharacterFragment(@NonNull CharacterItem characterItem) {
        final Fragment characterFragment = new CharacterFragment();
        final Bundle args = new Bundle();
        args.putSerializable(CharacterFragment.ARGUMENTS_KEY, characterItem);
        characterFragment.setArguments(args);
        getSupportFragmentManager().beginTransaction()
                .add(container.getId(), characterFragment, CharacterFragment.TAG)
                .commit();
    }

    private void initViews() {
        final Fragment mainFragment = new MainFragment();
        getSupportFragmentManager().beginTransaction()
                .replace(container.getId(), mainFragment, MainFragment.TAG)
                .commit();
    }
}
