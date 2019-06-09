package com.example.demo.Controller;
import com.alibaba.fastjson.JSONObject;
import com.example.demo.Service.UserInfoService;
import com.example.demo.Entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "/admin")
public class UserManage {

    @Autowired
    private UserInfoService userInfoService;

    @RequestMapping(value = "/Userlist", method = RequestMethod.GET)
    public JSONObject findAllUser(@RequestParam int pageIndex, @RequestParam int pageSize) {
        Pageable pageable = PageRequest.of(pageIndex, pageSize);
        List<User> users = userInfoService.findAll(pageable).getContent();
        JSONObject result = new JSONObject();
        result.put("users", users);
        return result;
    }


    @RequestMapping(value = "/GetTotal", method = RequestMethod.GET)
    public JSONObject getTotal() {
        Pageable pageable = PageRequest.of(1, 15);
        int total = (int) userInfoService.findAll(pageable).getTotalElements();
        JSONObject result = new JSONObject();
        result.put("totalNum", total);
        return result;
    }

    @RequestMapping(value = "/ViewDetail", method = RequestMethod.POST)
    public JSONObject showDetail(@RequestBody JSONObject param){
        String u_id = param.getString("u_id");
        User user=userInfoService.queryById(u_id);
        JSONObject result = new JSONObject();
        result.put("user", user);
        return result;
    }

    @RequestMapping(value = "/Manage", method = RequestMethod.PUT)
    public JSONObject changeStatus(@RequestParam JSONObject param) {
        String phone = param.getString("phone");
        User user=userInfoService.queryByPhone(phone);
        int i= ((user.getStatus()==0)?-1:0);
        user.setStatus(i);
        userInfoService.update(user);
        JSONObject result = new JSONObject();
        result.put("status", i);
        return result;
    }

    @RequestMapping(value = "/Update", method = RequestMethod.PUT)
    public JSONObject update(@RequestBody JSONObject param) {
        String username = param.getString("username");
        String password = param.getString("password");
        Integer state = param.getInteger("status");
        String phone = param.getString("phone");
        String email = param.getString("email");
        User user = userInfoService.queryByPhone(phone);
        user.setStatus(state);
        user.setUsername(username);
        user.setPassword(password);
        user.setEmail(email);
        user.setPhone(phone);
        userInfoService.update(user);
        JSONObject result = new JSONObject();
        result.put("user", user);
        return result;
    }
}
