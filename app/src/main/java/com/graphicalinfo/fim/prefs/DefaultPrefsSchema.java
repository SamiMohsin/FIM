package com.graphicalinfo.fim.prefs;


import com.rejasupotaro.android.kvs.annotations.Key;
import com.rejasupotaro.android.kvs.annotations.Table;


/**
 * Created by ayoob on 07/07/17.
 */



@Table(name = "com.graphicalinfo.fim_preferences")
public interface DefaultPrefsSchema {
    @Key(name = "current_language_id")
    String languageId = "";
    @Key(name = "notification_setting")
    boolean notificationFlag = true;
    @Key(name = "heads_up_setting")
    boolean headsUpFlag = true;
    @Key(name = "show_local_time")
    boolean showLocalTimeFlag = false;
}
