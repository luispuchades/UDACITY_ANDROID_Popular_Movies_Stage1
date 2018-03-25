package com.luispuchades.popularmovies;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.preference.ListPreference;
import android.support.v7.preference.Preference;
import android.support.v7.preference.PreferenceFragmentCompat;
import android.support.v7.preference.PreferenceScreen;

/**
 * The SettingsFragment serves as the display for all of the user's settings. In Popular Movies, the
 * user will be able to change their preferences for the most popular movies or the top rated
 * movies.
 */

public class SettingsFragment extends PreferenceFragmentCompat implements
        SharedPreferences.OnSharedPreferenceChangeListener {

    private Context context;

    private void setPreferenceSummary (Preference preference, Object value) {
        String stringValue = value.toString();

        if (preference instanceof ListPreference) {
            // For list preferences, look up the correct display value in
            // the preference's 'entries' list (since they have separate labels/values).
            ListPreference listPreference = (ListPreference) preference;
            int prefIndex = listPreference.findIndexOfValue(stringValue);

            if ( prefIndex >= 0) {
                preference.setSummary(listPreference.getEntries()[prefIndex]);
            }
        } else {
            // For other preferences, set the summary to the value's simple string representation.
            preference.setSummary(stringValue);
        }
    }

    //TODO: CHECK
/*    *//**
     * Binds the summary of the preferences to its actual value. If the value is changed, its
     * summary (text line below the preference title) is updated. Calling this method, the
     * summary is updated too. The display format depends on the type of preference.
     *//*
    private void bindPreferenceSummaryToValue (Preference preference) {
        //Set the listener to watch for value changes
        preference.setOnPreferenceChangeListener((Preference.OnPreferenceChangeListener) this);

        //Trigger the listener inmediately with the preference' current value
    }*/

    @Override
    public void onCreatePreferences(Bundle savedInstanceState, String rootKey) {
        //Add 'main' preferences, defined in the settings_main.xml
        addPreferencesFromResource(R.xml.settings_main);

        SharedPreferences sharedPreferences = getPreferenceScreen().getSharedPreferences();
        PreferenceScreen preferenceScreen = getPreferenceScreen();

        int count = preferenceScreen.getPreferenceCount();
        for ( int i = 0; i < count; i++) {
            Preference p = preferenceScreen.getPreference(i);
            String value = sharedPreferences.getString(p.getKey(), "");
            setPreferenceSummary(p, value);
        }
    }


    @Override
    public void onStop() {
        super.onStop();
        // unregister the preference change listener
        getPreferenceScreen().getSharedPreferences().
                unregisterOnSharedPreferenceChangeListener(this);
    }

    @Override
    public void onStart() {
        super.onStart();
        // register the preference change listener
        getPreferenceScreen().getSharedPreferences().
                registerOnSharedPreferenceChangeListener(this);
    }

    @Override
    public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String key) {

        Preference preference = findPreference(key);
        if (null != preference) {
            setPreferenceSummary(preference, sharedPreferences.getString(key, ""));
        }

        if ( key.equals(getString(R.string.settings_order_by_key))) {
            //Selection has changed. Update lists of movies entries accordingly
            //TODO: CHECK
            Intent intent = new Intent(getActivity(), MainActivity.class);
            getActivity().startActivity(intent);

        }

    }
}
