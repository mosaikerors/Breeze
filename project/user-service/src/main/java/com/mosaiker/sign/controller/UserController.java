package com.mosaiker.sign.controller;

import com.alibaba.fastjson.JSONObject;
import com.mosaiker.sign.entity.User;
import com.mosaiker.sign.service.UserService;
import com.mosaiker.sign.utils.UserUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/*
* 用户相关的api
* */
@RestController
@RequestMapping(value = "/api/user")
public class UserController {

    @Autowired
    private UserService userService;

    /*
    * 登录
    * 输入：phone（Long）
    * 返回：用户名username，状态status
    * */
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public JSONObject login(@RequestBody JSONObject params) {
        User user = userService.findUserByPhone(params.getLong("phone"));
        if (user == null || user.getStatus() == 0)
            return UserUtil.constructJsonOfWrong("nonexistent or unactivated user");

        if (!user.getPassword().equals(params.getString("password")))
            return UserUtil.constructJsonOfWrong("wrong password");

        if (user.getStatus() == -1)
            return UserUtil.constructJsonOfWrong("The user has been banned.");
        return UserUtil.constructJsonOfSuccessfulLogin(user.getUsername(), user.getStatus());
    }

    /*
     * 认证
     * 输入：phone（Long），password（String）
     * 返回：认证信息（String）
     * */
    @RequestMapping(value = "/authenticate", method = RequestMethod.POST)
    public JSONObject authenticate(@RequestBody JSONObject request){
        User user = userService.findByPhoneAndPassword(
                request.getLong("phone"), request.getString("password"));
        if (user == null)
            return UserUtil.constructJsonOfWrong("authentication fail");
        return UserUtil.constructJsonOfAuthSuccessful(user.getStatus());
    }

}
