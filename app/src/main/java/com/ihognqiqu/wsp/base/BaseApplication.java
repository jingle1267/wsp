package com.ihognqiqu.wsp.base;

import android.app.Application;

/**
 * Created by zhenguo on 12/17/17.
 */
public class BaseApplication extends Application {

    public static BaseApplication app;

    @Override
    public void onCreate() {
        super.onCreate();
        app = this;
    }
}
