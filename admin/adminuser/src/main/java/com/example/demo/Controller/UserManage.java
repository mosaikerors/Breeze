package com.example.demo.Controller;
import com.example.demo.Entity.ResultBean;
import com.example.demo.Service.UserInfoService;
import com.example.demo.Entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value="/admin")
public class UserManage {
    @Autowired
    private UserInfoService userInfoService;

    @GetMapping(value="/Edit")
    public String ToEdit(String phone, Map<String, Object> map) {
        User user = userInfoService.queryByPhone(phone);
        map.put("user", user);
        return "admin/user/edit";
    }


    @RequestMapping("/Userlist")
    public ResultBean<List<User>> FindAllUser(int pageindex,
                                              @RequestParam(value = "pageSize", defaultValue = "15") int pageSize) {
        Pageable pageable = new PageRequest(pageindex, pageSize);
        List<User> users = userInfoService.findAll(pageable).getContent();
        return new ResultBean<>(users);
    }


    @GetMapping("/GetTotal")
    public ResultBean<Integer> geTotal() {
        Pageable pageable = new PageRequest(1, 15);
        int total = (int) userInfoService.findAll(pageable).getTotalElements();
        return new ResultBean<>(total);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/ViewDetail/?")
    public ResultBean<User> ShowDetail(String u_id){
        User user=userInfoService.queryById(u_id);
        return new ResultBean<>(user);
    }

    @RequestMapping("/Manage/?")
    public ResultBean<Boolean> ChangeState(String phone) {
        User user=userInfoService.queryByPhone(phone);
        int i= ((user.getStatus()==0)?-1:0);
        user.setStatus(i);
        userInfoService.update(user);
        return new ResultBean<>(true);
    }

    @GetMapping(value = "/Update")
    public ResultBean<Boolean> update(String username,
                                      String password,Integer state,
                                      String phone,String email) {
        User user = userInfoService.queryByPhone(phone);
        user.setStatus(state);
        user.setUsername(username);
        user.setPassword(password);
        user.setEmail(email);
        user.setPhone(phone);
        userInfoService.update(user);
        return new ResultBean<>(true);
    }
}
