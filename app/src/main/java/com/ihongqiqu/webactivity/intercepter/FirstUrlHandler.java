package com.ihongqiqu.webactivity.intercepter;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.widget.Toast;
import com.ihognqiqu.wsp.target.jianshu.JSConstants;

/**
 * 拦截需要处理的url
 * <p>
 * Created by zhenguo on 9/21/16.
 */

public class FirstUrlHandler extends UrlHandler {

    public FirstUrlHandler(Activity context) {
        super(context);
    }

    @Override
    public String handlerUrl(@NonNull String url) {
        if (url.contains("http://ihongqiqu.com/archives/")) {
            Toast.makeText(mContext, url, Toast.LENGTH_SHORT).show();
            return null;
        } else if ("http://www.jianshu.com/".equalsIgnoreCase(url)) {
            return JSConstants.JSDemoURL;
        }
        return super.handlerUrl(url);
    }
}
