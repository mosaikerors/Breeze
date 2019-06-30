package com.mosaiker.sign.utils;

import com.alibaba.fastjson.JSONObject;
import com.mosaiker.sign.entity.User;

public class UserUtil {

    public static JSONObject constructJsonOfWrong(String errorInfo) {
        JSONObject json = new JSONObject();
        json.put("message", errorInfo);
        return json;
    }

    public static JSONObject constructJsonOfSuccessfulLogin(String username, int role) {
        JSONObject json = new JSONObject();
        json.put("message", "ok");
        json.put("username", username);
        json.put("role", role);
        return json;
    }

    public static JSONObject constructJsonOfMessage(String message) {
        JSONObject json = new JSONObject();
        json.put("message", message);
        return json;
    }

    public static User updateUserWith(User user, Long phone, String name, String password, String code) {
        if (user == null)
            user = new User();
        user.setPhone(phone);
        user.setUsername(name);
        user.setPassword(password);
        return user;
    }

    public static JSONObject constructJsonOfAuthSuccessful(int status) {
        JSONObject json = new JSONObject();
        json.put("message", "authentication successful");
        String role = "";
        switch (status) {
            case 1:
                role = "USER"; break;
            case 2:
                role = "ADMIN"; break;
            case 3:
                role = "THIRD-PARTY"; break;
        }
        json.put("role", role);
        return json;
    }

}
