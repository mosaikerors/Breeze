package com.mosaiker.authservice.util;

import com.alibaba.fastjson.JSONObject;

public class TokenUtil {

    public static JSONObject constructJsonOfFail() {
        JSONObject json = new JSONObject();
        json.put("message", "authentication failed");
        return json;
    }

    public static JSONObject constructJsonOfSuccess(String token) {
        JSONObject json = new JSONObject();
        json.put("message", "authentication passed");
        json.put("token", token);
        return json;
    }

}
