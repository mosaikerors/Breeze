package com.mosaiker.consumer.service;

import com.alibaba.fastjson.JSONObject;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.context.annotation.Primary;
import org.springframework.web.bind.annotation.*;

@FeignClient(value = "admin-service")
public interface AdminService {

    @RequestMapping(value = "/admin/UserList", method = RequestMethod.GET)
    JSONObject findAllUser();

}