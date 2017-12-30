package com.lzy.chat;

import android.app.Application;

import com.alibaba.mobileim.YWAPI;
import com.alibaba.wxlib.util.SysUtil;

/**
 * Created by bullet on 2017/12/28.
 */

public  class MyApplication extends Application {

    private static MyApplication application;
    @Override
    public void onCreate() {
        super.onCreate();
        application = this;

        final String APP_KEY = "24747420";
        //必须首先执行这部分代码, 如果在":TCMSSevice"进程中，无需进行云旺（OpenIM）和app业务的初始化，以节省内存;
        SysUtil.setApplication(this);
        if (SysUtil.isTCMSServiceProcess(this)) {
            return;
        }
        //第一个参数是Application Context
        //这里的APP_KEY即应用创建时申请的APP_KEY，同时初始化必须是在主进程中
        if (SysUtil.isMainProcess()) {
            YWAPI.init(this, APP_KEY);
        }
    }


    public static MyApplication getInstance() {
        return application;
    }


}
