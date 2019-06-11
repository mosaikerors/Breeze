package com.mosaiker.consumer.hystric;

import com.alibaba.fastjson.JSONObject;
import com.mosaiker.consumer.service.AuthService;
import org.springframework.stereotype.Component;

@Component
public class AuthHystric implements AuthService {

    private static final String hint = "Oops! Something wrong occured.";

    @Override
    public JSONObject getToken(JSONObject request) {
        JSONObject json = new JSONObject();
        json.put("error", hint);
        return json;
    }

    @Override
    public boolean verifyToken(JSONObject request) {
        return false;
    }

}
