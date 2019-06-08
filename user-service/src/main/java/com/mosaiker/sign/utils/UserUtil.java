package com.mosaiker.sign.utils;

import com.alibaba.fastjson.JSONObject;
import com.mosaiker.sign.entity.Admin;
import com.mosaiker.sign.entity.Player;
import com.mosaiker.sign.entity.Thirdparty;
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
        user.setCode(code);
        return user;
    }

    public static Player createPlayerFromUser(User user) {
        Player player = new Player();
        player.setuId(user.getuId());
        return player;
    }

    public static Admin createAdminFromUser(User user) {
        Admin admin = new Admin();
        admin.setuId(user.getuId());
        return admin;
    }

    public static Thirdparty createThirdPartyFromUser(User user) {
        Thirdparty thirdparty = new Thirdparty();
        thirdparty.setuId(user.getuId());
        thirdparty.setCompany(user.getUsername());
        return thirdparty;
    }

    public static JSONObject constructJsonOfAuthSuccessful(int status) {
        JSONObject json = new JSONObject();
        json.put("message", "authentication successful");
        String role = "";
        switch (status) {
            case 1:
                role = "PLAYER"; break;
            case 2:
                role = "ADMIN"; break;
            case 3:
                role = "THIRD-PARTY"; break;
        }
        json.put("role", role);
        return json;
    }

}
