package com.example.demo.Service;

import com.example.demo.Entity.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("userInfoService")
public interface UserInfoService {

  List<User> findAll();

}



