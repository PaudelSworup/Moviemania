package com.example.moviemania;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MoviesAdapter extends RecyclerView.Adapter<MoviesAdapter.ViewHolder> {
    LayoutInflater inflater;
    List<Movie> movie;

    public MoviesAdapter(Context context , List<Movie> movie ){
        this.inflater = LayoutInflater.from(context);
        this.movie = movie;

    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.movie_list_item,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.title.setText(movie.get(position).getTitle());
        holder.description.setText(movie.get(position).getDescription());
       // Picasso.get().load(movie.get(position).getCardImg()).into(holder.movieImage);
    }

    @Override
    public int getItemCount() {
        return movie.size();
    }

    public class ViewHolder extends  RecyclerView.ViewHolder{
        TextView title, description;
        ImageView movieImage;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.title);
            description = itemView.findViewById(R.id.description);
            movieImage = itemView.findViewById(R.id.image);
        }
    }
}
