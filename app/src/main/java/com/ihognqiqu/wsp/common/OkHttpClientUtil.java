package com.ihognqiqu.wsp.common;

import okhttp3.OkHttpClient;

/**
 * Created by zhenguo on 12/16/17.
 */
public class OkHttpClientUtil {

    private static OkHttpClient client;

    public static OkHttpClient getClient() {
        if (client == null) {
            client = new OkHttpClient.Builder()
                    .addInterceptor(new LoggingInterceptor())
                    .build();
        }
        return client;
    }

}
