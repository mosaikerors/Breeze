package com.example.demo.Service;

import com.example.demo.Dao.UserInfoRepository;
import com.example.demo.Entity.User;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;

import com.example.demo.Util;

import java.util.List;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

@Service
public class UserInfoServiceImple implements UserInfoService {

  //max numbers for userinfos to save one time
  private int BATCH_RECORD_COUNT = 2000;
  @Autowired
  private UserInfoRepository userInfoRepository;
  //@Autowired
  //private MongoTemplate mongoTemplate;


  @Override
  public User queryByPhone(Long phone) {
    return userInfoRepository.findByPhone(phone);
  }

  @Override
  public void batchSave(List<User> userList) {
    try {
      List<List<User>> groupList = Util.fixedGrouping(userList, BATCH_RECORD_COUNT);
      for (List<User> list : groupList) {
        userInfoRepository.saveAll(list);
      }
    }catch(DataAccessException dae) {
      throw dae;
    }
  }

  @Override
  public User queryById(Long id) {
    Optional<User> opt=userInfoRepository.findById(id);
    return opt.orElse(null);
  }

  @Override
  public List<User> queryByUsernameLike(String name) {
    return userInfoRepository.findByUsernameLike(name);
  }

  @Override
  public List<User> findAll() {
    return userInfoRepository.findAll();
  }

  @Override
  public User update(User user) {
    return userInfoRepository.save(user);
  }

  @Override
  public List<User> findByUsername(String username) {
    return userInfoRepository.findByUsername(username);
  }

}
