package com.graphicalinfo.fim;

import android.app.Application;
import android.content.Context;
import android.graphics.Typeface;

import com.graphicalinfo.fim.utils.FontCache;
import com.graphicalinfo.fim.utils.LocaleUtil;

import java.lang.reflect.Field;

/**
 * Created by ayoob on 05/07/17.
 */

public class App extends Application {

    private static App instance;





    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
        LocaleUtil.initLocale(this);
        initFonts();
    }

    private void initFonts() {
        try {
            final Typeface JosefinSlab = FontCache.getTypeface(this,"fonts/Josefin_Slab/JosefinSlab-Bold.ttf");

            final Field defaultFontTypefaceField = Typeface.class.getDeclaredField("SERIF");
            defaultFontTypefaceField.setAccessible(true);
            defaultFontTypefaceField.set(null, JosefinSlab);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


//     public static App getInstance() {
//         return instance;
//     }

//     public static Context getContext() {
//         return instance.getApplicationContext();
//     }
}
