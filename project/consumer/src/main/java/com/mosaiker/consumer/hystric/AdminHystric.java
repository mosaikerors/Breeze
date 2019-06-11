package com.mosaiker.consumer.hystric;

import com.alibaba.fastjson.JSONObject;
import com.mosaiker.consumer.service.AdminService;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Component
public class AdminHystric implements AdminService {

    private static final String hint = "Oops! Something wrong occured.";

    @RequestMapping(value = "/userlist", method = RequestMethod.GET)
    public JSONObject findAllUser() {
        JSONObject json = new JSONObject();
        json.put("error", hint);
        return json;
    }

    @RequestMapping(value = "/totalNum", method = RequestMethod.GET)
    public JSONObject getTotal() {
        JSONObject json = new JSONObject();
        json.put("error", hint);
        return json;
    }

    @RequestMapping(value = "/userinfo", method = RequestMethod.GET)
    public JSONObject showDetail(@RequestParam(name = "id") String u_id) {
        JSONObject json = new JSONObject();
        json.put("error", hint);
        return json;
    }

    @RequestMapping(value = "/toggle", method = RequestMethod.PUT)
    public JSONObject changeStatus(@RequestBody JSONObject param) {
        JSONObject json = new JSONObject();
        json.put("error", hint);
        return json;
    }

    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    public JSONObject update(@RequestBody JSONObject param) {
        JSONObject json = new JSONObject();
        json.put("error", hint);
        return json;
    }

}
