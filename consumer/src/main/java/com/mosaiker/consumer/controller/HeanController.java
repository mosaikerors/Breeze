package com.mosaiker.consumer.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.mosaiker.consumer.service.HeanService;
import com.mosaiker.consumer.util.HeanUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/hean/search")
public class HeanController {

    @Autowired
    HeanService heanService;

    @RequestMapping(value = "/byTime", method = RequestMethod.POST)
    public ResponseEntity<JSONObject> searchByTime(@RequestBody JSONObject request) {
        JSONArray heanList = heanService.searchByTime(request);
        return new ResponseEntity<JSONObject>(HeanUtil.constructJsonOfHeanList(heanList), HttpStatus.OK);
    }

    @RequestMapping(value = "/byUser", method = RequestMethod.POST)
    public ResponseEntity<JSONObject> searchByUser(@RequestBody JSONObject request) {
        JSONArray heanList = heanService.searchByUser(request);
        return new ResponseEntity<JSONObject>(HeanUtil.constructJsonOfHeanList(heanList), HttpStatus.OK);
    }

    @RequestMapping(value = "/byPosition", method = RequestMethod.POST)
    public ResponseEntity<JSONObject> searchByPosition(@RequestBody JSONObject request) {
        JSONArray heanList = heanService.searchByPosition(request);
        return new ResponseEntity<JSONObject>(HeanUtil.constructJsonOfHeanList(heanList), HttpStatus.OK);
    }

}
