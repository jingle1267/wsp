package com.ihognqiqu.wsp.target.jianshu;

import android.util.Log;
import com.google.gson.Gson;
import com.ihognqiqu.wsp.BuildConfig;
import com.ihognqiqu.wsp.common.OkHttpClientUtil;
import com.ihognqiqu.wsp.component.Comment;
import com.ihognqiqu.wsp.target.jianshu.entity.JSArticleEntity;
import com.ihognqiqu.wsp.target.jianshu.entity.JSCommentEntity;
import com.ihognqiqu.wsp.target.jianshu.entity.JSCommentResultEntity;
import java.io.IOException;
import java.util.Map;
import okhttp3.Headers;
import okhttp3.MediaType;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.ResponseBody;

/**
 * Created by zhenguo on 12/16/17.
 */
public class JSComment {

    public static final MediaType JSON = MediaType
            .parse("application/json; charset=utf-8");

    public boolean comment(JSArticleEntity jsArticleEntity, Comment comment) {

        jsArticleEntity.setContent(jsArticleEntity.getContent().replace("<em class='search-result-highlight'>", "").replace("</em>", ""));

        JSCommentEntity commentEntity = new JSCommentEntity();
        commentEntity.setContent(jsArticleEntity.getContent() + " - " + comment.getCommentContent());
        commentEntity.setParent_id(null);

        String commentStr = new Gson().toJson(commentEntity);

        RequestBody requestBodyPost = RequestBody.create(JSON, commentStr);

        Map<String, String> headers = JSCommon.getHeaders(jsArticleEntity.getTitle(), 1);

        headers.put("Referer", String.format(JSConstants.JSArticleURL, jsArticleEntity.getSlug()));
        headers.put("Accept", "application/json");
        headers.put("Content-Length", "" + commentStr.length());

        Request request = new Request.Builder()
                .url(String.format(JSConstants.JSCommentURL, jsArticleEntity.getId()))
                .headers(Headers.of(headers))
                .post(requestBodyPost)
                .build();

        try {
            Response response = OkHttpClientUtil.getClient().newCall(request).execute();
            ResponseBody body = response.body();
            String result = body.string();

            if (BuildConfig.DEBUG) Log.d("JSComment", "result: " + result);

            JSCommentResultEntity jsCommentResultEntity = new Gson().fromJson(result, JSCommentResultEntity.class);
            if (jsCommentResultEntity != null && jsCommentResultEntity.getId() != 0) {
                return true;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return false;
    }

}
