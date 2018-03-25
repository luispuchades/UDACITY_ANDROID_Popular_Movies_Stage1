package com.luispuchades.popularmovies;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MenuItem;

/**
 * SettingsActivity is responsible for displaying the {@link SettingsFragment}. It is also
 * responsible for orchestrating proper navigation when the up button is clicked. When the up
 * button is clicked from the SettingsActivity, we want to navigate to the Activity that the user
 * came from to get to the SettingsActivity.
 *
 * For example, when the user is in the DetailActivity and clicks the settings option in the menu,
 * and then clicks the up button, we want to navigate back to the DetailActivity. If the user
 * navigates to the SettingsActivity from the MainActivity, then we want to navigate back to the
 * MainActivity when the user clicks the up button from the SettingsActivity.
 */

public class SettingsActivity extends AppCompatActivity {

    /* Tag for Log Messages */
    private static final String LOG_TAG = MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
        //TODO: CHECK
        Log.d(LOG_TAG, "Check-point 2");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        Log.d(LOG_TAG, "Check-point 3");

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        /*
         * Normally, calling setDisplayHomeAsUpEnabled(true) (we do so in onCreate here) as well as
         * declaring the parent activity in the AndroidManifest is all that is required to get the
         * up button working properly. However, in this case, we want to navigate to the previous
         * screen the user came from when the up button was clicked, rather than a single
         * designated Activity in the Manifest.
         *
         * We use the up button's ID (android.R.id.home) to listen for when the up button is
         * clicked and then call onBackPressed to navigate to the previous Activity when this
         * happens.
         */
        int id = item.getItemId();
        Log.d(LOG_TAG, "Check-point 4");

        if ( id == android.R.id.home) {
            onBackPressed();
            return true;
        }
        Log.d(LOG_TAG, "Check-point 5");

        return super.onOptionsItemSelected(item);
    }
}
