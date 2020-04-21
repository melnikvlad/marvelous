package com.example.marvelousapp.ui.main;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.marvelousapp.MarvelousApplication;
import com.example.marvelousapp.R;
import com.example.marvelousapp.data.models.characters.CharacterItem;
import com.google.android.material.snackbar.Snackbar;

import java.util.List;

import javax.inject.Inject;

public final class MainFragment extends Fragment {

    public static final String TAG = "MainFragmentTag";

    @Inject
    ViewModelFactory viewModelFactory;
    @Nullable
    private MainViewModel mainViewModel;
    @NonNull
    private MainAdapter adapter;

    ProgressBar progress;
    RecyclerView recyclerView;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        adapter = new MainAdapter();
    }

    @NonNull
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        MarvelousApplication.getMainComponent().inject(this);
        View view = inflater.inflate(R.layout.fragment_main, container, false);
        progress = view.findViewById(R.id.progress);
        recyclerView = view.findViewById(R.id.recyclerView);
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
        recyclerView.setVisibility(isLoading ? View.GONE : View.VISIBLE);
    }

    private void renderCharactersView(@NonNull List<CharacterItem> characters) {
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        layoutManager.setOrientation(RecyclerView.HORIZONTAL);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
        adapter.setData(characters);
    }
}
