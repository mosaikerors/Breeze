package com.mosaiker.manage_hean.Controller;
import com.alibaba.fastjson.JSONArray;
import com.mosaiker.manage_hean.Entity.Hean;
import com.mosaiker.manage_hean.Service.HeanService;
import com.mosaiker.manage_hean.util.HeanUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RequestMapping("/manage_hean")
@RestController
public class HeanController{

    @Autowired
    HeanService heanService;

    @PostMapping("/searchByTime")
    public JSONArray searchByTime(@RequestParam(name = "beginTime") String beginTime,
                                  @RequestParam(name = "endTime") String endTime) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date beginT = sdf.parse(beginTime);
            Date endT = sdf.parse(endTime);
            return HeanUtil.convertHeanListToJson(heanService.searchByTime(beginT,endT));
        }
        catch (Exception e){
            return null;
        }
    }

    @PostMapping("/searchByUser")
    public JSONArray searchByUser(@RequestParam(name = "userId") Integer userId) {
        //return HeanUtil.convertHeanListToJson(heanService.searchByUser(userId));
        JSONArray e = new JSONArray();
        e.add(userId);
        return e;
    }

    @PostMapping("/searchByPosition")
    public JSONArray searchByPosition(@RequestParam(name = "position") String position,
                                      @RequestParam(name = "range") float range) {
        return HeanUtil.convertHeanListToJson(heanService.searchByPosition(position, range));
    }

}
