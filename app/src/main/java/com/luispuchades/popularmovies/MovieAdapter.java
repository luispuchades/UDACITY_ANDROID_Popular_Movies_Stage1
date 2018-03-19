package com.luispuchades.popularmovies;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;

import com.luispuchades.popularmovies.utils.Constants;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by luisp on 01/03/2018.
 */

public class MovieAdapter extends ArrayAdapter<Movie> {

    /* Tag for Log Messages */
    private static final String LOG_TAG = MovieAdapter.class.getSimpleName();

    private Context mContext;

    /**
     * Constructs a new {@link MovieAdapter}.
     *
     * @param context of the app
     * @param movies is the list of earthquakes, which is the data source of the adapter
     */
    public MovieAdapter(Context context, List<Movie> movies) {
        super(context, 0, movies);
        mContext = context;
    }



    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {


        // Check if there is an existing list item view (called convertView) that we can reuse,
        // otherwise, if convertView is null, then inflate a new list item layout.
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(mContext).inflate(
                    R.layout.movies_list_item, parent, false);
        }

        // Find the movie at the given position in the list of earthquakes
        Movie currentMovie = getItem(position);

        // Find the ImageView with the ID grid_movie_item
        ImageView posterImage = listItemView.findViewById(R.id.grid_movie_item);

        // TODO: CHECK
        /** Capture movie path*/
        String moviePosterPath = currentMovie.getMoviePosterPath();
        Log.e(LOG_TAG, moviePosterPath);

        Picasso.with(mContext)
                .load(Constants.THEMOVIEDB_POSTER_URL + moviePosterPath)
                .resize(mContext.getResources().getInteger(R.integer
                        .themoviedb_poster_w185_width),
                        mContext.getResources().getInteger(R.integer.themoviedb_poster_w185_height))
                .placeholder(R.drawable.poster_placeholder)
                .error(R.drawable.poster_placeholder_error)
                .into(posterImage);

        return listItemView;
    }
}


