package com.mosaiker.consumer.service;

import com.alibaba.fastjson.JSONArray;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@FeignClient(value = "manage-hean")
@RequestMapping(value = "/manage_hean")
public interface HeanService {

    @RequestMapping(value = "/searchByTime", method = RequestMethod.POST)
    JSONArray searchByTime(String beginTime, String endTime);

    @RequestMapping(value = "/searchByUser", method = RequestMethod.POST)
    JSONArray searchByUser(Integer userId);

    @RequestMapping(value = "/searchByPosition", method = RequestMethod.POST)
    JSONArray searchByPosition(String position/*, float range*/);

}
