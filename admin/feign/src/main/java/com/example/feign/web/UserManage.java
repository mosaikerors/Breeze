package com.example.feign.web;

import com.example.demo.Entity.ResultBean;
import com.example.demo.Entity.User;
import com.example.demo.Service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import java.util.Map;

@RestController
public class UserManage {
    @Autowired
    private UserManageFeign userManageFeign;

    @RequestMapping(value = "/Edit",method = RequestMethod.GET)
    public String Edit(String phone, Map<String, Object> map){
        return this.userManageFeign.Edit(phone,map);
    }

    @RequestMapping(value = "/Userlist", method = RequestMethod.GET)
    public ResultBean<List<User>> FindAllUser(int pageindex,
                                              @RequestParam(value = "pageSize", defaultValue = "15") int pageSize) {
        return this.userManageFeign.FindAllUser(pageindex,pageSize);
    }

    @RequestMapping(value = "/GetTotal",method = RequestMethod.GET)
    public ResultBean<Integer> GetTotal() {
       return this.userManageFeign.GetTotal();
    }

    @RequestMapping(method = RequestMethod.POST, value = "/ViewDetail/{phone}")
    public ResultBean<User> ShowDetail(String u_id){
        return this.userManageFeign.ShowDetail(u_id);
    }
    @RequestMapping("/Manage/{phone}")
    public ResultBean<Boolean> ChangeState(String phone) {
        return this.userManageFeign.ChangeState(phone);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/Update")
    public ResultBean<Boolean> update(String username, String password,Integer state, String phone,String email) {
        return this.userManageFeign.Update(username,password,state,phone,email);
    }
}
