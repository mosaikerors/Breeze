package com.mosaiker.authservice.service;

import com.alibaba.fastjson.JSONObject;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(value = "eureka-sign")
public interface AuthenticationService {

    @RequestMapping(value = "/authenticate", method = RequestMethod.POST)
    JSONObject authenticate(@RequestBody JSONObject request);

}
