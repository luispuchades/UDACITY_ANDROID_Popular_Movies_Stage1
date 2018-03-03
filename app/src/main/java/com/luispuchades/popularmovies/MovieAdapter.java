package com.luispuchades.popularmovies;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;

import java.util.List;

/**
 * Created by luisp on 01/03/2018.
 */

public class MovieAdapter extends ArrayAdapter<Movie> {

    public MovieAdapter(Activity context, List<Movie> movieAdapter) {
        super(context, 0, movieAdapter);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        // Find the movie at the given position in the list of earthquakes
        Movie currentMovie = getItem(position);

        // Check if there is an existing list item view (called convertView) that we can reuse,
        // otherwise, if convertView is null, then inflate a new list item layout.
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.movies_item, parent, false);
        }

        // TODO: CHECK .setMoviePosterUri
        ImageView posterImage = (ImageView) listItemView.findViewById(R.id.poster_iv);
        posterImage.setImageResource(currentMovie.setMoviePosterUri());



        return super.getView(position, convertView, parent);
    }
}


