package com.mosaiker.consumer.controller;

import com.alibaba.fastjson.JSONObject;
import com.mosaiker.consumer.service.AuthService;
import com.mosaiker.consumer.service.UserService;
import com.mosaiker.consumer.util.AuthUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/user")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private AuthService authService;

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ResponseEntity<JSONObject> login(@RequestBody JSONObject params) {
        JSONObject response = AuthUtil.attachTokenToUser(
                authService.getToken(params).getString("token"), userService.login(params));
        return new ResponseEntity<JSONObject>(response, HttpStatus.OK);
    }

}
