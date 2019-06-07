package com.example.feign.web;
import com.example.demo.Entity.ResultBean;
import com.example.demo.Entity.User;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@FeignClient("userInfoService")
public interface UserManageFeign {
    @RequestMapping(value = "/Edit",method = RequestMethod.GET)
    public String Edit(String phone, Map<String, Object> map);

    @RequestMapping("/Userlist")
    public ResultBean<List<User>> FindAllUser(int pageindex, @RequestParam(value = "pageSize", defaultValue = "15") int pageSize);

    @RequestMapping("/GetTotal")
    public ResultBean<Integer> GetTotal();

    @RequestMapping("/Manage/{phone}")
    public ResultBean<Boolean> ChangeState(String phone);

        @RequestMapping(method = RequestMethod.POST, value = "/ViewDetail/{phone}")
        public ResultBean<User> ShowDetail(String u_id);

    @RequestMapping(method = RequestMethod.POST, value = "/Update")
    public ResultBean<Boolean> Update(String username, String password,Integer state, String phone,String email);
}
