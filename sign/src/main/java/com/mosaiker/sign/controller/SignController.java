package com.mosaiker.sign.controller;

import com.alibaba.fastjson.JSONObject;
import com.mosaiker.sign.entity.User;
import com.mosaiker.sign.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/user")
public class SignController {
    @Autowired
    private UserService userService;

    @PostMapping(value = "/login")
    public JSONObject login(@RequestBody JSONObject params) {
        Long phone = params.getLong("phone");
        String password = params.getString("password");
        System.out.println(phone);
        System.out.println(password);
        User user = userService.findUserByPhone(phone);
        JSONObject ret = new JSONObject();
        if (user == null || user.getStatus()==0) {
            ret.put("msg", "该用户不存在或未激活");
            return ret;
        }
        if (user.getPassword().equals(password)) {
            if (user.getStatus() == -1) {
                ret.put("msg", "该用户已被禁用");
                return ret;
            } else {
                ret.put("msg", "ok");
                ret.put("username", user.getUsername());
                ret.put("role", user.getStatus());
                return ret;
            }
        } else {
            ret.put("msg", "密码错误");
            return ret;
        }
    }

    @PostMapping(value = "/signup")
    public JSONObject signup(@RequestBody JSONObject params) {
        Long phone = params.getLong("phone");
        String username = params.getString("username");
        String password = params.getString("password");
        JSONObject ret = new JSONObject();
        String result = userService.addUser(username, phone, password);
        ret.put("msg", result);
        return ret;
    }

    @RequestMapping(value = "/activate", method = RequestMethod.GET)
    public JSONObject activate(String code) {
        String result = userService.activate(code);
        JSONObject ret = new JSONObject();
        ret.put("msg", result);
        return ret;
    }
}
