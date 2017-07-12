package com.graphicalinfo.fim.ui.activities;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.webkit.WebView;

import com.graphicalinfo.fim.R;
import com.graphicalinfo.fim.ui.BaseActivity;

/**
 * Created by ayoob on 12/07/17.
 */

public class LicenseActivity extends AppCompatActivity {

    private static final String LICENSE_URL = "file:///android_asset/license.html";
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.license_activity);
        WebView webView = (WebView) findViewById(R.id.webview);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ActionBar bar = getSupportActionBar();
        if (bar != null) {
            bar.setDisplayHomeAsUpEnabled(true);
            bar.setDisplayShowHomeEnabled(true);
            bar.setDisplayShowTitleEnabled(false);
            bar.setHomeAsUpIndicator(getResources().getDrawable(R.drawable.ic_close_black_24dp));
        }
        toolbar.setTitle("License");
        toolbar.setTitleTextColor(getResources().getColor(R.color.amber_700));
        webView.saveState(savedInstanceState);
        webView.loadUrl(LICENSE_URL);

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if (item.getItemId() == android.R.id.home) {
            finish();
        }

        return super.onOptionsItemSelected(item);
    }
}
