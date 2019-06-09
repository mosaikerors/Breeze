package com.mosaiker.consumer.util;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

public class HeanUtil {

    public static JSONObject constructJsonOfHeanList(JSONArray heanList) {
        JSONObject json = new JSONObject();
        json.put("heans", heanList);
        return json;
    }

}
