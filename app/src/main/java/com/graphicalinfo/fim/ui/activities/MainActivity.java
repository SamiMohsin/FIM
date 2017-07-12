package com.graphicalinfo.fim.ui.activities;

import android.graphics.drawable.AnimationDrawable;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.TextView;

import com.graphicalinfo.fim.R;
import com.graphicalinfo.fim.ui.BaseActivity;
import com.graphicalinfo.fim.ui.fragments.CommitteeFragment;
import com.graphicalinfo.fim.ui.fragments.EventFragment;
import com.graphicalinfo.fim.ui.fragments.OverviewFragment;
import com.graphicalinfo.fim.ui.fragments.SettingFragment;
import com.graphicalinfo.fim.ui.presenter.MainPresenter;
import com.graphicalinfo.fim.ui.views.MainContract;

public class MainActivity extends BaseActivity
        implements NavigationView.OnNavigationItemSelectedListener, MainContract.View {
    AnimationDrawable anim;
    private MainContract.Presenter presenter;
    TextView logo;
    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        presenter = new MainPresenter();
        presenter.attachView(this);
        presenter.presenterMethod();
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);

        logo = (TextView) findViewById(R.id.logo);
        logo.setTextColor(getResources().getColor(R.color.amber_700));
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);




    }

    @Override
    protected void onStop() {
        super.onStop();
        if (anim != null && !anim.isRunning())
            anim.stop();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenter.onDestroy();
        if (anim != null && !anim.isRunning())
        anim.stop();
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }



    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        Fragment fragment = null;
        SettingFragment setting = null;
        int id = item.getItemId();

        if (id == R.id.nav_home) {
            fragment = new OverviewFragment();
        } else if (id == R.id.nav_events) {
            fragment = new EventFragment();

        } else if (id == R.id.nav_lectural) {
            fragment = new CommitteeFragment();
        }  else if (id == R.id.nav_manage) {
            getFragmentManager().beginTransaction().
                    replace(R.id.container,
                           new  SettingFragment()).commit();

        }
        if (fragment != null){


            FragmentTransaction manager = getSupportFragmentManager().beginTransaction();
            manager.replace(R.id.container, fragment)
                    .commit();
        }
        String TITLE = (String) item.getTitle();

        logo.setText(TITLE);
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void viewMethod() {

    }
}
