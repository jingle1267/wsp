package com.ihognqiqu.wsp.common;

/**
 * Created by zhenguo on 12/17/17.
 */

import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class CopyOfStringUtil {

    public static String map2str(Map<String, ?> map) {
        if (map == null) {
            return null;
        }
        JSONArray arr = new JSONArray();
        for (String k : map.keySet()) {
            Object v = map.get(k);
            JSONObject item = new JSONObject();
            try {
                item.put("k", k);
                item.put("v", v);
                arr.put(item);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return arr.toString();
    }

    public static Map<String, String> str2map(String mapText) {
        HashMap<String, String> map = new HashMap<>();
        try {
            JSONArray arr = new JSONArray(mapText);
            for (int i = 0; i < arr.length(); i++) {
                JSONObject item = arr.getJSONObject(i);
                String k = item.getString("k");
                String v = item.getString("v");
                map.put(k, v);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return map;
    }

}
