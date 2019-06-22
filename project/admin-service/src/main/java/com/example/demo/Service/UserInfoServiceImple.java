package com.example.demo.Service;

import com.example.demo.UserInfoRepository;
import com.example.demo.Entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Component;
import com.example.demo.Util;

import java.util.List;

@Component
public class UserInfoServiceImple implements UserInfoService {

  //max numbers for userinfos to save one time
  private int BATCH_RECORD_COUNT = 2000;
  @Autowired
  private UserInfoRepository userInfoRepository;
  @Autowired
  private MongoTemplate mongoTemplate;


  @Override
  public User queryByPhone(String phone) {
    return userInfoRepository.findByPhone(phone);
  }

  @Override
  public void batchSave(List<User> userList) {
    List<List<User>> groupList = Util.fixedGrouping(userList, BATCH_RECORD_COUNT);
    for (List<User> list : groupList) {
      mongoTemplate.insert(list, User.class);
    }
  }

  @Override
  public User queryById(String id) {
    return userInfoRepository.findById(id).orElse(null);
  }

  @Override
  public List<User> queryByUsernameLike(String name) {
    return userInfoRepository.findByUsernameLike(name);
  }

  @Override
  public List<User> queryByPhoneLike(String phone) {
    return userInfoRepository.findByPhoneLike(phone);
  }

  @Override
  public List<User> findAll() {
    return userInfoRepository.findAll();
  }

  @Override
  public void update(User user) {
    userInfoRepository.save(user);
  }

  @Override
  public List<User> findByUsername(String username) {
    return userInfoRepository.findByUsername(username);
  }

}
