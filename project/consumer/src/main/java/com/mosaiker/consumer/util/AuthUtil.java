package com.mosaiker.consumer.util;

import com.alibaba.fastjson.JSONObject;

public class AuthUtil {

    public static JSONObject constructJsonOfAuthentication(String token, String role) {
        JSONObject json = new JSONObject();
        json.put("token", token);
        json.put("role", role);
        return json;
    }

    public static JSONObject constructJsonOfAuthFail() {
        JSONObject json = new JSONObject();
        json.put("message", "authentication failed");
        return json;
    }

    public static JSONObject attachTokenToUser(String token, JSONObject user) {
        JSONObject json = user;
        json.put("token", token);
        return json;
    }

}
