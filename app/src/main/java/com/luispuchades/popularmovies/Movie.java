package com.luispuchades.popularmovies;

import android.os.Parcel;
import android.os.Parcelable;

import com.luispuchades.popularmovies.utils.Constants;

/**
 * Created by luisp on 27/02/2018.
 */

public class Movie implements Parcelable {

    /* Movie details layout contains title, release date, movie poster, vote average, and plot synopsis. */

    /* String for the Title */
    private String mMovieTitle;

    /* Double for the User Rating "vote_average"*/
    private double mMovieVoteAverage;

    /* String for the Release Date */
    private String mMovieReleaseDate;

    /* Date format variable */
    private static final String MOVIE_DATE_FORMAT = "YYYY-MM-DD";

    /* String for the Plot Synopsis "overview"*/
    private String mMovieOverview;

    /* String for poster_path */
    private String mMoviePosterPath;

    public Movie(String movieTitle,Double voteAverage, String
            movieReleaseDate, String movieOverview,  String moviePosterPath) {
        this.mMovieTitle = movieTitle;
        this.mMovieVoteAverage = voteAverage;
        this.mMovieReleaseDate = movieReleaseDate;
        this.mMovieOverview = movieOverview;
        this.mMoviePosterPath = moviePosterPath;
    }

    //TODO: CHECK
    public Movie(Parcel in) {
        this.mMovieTitle = in.readString();
        this.mMovieVoteAverage = in.readDouble();
        this.mMovieReleaseDate = in.readString();
        this.mMovieOverview = in.readString();
        this.mMoviePosterPath = in.readString();
    }

    /*********************/
    /* GETTERS & SETTERS */
    /*********************/

    /* TITLE */
    public String getMovieTitle() {
        return mMovieTitle;
    }
    public void setMovieTitle(String movieTitle) {
        mMovieTitle = movieTitle;
    }

    /* VOTE AVERAGE */
    public Double getMovieVoteAverage() {
        return mMovieVoteAverage;
    }
    public void setMovieVoteAverage(Double movieVoteAverage) {
        mMovieVoteAverage = movieVoteAverage;
    }

    /* RELEASE DATE */
    public String getMovieReleaseDate() {
        return mMovieReleaseDate;
    }
    public void setMovieReleaseDate(String movieReleaseDate) {
        mMovieReleaseDate = movieReleaseDate;
    }

    /* DATE FORMAT */
    public String getMovieDateFormat() {

        return MOVIE_DATE_FORMAT;
    }


    /* OVERVIEW - Plot Synopsis */
    public String getMovieOverview() {
        return mMovieOverview;
    }
    public void setMovieOverview(String movieOverview){
        mMovieOverview = movieOverview;
    }

    /* POSTER PATH */
    public String getMoviePosterPath() {

        return Constants.THEMOVIEDB_POSTER_PATH_BASE_URL + Constants.THEMOVIEDB_POSTER_PHONE_SIZE
                + mMoviePosterPath;
    }
    public void setMoviePosterPath(String moviePosterPath) {
        mMoviePosterPath = moviePosterPath;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(mMovieTitle);
        parcel.writeDouble(mMovieVoteAverage);
        parcel.writeString(mMovieReleaseDate);
        parcel.writeString(mMovieOverview);
        parcel.writeString(mMoviePosterPath);
    }

    /* Parcelable Creator */
    public static final Parcelable.Creator<Movie> CREATOR = new Parcelable.Creator<Movie>() {

        @Override
        public Movie createFromParcel(Parcel parcel) {
            return new Movie(parcel);
        }

        @Override
        public Movie[] newArray(int i) {
            return new Movie[i];
        }
    };

}
