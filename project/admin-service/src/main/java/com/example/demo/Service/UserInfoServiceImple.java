package com.example.demo.Service;

import com.example.demo.Dao.UserInfoRepository;
import com.example.demo.Entity.User;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class UserInfoServiceImple implements UserInfoService {

  @Autowired
  private UserInfoRepository userInfoRepository;

  @Override
  public List<User> findAll() {
    return userInfoRepository.findAll();
  }

}
