package com.ihongqiqu.webactivity.intercepter;

import android.app.Activity;
import android.support.annotation.CallSuper;
import android.support.annotation.NonNull;

/**
 * URL 拦截基类
 * <p>
 * Created by zhenguo on 9/21/16.
 */

public abstract class UrlHandler {

    protected Activity mContext;
    private UrlHandler nextUrlHandler = null;

    public UrlHandler(Activity context) {
        mContext = context;
    }

    public void setContext(Activity context) {
        mContext = context;
    }

    public UrlHandler getNextUrlHandler() {
        return nextUrlHandler;
    }

    public void setNextUrlHandler(UrlHandler nextUrlHandler) {
        this.nextUrlHandler = nextUrlHandler;
    }

    @CallSuper
    public String handlerUrl(@NonNull String url) {
        if (getNextUrlHandler() != null) {
            return getNextUrlHandler().handlerUrl(url);
        }
        return url;
    }
}
