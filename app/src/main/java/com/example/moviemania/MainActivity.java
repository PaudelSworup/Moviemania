package com.example.moviemania;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    RecyclerView moviesView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        moviesView = findViewById(R.id.movies);

        RequestQueue queue = Volley.newRequestQueue(this);

        MovieGetter movieGetter = new ViewModelProvider(this).get(MovieGetter.class);
        movieGetter.getPopularMovies(1, queue);

        final Observer<List<Movie>> moviesObserver = new Observer<List<Movie>>() {
            @Override
            public void onChanged(@Nullable final List<Movie> movies) {
                MoviesAdapter adapter = new MoviesAdapter(getApplicationContext(), movies);
                moviesView.setAdapter(adapter);
                moviesView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
            }
        };

        movieGetter.popularMovies.observe(this, moviesObserver);



    }
}