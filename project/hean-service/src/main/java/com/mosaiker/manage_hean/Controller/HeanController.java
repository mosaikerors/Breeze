package com.mosaiker.manage_hean.Controller;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.mosaiker.manage_hean.Service.HeanService;
import com.mosaiker.manage_hean.Util.HeanUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Date;

@RequestMapping("/manageHean")
@RestController
public class HeanController{

    @Autowired
    HeanService heanService;

    @PostMapping("/searchByTime")
    public JSONArray searchByTime(@RequestBody JSONObject request) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date beginT = sdf.parse(request.getString("beginTime"));
            Date endT = sdf.parse(request.getString("endTime"));
            return HeanUtil.convertHeanListToJson(heanService.searchByTime(beginT,endT));
        }
        catch (Exception e){
            return null;
        }
    }

    @PostMapping("/searchByUser")
    public JSONArray searchByUser(@RequestBody JSONObject request) {
        return HeanUtil.convertHeanListToJson(heanService.searchByUser(request.getInteger("userId")));
    }

    @PostMapping("/searchByPosition")
    public JSONArray searchByPosition(@RequestBody JSONObject request) {
        return HeanUtil.convertHeanListToJson(heanService.searchByPosition(
                request.getString("position"), request.getFloat("range")));
    }

}
