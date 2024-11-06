package com.example.movieapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.bumptech.glide.Glide;

public class MovieDetails extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_details);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        if(getSupportActionBar() != null){
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }

        Intent intent = getIntent();

        ImageView imageView = findViewById(R.id.details_image_viewer);
        TextView titleView = findViewById(R.id.details_title_viewer);
        TextView yearView = findViewById(R.id.details_year_viewer);
        TextView idView = findViewById(R.id.details_id_viewer);
        TextView typeView = findViewById(R.id.details_type_viewer);

        Glide.with(imageView.getContext())
                .load(intent.getStringExtra("url"))
                .placeholder(R.drawable.ic_placeholder)
                .error(R.drawable.ic_error)
                .into(imageView);

        String title = "Title: " + intent.getStringExtra("title");
        String year = "Year: " + String.valueOf(intent.getIntExtra("year", 0));
        String id = "imdbID: " + intent.getStringExtra("id");
        String type = "Type: " + intent.getStringExtra("type");

        titleView.setText(title);
        yearView.setText(year);
        idView.setText(id);
        typeView.setText(type);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            getOnBackPressedDispatcher().onBackPressed();
            return true;
        }
        return false;
    }
}