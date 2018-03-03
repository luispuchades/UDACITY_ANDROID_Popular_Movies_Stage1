package com.luispuchades.popularmovies;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;

import java.util.Date;

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

    /* String for the Plot Synopsis "overview"*/
    private String mMovieOverview;

    /* String for poster_path */
    private Uri mMoviePosterUri;


    public Movie(String movieTitle,Double voteAverage, String
            movieReleaseDate, String movieOverview,  Uri moviePosterUri) {
        this.mMovieTitle = movieTitle;
        this.mMovieVoteAverage = voteAverage;
        this.mMovieReleaseDate = movieReleaseDate;
        this.mMovieOverview = movieOverview;
        this.mMoviePosterUri = moviePosterUri;
    }

    private Movie(Parcel in) {
        mMovieTitle = in.readString();
        mMovieVoteAverage = in.readDouble();
        mMovieReleaseDate = in.readString();
        mMovieOverview = in.readString();
        mMoviePosterUri = (Uri) in.readValue(Movie.class.getClassLoader());
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

    /* OVERVIEW - Plot Synopsis */
    public String getMovieOverview() {
        return mMovieOverview;
    }
    public void setMovieOverview(String movieOverview){
        mMovieOverview = movieOverview;
    }

    /* POSTER PATH */
    public Uri getMoviePosterUri() {
        return mMoviePosterUri;
    }
    public void setMoviePosterUri(Uri moviePosterUri) {
        mMoviePosterUri = moviePosterUri;
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
        parcel.writeValue(mMoviePosterUri);
    }

    /* Parcelable Creator */
    public final Parcelable.Creator<Movie> CREATOR = new Parcelable.Creator<Movie>() {

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
