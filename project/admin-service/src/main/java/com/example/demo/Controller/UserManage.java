package com.example.demo.Controller;

import com.alibaba.fastjson.JSONObject;
import com.example.demo.Service.UserInfoService;
import com.example.demo.Entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping(value = "/admin")
public class UserManage {

  @Autowired
  private UserInfoService userInfoService;

  //return the userInfos displayed on current page
  @RequestMapping(value = "/UserList", method = RequestMethod.GET)
  public JSONObject findAllUser() {
    List<User> users = userInfoService.findAll();
    JSONObject result = new JSONObject();
    result.put("users", users);
    return result;
  }

}
