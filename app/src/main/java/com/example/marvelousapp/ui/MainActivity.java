package com.example.marvelousapp.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;
import android.widget.FrameLayout;

import com.example.marvelousapp.R;
import com.example.marvelousapp.ui.main.MainFragment;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViews();
    }

    private void initViews() {
        final FrameLayout container = findViewById(R.id.container);
        final FragmentManager fragmentManager = getSupportFragmentManager();
        final Fragment mainFragment = new MainFragment();
        fragmentManager.beginTransaction()
                .replace(container.getId(), mainFragment, MainFragment.TAG)
                .commit();
    }
}
