package com.mosaiker.consumer.controller;

import com.alibaba.fastjson.JSONObject;
import com.mosaiker.consumer.service.AuthService;
import com.mosaiker.consumer.service.AdminService;
import com.mosaiker.consumer.util.AuthUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/admin")
public class AdminController {

    @Autowired
    AdminService adminService;

    @Autowired
    AuthService authService;

    private static final String ADMIN = "ADMIN";
    private static final String USER = "USER";

    @RequestMapping(value = "/showAll", method = RequestMethod.GET)
    public ResponseEntity<JSONObject> findByPage(@RequestHeader(name = "Authentication") String token) {
        if (!authService.verifyToken(AuthUtil.constructJsonOfAuthentication(token, ADMIN)))
            return new ResponseEntity<JSONObject>(AuthUtil.constructJsonOfAuthFail(), HttpStatus.UNAUTHORIZED);
        JSONObject result = adminService.findAllUser();
        return new ResponseEntity<JSONObject>(result, HttpStatus.OK);
    }

    @RequestMapping(value = "/totalNum", method = RequestMethod.GET)
    public ResponseEntity<JSONObject> getTotal(@RequestHeader(name = "Authentication") String token) {
        if (!authService.verifyToken(AuthUtil.constructJsonOfAuthentication(token, ADMIN)))
            return new ResponseEntity<JSONObject>(AuthUtil.constructJsonOfAuthFail(), HttpStatus.UNAUTHORIZED);
        JSONObject result = adminService.getTotal();
        return new ResponseEntity<JSONObject>(result, HttpStatus.OK);
    }

    @RequestMapping(value = "/show", method = RequestMethod.GET)
    public ResponseEntity<JSONObject> showDetail(@RequestHeader(name = "Authentication") String token,
                                                 @RequestParam(name = "id") String id) {
        if (!authService.verifyToken(AuthUtil.constructJsonOfAuthentication(token, USER)))
            return new ResponseEntity<JSONObject>(AuthUtil.constructJsonOfAuthFail(), HttpStatus.UNAUTHORIZED);
        JSONObject result = adminService.showDetail(id);
        return new ResponseEntity<JSONObject>(result, HttpStatus.OK);
    }

    @RequestMapping(value = "/toggle", method = RequestMethod.PUT)
    public ResponseEntity<JSONObject> changeStatus(@RequestHeader(name = "Authentication") String token,
                                                   @RequestBody JSONObject param) {
        if (!authService.verifyToken(AuthUtil.constructJsonOfAuthentication(token, ADMIN)))
            return new ResponseEntity<JSONObject>(AuthUtil.constructJsonOfAuthFail(), HttpStatus.UNAUTHORIZED);
        JSONObject result = adminService.changeStatus(param);
        return new ResponseEntity<JSONObject>(result, HttpStatus.OK);
    }

    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    public ResponseEntity<JSONObject> update(@RequestHeader(name = "Authentication") String token,
                                             @RequestBody JSONObject param) {
        if (!authService.verifyToken(AuthUtil.constructJsonOfAuthentication(token, ADMIN)))
            return new ResponseEntity<JSONObject>(AuthUtil.constructJsonOfAuthFail(), HttpStatus.UNAUTHORIZED);
        JSONObject result = adminService.update(param);
        return new ResponseEntity<JSONObject>(result, HttpStatus.OK);
    }
}