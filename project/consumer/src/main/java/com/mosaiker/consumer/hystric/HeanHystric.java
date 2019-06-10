package com.mosaiker.consumer.hystric;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.mosaiker.consumer.service.HeanService;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;

@Component
public class HeanHystric implements HeanService {

    private static final String hint = "Oops! Something wrong occured.";

    @Override
    public JSONArray searchByTime(@RequestBody JSONObject request) {
        JSONArray json = new JSONArray();
        json.add(hint);
        return json;
    }

    @Override
    public JSONArray searchByUser(@RequestBody JSONObject request) {
        JSONArray json = new JSONArray();
        json.add(hint);
        return json;
    }

    @Override
    public JSONArray searchByPosition(@RequestBody JSONObject request) {
        JSONArray json = new JSONArray();
        json.add(hint);
        return json;
    }

}

