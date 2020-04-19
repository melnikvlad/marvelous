package com.example.marvelousapp.ui;

import android.os.Bundle;

import com.example.marvelousapp.R;
import com.example.marvelousapp.data.network.ApiFactory;
import com.example.marvelousapp.data.network.ApiService;
import com.example.marvelousapp.data.repository.CharactersRepository;
import com.example.marvelousapp.data.repository.CharactersRepositoryImpl;
import com.example.marvelousapp.domain.characters.GetCharactersUseCase;
import com.example.marvelousapp.domain.characters.GetCharactersUseCaseImpl;
import com.example.marvelousapp.internals.exceptions.EncodeParamsException;
import com.example.marvelousapp.internals.exceptions.NoInternetException;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class ScrollingActivity extends AppCompatActivity {

    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scrolling);
        Toolbar toolbar = findViewById(R.id.toolbar);
        textView = findViewById(R.id.textViewMain);
        setSupportActionBar(toolbar);
        init();
    }

    private void init() {
        ApiService apiService = ApiFactory.getInstance().create();
        CharactersRepository repository = new CharactersRepositoryImpl(apiService);
        GetCharactersUseCase getCharactersUseCase = new GetCharactersUseCaseImpl(repository);

        getCharactersUseCase.getCharacters()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                        data -> {
                            textView.setText(data.toString());
                        },
                        error -> {
                            if (error instanceof EncodeParamsException) {
                                textView.setText("Encode trouble");
                            } else if (error instanceof NoInternetException) {
                                textView.setText("No internet");
                            } else {
                                textView.setText(error.getMessage());
                            }
                        }
                );
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_scrolling, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
