package com.mosaiker.consumer.service;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.mosaiker.consumer.hystric.HeanHystric;
import com.mosaiker.consumer.hystric.UserHystric;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.context.annotation.Primary;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Primary  // 因为引入 fallback 类，出现两个同类 Bean，所以不加 @Primary 会导致 @Autowired 有红色波浪线（尽管不影响运行）
@FeignClient(value = "user-service", fallback = UserHystric.class, path = "/api/user")
//@RequestMapping(value = "/api/user")   这里 url 公共的部分不能用 RequestMappnig，要用 @FeignClient 的 path 属性
public interface UserService {

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    JSONObject login(@RequestBody JSONObject params);

    @RequestMapping(value = "/signup", method = RequestMethod.POST)
    JSONObject signup(@RequestBody JSONObject params);

    @RequestMapping(value = "/activate", method = RequestMethod.GET)
    JSONObject activate(@RequestParam String code);

}
