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
    UserService userService;

    @Autowired
    AuthService authService;

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ResponseEntity<JSONObject> login(@RequestBody JSONObject params) {
        JSONObject response = AuthUtil.attachTokenToUser(
                authService.getToken(params).getString("token"), userService.login(params));
        return new ResponseEntity<JSONObject>(response, HttpStatus.OK);
    }

    @RequestMapping(value = "/signup", method = RequestMethod.POST)
    public ResponseEntity<JSONObject> signup(@RequestBody JSONObject params) {
        return new ResponseEntity<JSONObject>(userService.signup(params), HttpStatus.OK);
    }

    @RequestMapping(value = "/activate", method = RequestMethod.GET)
    public ResponseEntity<JSONObject> activate(@RequestParam String code) {
        return new ResponseEntity<JSONObject>(userService.activate(code), HttpStatus.OK);
    }

}
