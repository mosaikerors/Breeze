package com.mosaiker.consumer.service;

import com.alibaba.fastjson.JSONObject;
import com.mosaiker.consumer.hystric.AdminHystric;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.context.annotation.Primary;
import org.springframework.web.bind.annotation.*;

@Primary  // 因为引入 fallback 类，出现两个同类 Bean，所以不加 @Primary 会导致 @Autowired 有红色波浪线（尽管不影响运行）
@FeignClient(value = "admin-service", fallback = AdminHystric.class, path = "/admin")
//@RequestMapping(value = "/admin")    这里 url 公共的部分不能用 RequestMappnig，要用 @FeignClient 的 path 属性
public interface AdminService {

    @RequestMapping(value = "/userlist", method = RequestMethod.GET)
    JSONObject findAllUser();

    @RequestMapping(value = "/totalNum", method = RequestMethod.GET)
    JSONObject getTotal();

    @RequestMapping(value = "/userinfo", method = RequestMethod.GET)
    JSONObject showDetail(@RequestParam(name = "id") String u_id);

    @RequestMapping(value = "/toggle", method = RequestMethod.PUT)
    JSONObject changeStatus(@RequestBody JSONObject param);

    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    JSONObject update(@RequestBody JSONObject param);

}