package com.mosaiker.consumer.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.mosaiker.consumer.service.HeanService;
import com.mosaiker.consumer.service.UserService;
import com.mosaiker.consumer.util.HeanUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/user")
public class UserController {

    @Autowired
    UserService userService;

    @RequestMapping(value = "/showByPage", method = RequestMethod.GET)
    public ResponseEntity<JSONObject> findByPage(@RequestParam int pageIndex, @RequestParam int pageSize) {
        JSONObject result = userService.findAllUser(pageIndex, pageSize);
        return new ResponseEntity<JSONObject>(result, HttpStatus.OK);
    }

    @RequestMapping(value = "/getTotal", method = RequestMethod.GET)
    public ResponseEntity<JSONObject> getTotal() {
        JSONObject result = userService.getTotal();
        return new ResponseEntity<JSONObject>(result, HttpStatus.OK);
    }

    @RequestMapping(value = "/showByPage", method = RequestMethod.POST)
    public ResponseEntity<JSONObject> showDetail(@RequestBody JSONObject param) {
        JSONObject result = userService.showDetail(param);
        return new ResponseEntity<JSONObject>(result, HttpStatus.OK);
    }

    @RequestMapping(value = "/showByPage", method = RequestMethod.PUT)
    public ResponseEntity<JSONObject> changeStatus(@RequestBody JSONObject param) {
        JSONObject result = userService.changeStatus(param);
        return new ResponseEntity<JSONObject>(result, HttpStatus.OK);
    }

    @RequestMapping(value = "/showByPage", method = RequestMethod.PUT)
    public ResponseEntity<JSONObject> update(@RequestBody JSONObject param) {
        JSONObject result = userService.update(param);
        return new ResponseEntity<JSONObject>(result, HttpStatus.OK);
    }
}