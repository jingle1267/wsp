package com.ihognqiqu.wsp.base;

import android.app.Application;
import android.widget.Toast;
import io.realm.Realm;

/**
 * Created by zhenguo on 12/17/17.
 */
public class BaseApplication extends Application {

    public static BaseApplication app;

    @Override
    public void onCreate() {
        super.onCreate();
        app = this;
        Realm.init(getApplicationContext());
    }

    public static void showToast(String msg) {
        Toast.makeText(BaseApplication.app, msg, Toast.LENGTH_SHORT).show();
    }

}
