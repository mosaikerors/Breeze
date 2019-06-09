package com.mosaiker.consumer.service;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(value = "manage-hean")
@RequestMapping(value = "/manageHean")
public interface HeanService {

    @RequestMapping(value = "/searchByTime", method = RequestMethod.POST)
    JSONArray searchByTime(@RequestBody JSONObject request);

    @RequestMapping(value = "/searchByUser", method = RequestMethod.POST)
    JSONArray searchByUser(@RequestBody JSONObject request);

    @RequestMapping(value = "/searchByPosition", method = RequestMethod.POST)
    JSONArray searchByPosition(@RequestBody JSONObject request);

}
