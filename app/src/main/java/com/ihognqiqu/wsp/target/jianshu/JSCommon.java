package com.ihognqiqu.wsp.target.jianshu;

import android.support.annotation.Nullable;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by zhenguo on 12/16/17.
 */
public class JSCommon {

    private static Map<String, String> headers;



    public static Map<String, String> getHeaders(@Nullable String keyword, int page) {
        if (headers == null) {
            headers = new HashMap<>();
            headers.put("X-CSRF-Token", "8+MpE1W6CbZyqKeWOFUtDKwxMF0ytlLcNgAK7mDgiv35XQedmb7uyJJOJf1/3rpcDGaUpQ8PoIOfddBEXGru1Q==");
            headers.put("X-Requested-With", "XMLHttpRequest");
            headers.put("Cookie", JSConstants.JSCookies);
            if (keyword == null) {
                headers.put("Referer", String.format(JSConstants.JSSearchURL, keyword, page));
            }
            headers.put("User-Agent", "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_12_0) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/53.0.2785.143 Safari/537.36");
            headers.put("Accept", "application/json, text/javascript, */*; q=0.01");
            headers.put("Content-Type", "application/x-www-form-urlencoded; charset=UTF-8");
        }
        return headers;
    }

}
