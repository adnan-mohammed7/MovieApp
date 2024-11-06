package com.example.movieapp;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ViewHolder> {

    private final ArrayList<Movie> movieArrayList;

    /**
     * Provide a reference to the type of views that you are using
     * (custom ViewHolder)
     */
    public static class ViewHolder extends RecyclerView.ViewHolder {
        private final ImageView imageViewer;
        private final TextView title;
        private final TextView year;

        public ViewHolder(View view) {
            super(view);
            // Define click listener for the ViewHolder's View

            imageViewer = view.findViewById(R.id.image_viewer);
            title = view.findViewById(R.id.title_viewer);
            year = view.findViewById(R.id.year_viewer);
        }
    }

    /**
     * Initialize the dataset of the Adapter
     *
     * @param dataSet String[] containing the data to populate views to be used
     * by RecyclerView
     */
    public RecyclerAdapter(ArrayList<Movie> dataSet) {
        movieArrayList = dataSet;
    }

    // Create new views (invoked by the layout manager)
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        // Create a new view, which defines the UI of the list item
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.recycler_item, viewGroup, false);

        return new ViewHolder(view);
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(ViewHolder viewHolder, final int position) {

        Movie movie = movieArrayList.get(position);

        // Load the movie poster using Glide
        Glide.with(viewHolder.imageViewer.getContext())
                .load(movie.getPosterUrl())
                .placeholder(R.drawable.ic_placeholder)
                .error(R.drawable.ic_error)
                .into(viewHolder.imageViewer);
        viewHolder.title.setText(movie.getTitle());
        viewHolder.year.setText(String.valueOf(movie.getYear()));
    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return movieArrayList.size();
    }
}