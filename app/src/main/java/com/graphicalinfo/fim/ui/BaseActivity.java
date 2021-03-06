package com.graphicalinfo.fim.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

/**
 * Created by ayoob on 05/07/17.
 */

public abstract class BaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().addFlags(View.SYSTEM_UI_LAYOUT_FLAGS|
                View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN|
                View.HAPTIC_FEEDBACK_ENABLED);
        setTitle("");
    }
}
