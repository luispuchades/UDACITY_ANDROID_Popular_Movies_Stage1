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

    /*
     * URL EXAMPLES
     * http://api.themoviedb.org/3/movie/popular?api_key=[API_KEY]
     * http://api.themoviedb.org/3/movie/top_rated?api_key=[API_KEY]
     */

    public static final String THEMOVIEDB_BASE_URL = "https://api.themoviedb.org/3/movie/";
    public static final String THEMOVIEDB_ENDPOINT_POPULAR = "popular";
    public static final String THEMOVIEDB_ENDPOINT_TOP_RATED = "top_rated";
    public static final String THEMOVIEDB_ENDPOINT_API_KEY = "api_key";


    // TODO: CHANGE "YOUR_API_KEY" TO THE PERSONAL KEY
    // public static final String THEMOVIEDB_API_KEY = "YOUR_API_KEY";
    public static final String THEMOVIEDB_API_KEY = "YOUR_API_KEY";
}
