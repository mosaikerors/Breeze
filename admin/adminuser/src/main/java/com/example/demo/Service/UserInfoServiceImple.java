package com.example.demo.Service;

import com.example.demo.UserInfoRepository;
import com.example.demo.Entity.User;
import jdk.nashorn.internal.runtime.options.Option;
import org.hibernate.validator.internal.util.CollectionHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Component;
import com.example.demo.Util;

import java.lang.reflect.Array;
import java.util.List;
@Component
public class UserInfoServiceImple implements UserInfoService {
    private int BATCH_RECORD_COUNT=2000;
    @Autowired
    private UserInfoRepository userInfoRepository;
    @Autowired
    private MongoTemplate mongoTemplate;

    @Override
    public User queryByPhone(String phone){
           return userInfoRepository.findById(phone).orElse(null);
    }
    @Override
    public void batchSave(List<User> userList) {
        List<List<User>> groupList = Util.fixedGrouping(userList, BATCH_RECORD_COUNT);
        for (List<User> list : groupList) {
            mongoTemplate.insert(list, User.class);
        }
    }
    @Override
    public User queryById(String id){
        return userInfoRepository.findById(id).orElse(null);
    }
    @Override
    public List<User> queryByUsernameLike(String name) {
        return  userInfoRepository.findByUsernameLike(name);
    }

    @Override
    public List<User> queryByPhoneLike(String phone) {
        return userInfoRepository.findByPhoneLike(phone);
    }
    @Override
    public Page<User> queryByPhoneAndPage(int page, int rows, String phone){
        PageRequest pageRequest = new PageRequest(page, rows);
        return userInfoRepository.findByPhoneLike(phone, pageRequest);
    }
    @Override
    public Page<User> queryByUsernameAndPage(int page, int rows, String name){
        PageRequest pageRequest = new PageRequest(page, rows);
        return userInfoRepository.findByUsernameLike(name, pageRequest);
    }

    @Override
    public Page<User> findAll(Pageable pageable) {
        return userInfoRepository.findAll(pageable);
    }

    @Override
    public List<User> findAllExample(Example<User> example) {
        return userInfoRepository.findAll(example);
    }

    @Override
    public void update(User user) {
        userInfoRepository.save(user);
    }

    @Override
    public String create(User user) {
        return userInfoRepository.save(user).getPhone();
    }

    @Override
    public void delByPhone(String phone) {
        userInfoRepository.deleteById(phone);
    }

    @Override
    public List<User> findByUsername(String username) {
        return userInfoRepository.findByUsername(username);
    }

    @Override
    public User checkLogin(String username, String password) {
        return userInfoRepository.findByUsernameAndPassword(username, password);
    }
}
