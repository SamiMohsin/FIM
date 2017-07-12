package com.graphicalinfo.fim.widgets;

import android.content.Context;
import android.graphics.drawable.AnimationDrawable;
import android.os.Build;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;

import com.graphicalinfo.fim.R;

/**
 * Created by ayoob on 05/07/17.
 */

public class NavB extends FrameLayout {

    AnimationDrawable anim;

    public NavB(Context context) {
        super(context);
        init(context);
    }

    public NavB(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public NavB(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    private void init(Context context) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
            setBackground(getResources().getDrawable(R.drawable.nav_logo));
            anim = (AnimationDrawable) getBackground();
            anim.setEnterFadeDuration(5000);
            anim.setExitFadeDuration(5000);
            anim.start();
        }

    }


}
