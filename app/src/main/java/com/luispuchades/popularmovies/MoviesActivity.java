package com.luispuchades.popularmovies;

import android.app.LoaderManager;
import android.content.Loader;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.util.List;

public class MoviesActivity extends AppCompatActivity implements LoaderManager
        .LoaderCallbacks<List<Movie>>{

    /* Tag for Log Messages */
    private static final String LOG_TAG = MoviesActivity.class.getName();

    /**
     * Constant value for the movie loader ID. We can choose any integer.
     * This really only comes into play if you're using multiple loaders.
     */
    private static final int MOVIE_LOADER_ID = 1;

    /** Adapter for the list of movies */
    private MovieAdapter mAdapter;

    /** TextView that is displayed when the list is empty */
    private TextView mEmptyStateTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movies);



    }


    @Override
    public Loader<List<Movie>> onCreateLoader(int id, Bundle args) {
        return null;
    }

    @Override
    public void onLoadFinished(Loader<List<Movie>> loader, List<Movie> data) {

    }

    @Override
    public void onLoaderReset(Loader<List<Movie>> loader) {

    }
}
