package com.example.demo.Service;

import com.example.demo.Entity.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("userInfoService")
public interface UserInfoService {

  User queryByPhone(String phone);

  List<User> findAll();

  User queryById(String id);

  //update userInfo
  void update(User user);

  //save a batch of userinfos
  void batchSave(List<User> userList);

  List<User> queryByUsernameLike(String name);

  List<User> queryByPhoneLike(String phone);

  List<User> findByUsername(String username);

}



