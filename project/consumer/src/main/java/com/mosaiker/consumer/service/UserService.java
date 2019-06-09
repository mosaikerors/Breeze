package com.mosaiker.consumer.service;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;


@FeignClient(value = "admin-manage")
@RequestMapping(value = "/admin")
public interface UserService {

    @RequestMapping(value = "/Userlist", method = RequestMethod.GET)
    JSONObject findAllUser(int pageIndex, int pageSize);

    @GetMapping("/GetTotal")
    JSONObject getTotal();

    @RequestMapping(method = RequestMethod.POST, value = "/ViewDetail")
    JSONObject showDetail(@RequestBody JSONObject param);

    @PutMapping("/Manage")
    JSONObject changeStatus(@RequestBody JSONObject param);

    @PutMapping(value = "/Update")
    JSONObject update(@RequestBody JSONObject param);

}