package com.example.movieapp;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {
    private ArrayList<Movie> movies = new ArrayList<>(Arrays.asList(
            new Movie("Bodyguard", 2011, "m001", "Movie", "https://upload.wikimedia.org/wikipedia/en/a/af/Bodyguard_poster.jpg"),
            new Movie("Ready", 2011, "m002", "Movie", "https://i.imgur.com/F7pr997.jpeg"),
            new Movie("Veer", 2010, "m003", "Movie", "https://example.com/veer.jpg"),
            new Movie("Kick", 2014, "m004", "Movie", "https://example.com/kick.jpg"),
            new Movie("Ek Tha Tiger", 2012, "m005", "Movie", "https://example.com/ekthtiger.jpg"),
            new Movie("Tiger Zinda Hai", 2017, "m006", "Movie", "https://example.com/tigerzindahai.jpg"),
            new Movie("Wanted", 2009, "m007", "Movie", "https://example.com/wanted.jpg"),
            new Movie("Radhe", 2021, "m008", "Movie", "https://example.com/radhe.jpg"),
            new Movie("Antim: The Final Truth", 2021, "m009", "Movie", "https://example.com/antim.jpg"),
            new Movie("Sultan", 2016, "m010", "Movie", "https://example.com/sultan.jpg")
    ));

    private RecyclerView recyclerView;
    private RecyclerAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.display);
        adapter = new RecyclerAdapter(movies);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        FloatingActionButton fab = findViewById(R.id.add_fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                createMovie();
            }
        });
    }
    public void createMovie(){

    }

}