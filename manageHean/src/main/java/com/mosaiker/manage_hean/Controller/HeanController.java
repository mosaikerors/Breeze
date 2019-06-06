package com.mosaiker.manage_hean.Controller;
import com.mosaiker.manage_hean.Entity.Hean;
import com.mosaiker.manage_hean.Service.HeanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.Date;
import java.util.List;

@RequestMapping("/manage_hean")
@RestController
public class HeanController{
    @Autowired
    HeanService heanService;

    @PostMapping("/searchByTime")
    public List<Hean> searchByTime(@RequestParam(name = "beginTime")Date beginTime, @RequestParam(name = "endTime")Date endTime){
        return heanService.searchByTime(beginTime,endTime);
    }

    @PostMapping("/searchByUser")
    public List<Hean> searchByUser(@RequestParam(name = "userId")Integer userId){
        System.out.println(userId);
        return heanService.searchByUser(userId);
    }

    @PostMapping("/searchByPosition")
    public List<Hean> searchByPosition(@RequestParam(name = "position")String position,@RequestParam(name="range")float range){
        return heanService.searchByPosition(position, range);
    }
}
