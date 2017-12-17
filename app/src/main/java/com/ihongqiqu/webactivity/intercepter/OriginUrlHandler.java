package com.ihongqiqu.webactivity.intercepter;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.support.annotation.NonNull;

/**
 * 处理通用的 scheme
 * <p>
 * Created by zhenguo on 9/21/16.
 */

public class OriginUrlHandler extends UrlHandler {

    public OriginUrlHandler(Activity context) {
        super(context);
    }

    @Override
    public String handlerUrl(@NonNull String url) {
        if (url.toLowerCase().startsWith("http")) {
            return super.handlerUrl(url);
        } else {
            // Otherwise allow the OS to handle things like tel, mailto, etc.
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
            mContext.startActivity(intent);
            return null;
        }
    }

}
