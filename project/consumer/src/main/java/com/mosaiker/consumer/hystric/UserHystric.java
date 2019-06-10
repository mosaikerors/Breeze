package com.mosaiker.consumer.hystric;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.mosaiker.consumer.service.HeanService;
import com.mosaiker.consumer.service.UserService;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

@Component
public class UserHystric implements UserService {

    private static final String hint = "Oops! Something wrong occured.";

    @Override
    public JSONObject login(@RequestBody JSONObject params) {
        JSONObject json = new JSONObject();
        json.put("error", hint);
        return json;
    }

    @Override
    public JSONObject signup(@RequestBody JSONObject params) {
        JSONObject json = new JSONObject();
        json.put("error", hint);
        return json;
    }

    @Override
    public JSONObject activate(@RequestParam String code) {
        JSONObject json = new JSONObject();
        json.put("error", hint);
        return json;
    }

}
