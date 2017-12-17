package com.ihognqiqu.wsp.target.jianshu;

import android.support.annotation.Nullable;
import android.util.Log;
import com.google.gson.Gson;
import com.ihognqiqu.wsp.BuildConfig;
import com.ihognqiqu.wsp.common.OkHttpClientUtil;
import com.ihognqiqu.wsp.target.jianshu.entity.JSArticleEntity;
import com.ihognqiqu.wsp.target.jianshu.entity.JSResultEntity;
import java.io.IOException;
import java.util.List;
import okhttp3.FormBody;
import okhttp3.Headers;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.ResponseBody;

/**
 * Created by zhenguo on 12/16/17.
 */
public class JSSearch {

    @Nullable
    public List<JSArticleEntity> getArticles(String keyword, int page) {
        RequestBody requestBodyPost = new FormBody.Builder()
                .build();

        Request request = new Request.Builder()
                .url(String.format(JSConstants.JSSearchURL, keyword, page))
                .headers(Headers.of(JSCommon.getHeaders(keyword, page)))
                .post(requestBodyPost)
                .build();


        try {
            Response response = OkHttpClientUtil.getClient().newCall(request).execute();
            ResponseBody body = response.body();
            String result = body.string();

            if (BuildConfig.DEBUG) Log.d("JSSearch", "result: " + result);

            JSResultEntity jsResultEntity = new Gson().fromJson(result, JSResultEntity.class);
            if (jsResultEntity != null && jsResultEntity.getEntries() != null) {
                return jsResultEntity.getEntries();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }

}
