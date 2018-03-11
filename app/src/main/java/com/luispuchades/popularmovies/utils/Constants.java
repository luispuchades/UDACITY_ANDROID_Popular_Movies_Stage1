package com.luispuchades.popularmovies.utils;

/**
 * This class updates the app constants.
 * Created by luisp on 11/03/2018.
 */

public class Constants {

    /* Create URL for the movie path*/
    public static final String THEMOVIEDB_POSTER_PATH_BASE_URL = "http://image.tmdb.org/t/p";
    // TODO: Check if /w185/ should be /185 without last slash
    public static final String THEMOVIEDB_POSTER_PHONE_SIZE = "/w185/";

    public static final String THEMOVIEDB_POSTER_URL = THEMOVIEDB_POSTER_PATH_BASE_URL +
            THEMOVIEDB_POSTER_PHONE_SIZE;


    public static final String THEMOVIEDB_BASE_URL = "https://api.themoviedb.org";
    public static final String THEMOVIEDB_ENDPOINT_POPULAR = "/movie/popular?api_key=";
    public static final String THEMOVIEDB_ENDPOINT_TOP_RATED = "/movie/top_rated?api_key=";

    // TODO: CHANGE "YOUR_API_KEY" TO THE PERSONAL KEY
    public static final String THEMOVIEDB_API_KEY = "YOUR_API_KEY";
}
