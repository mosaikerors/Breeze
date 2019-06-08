package com.mosaiker.consumer.util;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

public class HeanUtil {

    public static JSONObject constructJsonOfHeanList(JSONArray heanList) {
        JSONObject json = new JSONObject();
        json.put("heans", heanList);
        return json;
    }

    public static JSONObject constructJsonOfSearchByTime(String beginTime, String endTime) {
        JSONObject json = new JSONObject();
        json.put("beginTime", beginTime);
        json.put("endTime", endTime);
        return json;
    }

    public static JSONObject constructJsonOfSearchByUser(Integer userId) {
        JSONObject json = new JSONObject();
        json.put("userId", userId);
        return json;
    }

    public static JSONObject constructJsonOfSearchByPosition(String position, float range) {
        JSONObject json = new JSONObject();
        json.put("position", position);
        json.put("range", range);
        return json;
    }

}
