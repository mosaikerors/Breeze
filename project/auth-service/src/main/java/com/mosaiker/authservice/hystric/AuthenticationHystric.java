package com.mosaiker.authservice.hystric;

import com.alibaba.fastjson.JSONObject;
import com.mosaiker.authservice.service.AuthenticationService;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;

@Component
public class AuthenticationHystric implements AuthenticationService {

    private static final String hint = "Oops! Something wrong occured.";

    @Override
    public JSONObject authenticate(@RequestBody JSONObject request) {
        JSONObject json = new JSONObject();
        json.put("error", hint);
        return json;
    }

}