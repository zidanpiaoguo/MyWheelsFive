package com.lzy.mywheelsfive;

import android.app.Application;

import com.mob.MobSDK;

/**
 * Created by bullet on 2017/12/19.
 */

public class MyAppliaction extends Application {

    private static final String APP_KEY = "23269b7f52cec";
    @Override
    public void onCreate() {
        super.onCreate();
        MobSDK.init(getApplicationContext(),"23269b7f52cec","6c8e7914b04a270a72d1e8bc6756315d");
    }

}
