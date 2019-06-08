package com.mosaiker.consumer.util;

import com.alibaba.fastjson.JSONObject;

public class UserUtil {

    public static JSONObject constructJsonOfAuthentication(String token, String role) {
        JSONObject json = new JSONObject();
        json.put("token", token);
        json.put("role", role);
        return json;
    }

    public static JSONObject constructJsonOfFail() {
        JSONObject json = new JSONObject();
        json.put("message", "authentication failed");
        return json;
    }

}
