package com.example.movieapp;
import android.content.Context;
import android.content.Intent;
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

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private final ImageView imageViewer;
        private final TextView title;
        private final TextView year;

        public ViewHolder(View view) {
            super(view);
            imageViewer = view.findViewById(R.id.image_viewer);
            title = view.findViewById(R.id.title_viewer);
            year = view.findViewById(R.id.year_viewer);
        }
    }

    public RecyclerAdapter(ArrayList<Movie> dataSet) {
        movieArrayList = dataSet;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.recycler_item, viewGroup, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, final int position) {

        Movie movie = movieArrayList.get(position);

        Glide.with(viewHolder.imageViewer.getContext())
                .load(movie.getPosterUrl())
                .placeholder(R.drawable.ic_placeholder)
                .error(R.drawable.ic_error)
                .into(viewHolder.imageViewer);
        viewHolder.title.setText(movie.getTitle());
        viewHolder.year.setText(String.valueOf(movie.getYear()));

        viewHolder.itemView.setOnClickListener(e -> {
                Context context = e.getContext();
                Intent intent = new Intent(context, MovieDetails.class);
                intent.putExtra("title", movie.getTitle());
                intent.putExtra("year", movie.getYear());
                intent.putExtra("id", movie.getImdbID());
                intent.putExtra("type", movie.getType());
                intent.putExtra("url", movie.getPosterUrl());

                context.startActivity(intent);
        });
    }
    
    @Override
    public int getItemCount() {
        return movieArrayList.size();
    }
}