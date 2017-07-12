package com.graphicalinfo.fim.widgets;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;

import com.graphicalinfo.fim.R;
import com.graphicalinfo.fim.utils.FontCache;

/**
 * Created by ayoob on 05/07/17.
 */

public class biscket extends android.support.v7.widget.AppCompatTextView {

    public biscket(Context context) {
        super(context);
        init(context);
    }

    public biscket(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public biscket(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    private void init(Context context) {
        setTypeface(FontCache.getTypeface(context,"Josefin_Slab/JosefinSlab-Bold.ttf"));
        setShadowLayer(4,2,4,getResources().getColor(R.color.colorAccent));
    }
}
