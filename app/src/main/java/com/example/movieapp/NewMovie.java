package com.example.movieapp;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;

public class NewMovie extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_movie);

        EditText titleInput = findViewById(R.id.new_title_input);
        Spinner yearInput = findViewById(R.id.new_date_input);
        EditText idInput = findViewById(R.id.new_id_input);
        Spinner typeInput = findViewById(R.id.new_type_input);
        EditText urlInput = findViewById(R.id.new_url_input);


        Button submitBtn = findViewById(R.id.new_submit_btn);
        submitBtn.setOnClickListener(e -> {
                String title = titleInput.getText().toString().trim();
                int year = Integer.parseInt(yearInput.getSelectedItem().toString());
                String id = idInput.getText().toString().trim();
                String type = typeInput.getSelectedItem().toString();
                String url = urlInput.getText().toString().trim();

                Movie movie = new Movie(title, year, id, type, url);


                Intent intent = new Intent();
                intent.putExtra("movie", movie);
                setResult(RESULT_OK, intent);
                finish();
        });
    }
}