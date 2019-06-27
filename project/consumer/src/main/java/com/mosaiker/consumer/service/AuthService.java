package com.mosaiker.consumer.service;

import com.alibaba.fastjson.JSONObject;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.context.annotation.Primary;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Primary  // 因为引入 fallback 类，出现两个同类 Bean，所以不加 @Primary 会导致 @Autowired 有红色波浪线（尽管不影响运行）
@FeignClient(value = "auth-service")
@RequestMapping(value = "/token")  // 这里 url 公共的部分不能用 RequestMappnig，要用 @FeignClient 的 path 属性
public interface AuthService {

    @RequestMapping(value = "/token/get", method = RequestMethod.POST)
    JSONObject getToken(@RequestBody JSONObject request);

    @RequestMapping(value = "/token/verify", method = RequestMethod.POST)
    boolean verifyToken(@RequestBody JSONObject request);

}
