package com.mosaiker.consumer.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.mosaiker.consumer.service.AuthService;
import com.mosaiker.consumer.service.HeanService;
import com.mosaiker.consumer.util.AuthUtil;
import com.mosaiker.consumer.util.HeanUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/hean/search")
public class HeanController {

    @Autowired
    HeanService heanService;

    @Autowired
    AuthService authService;

    private static final String ADMIN = "ADMIN";

    @RequestMapping(value = "/byTime", method = RequestMethod.POST)
    public ResponseEntity<JSONObject> searchByTime(@RequestHeader(name = "Authentication") String token,
                                                   @RequestBody JSONObject request) {
        if (!authService.verifyToken(AuthUtil.constructJsonOfAuthentication(token, ADMIN)))
            return new ResponseEntity<JSONObject>(AuthUtil.constructJsonOfAuthFail(), HttpStatus.UNAUTHORIZED);
        JSONArray heanList = heanService.searchByTime(request);
        return new ResponseEntity<JSONObject>(HeanUtil.constructJsonOfHeanList(heanList), HttpStatus.OK);
    }

    @RequestMapping(value = "/byUser", method = RequestMethod.POST)
    public ResponseEntity<JSONObject> searchByUser(@RequestHeader(name = "Authentication") String token,
                                                   @RequestBody JSONObject request) {
        if (!authService.verifyToken(AuthUtil.constructJsonOfAuthentication(token, ADMIN)))
            return new ResponseEntity<JSONObject>(AuthUtil.constructJsonOfAuthFail(), HttpStatus.UNAUTHORIZED);
        JSONArray heanList = heanService.searchByUser(request);
        return new ResponseEntity<JSONObject>(HeanUtil.constructJsonOfHeanList(heanList), HttpStatus.OK);
    }

    @RequestMapping(value = "/byPosition", method = RequestMethod.POST)
    public ResponseEntity<JSONObject> searchByPosition(@RequestHeader(name = "Authentication") String token,
                                                       @RequestBody JSONObject request) {
        if (!authService.verifyToken(AuthUtil.constructJsonOfAuthentication(token, ADMIN)))
            return new ResponseEntity<JSONObject>(AuthUtil.constructJsonOfAuthFail(), HttpStatus.UNAUTHORIZED);
        JSONArray heanList = heanService.searchByPosition(request);
        return new ResponseEntity<JSONObject>(HeanUtil.constructJsonOfHeanList(heanList), HttpStatus.OK);
    }

}
