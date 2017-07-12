package com.graphicalinfo.fim.ui.fragments;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.CheckBoxPreference;
import android.preference.Preference;
import android.preference.PreferenceFragment;
import android.preference.PreferenceManager;
import android.preference.SwitchPreference;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.graphicalinfo.fim.R;
import com.graphicalinfo.fim.ui.activities.AboutActivity;
import com.graphicalinfo.fim.ui.activities.LicenseActivity;
import com.graphicalinfo.fim.ui.views.MainContract;

/**
 * Created by ayoob on 05/07/17.
 */

public class SettingFragment  extends PreferenceFragment {


    private SwitchPreference imagePref;
    private CheckBoxPreference darkPref;


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = super.onCreateView(inflater, container, savedInstanceState);
        if (view != null) {
            view.setBackgroundColor(getResources().getColor(R.color.background_material_light));
        }

        return view;
    }
    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        addPreferencesFromResource(R.xml.preference);

        final SharedPreferences.Editor my_prefrence = PreferenceManager.getDefaultSharedPreferences(getActivity()).edit();

        imagePref = (SwitchPreference) findPreference("imagequality");
        imagePref.setOnPreferenceChangeListener(new Preference.OnPreferenceChangeListener() {
            @Override
            public boolean onPreferenceChange(Preference preference, Object o) {
                String quality;

                SwitchPreference switchPreference = (SwitchPreference) preference;

                if (!switchPreference.isChecked()) {
                    quality = "w1000";
                } else {
                    quality = "w780";
                }


                my_prefrence.putString("image_quality", quality);
                my_prefrence.apply();

                return true;
            }
        });


        darkPref = (CheckBoxPreference) findPreference("dark");
        darkPref.setOnPreferenceChangeListener(new Preference.OnPreferenceChangeListener() {
            @Override
            public boolean onPreferenceChange(Preference preference, Object o) {

                recreateActivity();

                return true;
            }
        });

        Preference liscence = (Preference) findPreference("license");
        liscence.setOnPreferenceClickListener(new Preference.OnPreferenceClickListener() {
            @Override
            public boolean onPreferenceClick(Preference preference) {
                startActivity(new Intent(getActivity(), LicenseActivity.class));
                return true;
            }
        });


        Preference share = (Preference) findPreference("Share");
        share.setOnPreferenceClickListener(new Preference.OnPreferenceClickListener() {
            @Override
            public boolean onPreferenceClick(Preference preference) {

                String app_share_details = getResources().getString(R.string.app_share_link);
                if (!(app_share_details.equals(null))) {
                    Intent myIntent = new Intent(Intent.ACTION_SEND);
                    myIntent.setType("text/plain");
                    myIntent.putExtra(Intent.EXTRA_TEXT, "Check out this Application .\n" + "*Dhofar Pharmacy Forum*\n" + app_share_details);
                    startActivity(Intent.createChooser(myIntent, "Share with"));
                }
                return true;
            }
        });


        Preference about = (Preference) findPreference("About");
        about.setOnPreferenceClickListener(new Preference.OnPreferenceClickListener() {
            @Override
            public boolean onPreferenceClick(Preference preference) {
               startActivity(new Intent(getActivity(), AboutActivity.class));
                return true;
            }
        });

    }

    private void recreateActivity() {
        getActivity().recreate();
    }
}
