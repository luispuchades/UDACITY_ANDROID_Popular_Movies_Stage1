package com.luispuchades.popularmovies;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.luispuchades.popularmovies.utils.Constants;
import com.squareup.picasso.Picasso;


public class MovieActivity extends AppCompatActivity {

    private Movie mIntentExtraMovie;
    //TODO: CHECK
    //private static final int DEFAULT_MOVIE = -1;

    private TextView titleTv;
    private TextView voteAverageTv;
    private TextView releaseDateTv;
    private TextView overviewTv;
    private ImageView posterIv;

    private String mMovieTitle;
    private Double mMovieVoteAverage;
    private String mMovieReleaseDate;
    private String mMovieOverview;
    private String mMoviePosterPath;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie);

        posterIv = findViewById(R.id.poster_iv);

        Intent intent = getIntent();
        if (intent == null) {
            closeOnError();
        }
        //TODO:CHECK
        //int movie = 0;
/*
        if (intent != null) {
            currentMovie = intent.getIntExtra(Constants.EXTRA_MOVIE, DEFAULT_MOVIE);
        }
        if (movie == DEFAULT_MOVIE) {
            // EXTRA_MOVIE not found in intent
            closeOnError();
            return;
        }
*/

        Bundle mIntentExtraBundle = this.getIntent().getExtras();

        if (mIntentExtraBundle != null) {
            mIntentExtraMovie = mIntentExtraBundle.getParcelable(Constants.EXTRA_MOVIE);
        }

        populateUI();
        Picasso.with(this)
                .load(mMoviePosterPath)
                .into(posterIv);

        setTitle(mMovieTitle);

    }

    private void closeOnError() {
        finish();
        Toast.makeText(this, R.string.detail_error_message, Toast.LENGTH_SHORT).show();
    }

    private void populateUI() {

        /** Capture of views from movies_list_item.xml */
        titleTv = findViewById(R.id.title_tv);
        voteAverageTv = findViewById(R.id.vote_average_tv);
        releaseDateTv = findViewById(R.id.release_date);
        overviewTv = findViewById(R.id.overview_tv);


        /** Set text to views*/
        // sandwichMainName.setText(checkData(sandwich.getMainName()))
        mMovieTitle = mIntentExtraMovie.getMovieTitle();
        mMovieVoteAverage = mIntentExtraMovie.getMovieVoteAverage();
        mMovieReleaseDate = mIntentExtraMovie.getMovieReleaseDate();
        mMovieOverview = mIntentExtraMovie.getMovieOverview();
        mMoviePosterPath = mIntentExtraMovie.getMoviePosterPath();


        titleTv.setText(checkData(mMovieTitle));

        String voteAverageString = String.valueOf(mMovieVoteAverage);
        voteAverageTv.setText(checkData(voteAverageString));

        releaseDateTv.setText(checkData(mMovieReleaseDate));
        overviewTv.setText(checkData(mMovieOverview));
        posterIv.setImageResource(Integer.parseInt(mMoviePosterPath));
    }

    private String checkData(String string) {
        if (string.equals("")) {
            return getString(R.string.no_data);
        } else {
            return string;
        }
    }

}