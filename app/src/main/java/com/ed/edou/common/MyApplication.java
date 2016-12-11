package com.ed.edou.common;

import android.app.Application;
import android.content.Context;

/**
 * Created by xmg on 2016/12/6.
 */

public class MyApplication extends Application {

    private static Context context;

    public static Context getContext(){
        return context;
    }
    @Override
    public void onCreate() {
        super.onCreate();
        context = getApplicationContext();
    }
}
