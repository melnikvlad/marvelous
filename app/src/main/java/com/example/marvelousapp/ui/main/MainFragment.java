package com.example.marvelousapp.ui.main;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.marvelousapp.MarvelousApplication;
import com.example.marvelousapp.R;
import com.example.marvelousapp.data.models.BaseItem;
import com.example.marvelousapp.data.models.characters.CharacterItem;
import com.example.marvelousapp.data.models.comics.ComicsItem;
import com.example.marvelousapp.databinding.FragmentMainBinding;
import com.example.marvelousapp.ui.main.adapter.items.HeaderListItem;
import com.example.marvelousapp.ui.main.adapter.MainAdapter;
import com.example.marvelousapp.ui.main.adapter.items.ParentListItem;

import javax.inject.Inject;

public final class MainFragment extends Fragment {

    public static final String TAG = "MainFragmentTag";

    @Inject
    ViewModelFactory viewModelFactory;
    @Nullable
    private MainViewModel mainViewModel;
    @NonNull
    private MainAdapter adapter;
    private FragmentMainBinding binding;
    @Nullable
    private OnOpenFragmentListener onOpenFragmentListener;

    private RecyclerView recyclerView;

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        if (context instanceof OnOpenFragmentListener) {
            onOpenFragmentListener = (OnOpenFragmentListener) context;
        } else {
            throw new IllegalArgumentException("Activity doesn't implement listener yet");
        }
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        adapter = new MainAdapter(getContext(), this::showCharacterFragment, (comicsItem) -> {});
    }

    @NonNull
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        MarvelousApplication.getMainComponent().inject(this);
        binding = DataBindingUtil.inflate(getLayoutInflater(), R.layout.fragment_main, container, false);
        recyclerView = binding.recyclerView;
        binding.setLifecycleOwner(getViewLifecycleOwner());
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        if (getActivity() != null) {
            final LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
            layoutManager.setOrientation(RecyclerView.VERTICAL);
            recyclerView.setLayoutManager(layoutManager);
            recyclerView.setAdapter(adapter);
            mainViewModel = new ViewModelProvider(getActivity(), viewModelFactory).get(MainViewModel.class);
            binding.setViewModel(mainViewModel);
        }
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        if (mainViewModel != null) {
            mainViewModel.getCharacters().observe(getViewLifecycleOwner(), this::renderCharactersView);
            mainViewModel.getComics().observe(getViewLifecycleOwner(), this::renderComicsView);
            mainViewModel.load();
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        onOpenFragmentListener = null;
    }

    private void renderCharactersView(@NonNull ParentListItem characters) {
        adapter.add(new HeaderListItem(R.string.text_characters_header), characters);
    }

    private void renderComicsView(@NonNull ParentListItem comics) {
        adapter.add(new HeaderListItem(R.string.text_comics_header), comics);
    }

    private void showCharacterFragment(@NonNull BaseItem characterItem) {
        if (onOpenFragmentListener != null) {
            onOpenFragmentListener.showCharacterFragment((CharacterItem) characterItem);
        }
    }

    private void showComicsFragment(@NonNull BaseItem comicsItem) {
        if (onOpenFragmentListener != null) {
            onOpenFragmentListener.showComicsFragment((ComicsItem) comicsItem);
        }
    }

    public interface OnOpenFragmentListener {

        void showCharacterFragment(@NonNull CharacterItem characterItem);

        void showComicsFragment(@NonNull ComicsItem comicsItem);
    }
}
