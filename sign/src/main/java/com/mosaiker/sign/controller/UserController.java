package com.mosaiker.sign.controller;

import com.alibaba.fastjson.JSONObject;
import com.mosaiker.sign.entity.User;
import com.mosaiker.sign.service.UserService;
import com.mosaiker.sign.utils.UserUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/user")
public class UserController {

    @Autowired
    private UserService userService;

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

    @RequestMapping(value = "/signup", method = RequestMethod.POST)
    public JSONObject signup(@RequestBody JSONObject params) {
        String result = userService.addUser(
                params.getString("username"), params.getLong("phone"), params.getString("password"));
        return UserUtil.constructJsonOfMessage(result);
    }

    @RequestMapping(value = "/activate", method = RequestMethod.GET)
    public JSONObject activate(@RequestParam String code) {
        return UserUtil.constructJsonOfMessage(userService.activate(code));
    }

    @RequestMapping(value = "/authenticate", method = RequestMethod.POST)
    public JSONObject authenticate(@RequestBody JSONObject request){
        User user = userService.findByPhoneAndPassword(
                request.getString("phone"), request.getString("password"));
        if (user == null)
            return UserUtil.constructJsonOfWrong("authentication fail");
        return UserUtil.constructJsonOfAuthSuccessful(user.getStatus());
    }

}
