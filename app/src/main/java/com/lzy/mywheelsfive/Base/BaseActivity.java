package com.lzy.mywheelsfive.Base;

import android.app.Activity;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.Window;

/**
 * Created by bullet on 2017/12/19.
 */

public abstract class BaseActivity  extends Activity{
    private static final String TAG = "BaseActivity";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG, "onCreate: ");
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(setLayoutId());


        initView();
        initData();
        setClickEvent();


    }

    protected abstract int setLayoutId();


    protected abstract void initView();

    protected abstract void initData();

    protected abstract void setClickEvent();


    @Override
    protected void onResume() {
        /**
         * 设置为横屏
         */
        if(getRequestedOrientation()!= ActivityInfo.SCREEN_ORIENTATION_PORTRAIT){
            setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        }
        super.onResume();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

    }

}
