package com.example.marvelousapp.ui.main;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import com.example.marvelousapp.MarvelousApplication;
import com.example.marvelousapp.R;
import com.example.marvelousapp.data.models.characters.CharacterItem;

import java.util.List;

import javax.inject.Inject;

public final class MainFragment extends Fragment {

    public static final String TAG = "MainFragmentTag";

    @Inject
    ViewModelFactory viewModelFactory;
    @Nullable
    private MainViewModel mainViewModel;

    TextView tv;
    ProgressBar progress;

    @NonNull
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        MarvelousApplication.getMainComponent().inject(this);
        View view = inflater.inflate(R.layout.fragment_main, container, false);
        tv = view.findViewById(R.id.result);
        progress = view.findViewById(R.id.progress);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        if (getActivity() != null) {
            mainViewModel = new ViewModelProvider(getActivity(), viewModelFactory).get(MainViewModel.class);
        }
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        if (mainViewModel != null) {
            mainViewModel.getCharacters().observe(getViewLifecycleOwner(), this::renderCharactersView);
            mainViewModel.isLoading().observe(getViewLifecycleOwner(), this::renderLoaderView);
            mainViewModel.load();
        }
    }

    private void renderLoaderView(boolean isLoading) {
        progress.setVisibility(isLoading ? View.VISIBLE : View.GONE);
    }

    private void renderCharactersView(@NonNull List<CharacterItem> characters) {
        tv.setText(characters.toString());
    }
}
