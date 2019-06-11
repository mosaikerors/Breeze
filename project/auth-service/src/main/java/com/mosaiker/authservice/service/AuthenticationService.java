package com.mosaiker.authservice.service;

import com.alibaba.fastjson.JSONObject;
import com.mosaiker.authservice.hystric.AuthenticationHystric;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.context.annotation.Primary;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Primary
@FeignClient(value = "user-service", fallback = AuthenticationHystric.class, path = "/api/user")
public interface AuthenticationService {

    @RequestMapping(value = "/authenticate", method = RequestMethod.POST)
    JSONObject authenticate(@RequestBody JSONObject request);

}
