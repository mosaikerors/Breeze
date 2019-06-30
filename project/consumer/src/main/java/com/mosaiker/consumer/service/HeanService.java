package com.mosaiker.consumer.service;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.context.annotation.Primary;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Primary  // 因为引入 fallback 类，出现两个同类 Bean，所以不加 @Primary 会导致 @Autowired 有红色波浪线（尽管不影响运行）
@FeignClient(value = "hean-service")
@RequestMapping(value = "/manageHean")  // 这里 url 公共的部分不能用 RequestMappnig，要用 @FeignClient 的 path 属性
public interface HeanService {

    @RequestMapping(value = "/searchByTime", method = RequestMethod.POST)
    JSONArray searchByTime(@RequestBody JSONObject request);

    @RequestMapping(value = "/searchByUser", method = RequestMethod.POST)
    JSONArray searchByUser(@RequestBody JSONObject request);

    @RequestMapping(value = "/searchByPosition", method = RequestMethod.POST)
    JSONArray searchByPosition(@RequestBody JSONObject request);

}
