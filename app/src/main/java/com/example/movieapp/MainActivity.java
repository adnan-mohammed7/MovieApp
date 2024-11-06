package com.example.movieapp;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {
    private ArrayList<Movie> movies = new ArrayList<>(Arrays.asList(
            new Movie("Bodyguard", 2011, "m001", "Movie", "https://i.imgur.com/vranu8L.jpeg"),
            new Movie("Ready", 2011, "m002", "Movie", "https://i.imgur.com/xwNE49d.jpeg"),
            new Movie("Veer", 2010, "m003", "Movie", "https://i.imgur.com/rVPdBqe.jpeg"),
            new Movie("Kick", 2014, "m004", "Movie", "https://i.imgur.com/15YJ7Db.jpeg"),
            new Movie("Ek Tha Tiger", 2012, "m005", "Movie", "https://i.imgur.com/ZSO9CzZ.jpeg"),
            new Movie("Tiger Zinda Hai", 2017, "m006", "Movie", "https://i.imgur.com/KoQWSlS.jpeg"),
            new Movie("Wanted", 2009, "m007", "Movie", "https://i.imgur.com/9esfKOF.jpeg"),
            new Movie("Radhe", 2021, "m008", "Movie", "https://i.imgur.com/VrLyebX.jpeg"),
            new Movie("Antim: The Final Truth", 2021, "m009", "Movie", "https://i.imgur.com/yrBmhZs.jpeg"),
            new Movie("Sultan", 2016, "m010", "Movie", "https://i.imgur.com/PvjX7F0.jpeg")
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
        ItemTouchHelper helper = new ItemTouchHelper(new ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT) {
            @Override
            public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder target) {
                return false;
            }

            @Override
            public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int direction) {
                int pos = viewHolder.getLayoutPosition();
                movies.remove(pos);
                adapter.notifyItemRemoved(pos);
            }
        });
        helper.attachToRecyclerView(recyclerView);
    }
    public void createMovie(){
        
    }

}