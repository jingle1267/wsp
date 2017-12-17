package com.ihongqiqu.webactivity;

import android.annotation.TargetApi;
import android.app.Activity;
import android.graphics.Bitmap;
import android.os.Build;
import android.text.TextUtils;
import android.util.Log;
import android.webkit.CookieManager;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.ihognqiqu.wsp.target.jianshu.JSCommon;
import com.ihongqiqu.webactivity.intercepter.FirstUrlHandler;
import com.ihongqiqu.webactivity.intercepter.OriginUrlHandler;
import java.util.Map;

/**
 * MyWebViewClient
 * <p>
 * Created by zhenguo on 9/20/16.
 */
public class MyWebViewClient extends WebViewClient {

    private Activity from;

    public MyWebViewClient(Activity from) {
        this.from = from;
    }

    @Override
    public void onPageStarted(WebView view, String url, Bitmap favicon) {
        super.onPageStarted(view, url, favicon);
    }

    @Override
    public void onPageFinished(WebView view, String url) {

        CookieManager cookieManager = CookieManager.getInstance();
        String cookieStr = cookieManager.getCookie(url);

        Log.d("MyWebViewClient", "Cookie : " + cookieStr);

        JSCommon.getHeaders(null, 1).put("Cookie", cookieStr);

        super.onPageFinished(view, url);
    }

    @Override
    public void onReceivedError(WebView view, WebResourceRequest request, WebResourceError error) {
        // 自定义404页面可以在这里设置
        super.onReceivedError(view, request, error);
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    @Override
    public WebResourceResponse shouldInterceptRequest(WebView view, WebResourceRequest request) {
        Map<String, String> header = request.getRequestHeaders();
        for (String k : header.keySet()) {
            String v = header.get(k);
            Log.d("MyWebViewClient", "k v : " + k + " " + v);
            Map<String, String> headers = JSCommon.getHeaders(null, 1);
            headers.put(k, v);
        }

        // 如果需要对某些网页进行处理可以在这里处理
        return super.shouldInterceptRequest(view, request);
    }

    @Override
    public boolean shouldOverrideUrlLoading(WebView view, String url) {
        FirstUrlHandler firstUrlHandler = new FirstUrlHandler(from);
        OriginUrlHandler originUrlHandler = new OriginUrlHandler(from);
        firstUrlHandler.setNextUrlHandler(originUrlHandler);
        // 此处可以设置自己的 UrlHandler 处理
        url = firstUrlHandler.handlerUrl(url);
        if (TextUtils.isEmpty(url)) {
            return true;
        } else {
            view.loadUrl(url);
            return false;
        }
    }
}
