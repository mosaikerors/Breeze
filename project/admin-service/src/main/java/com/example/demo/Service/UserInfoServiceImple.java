package com.example.demo.Service;

import com.example.demo.Repository.UserInfoRepository;
import com.example.demo.Entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserInfoServiceImple implements UserInfoService {

    @Autowired
    private UserInfoRepository userInfoRepository;

    @Override
    public User queryByPhone(String phone) {
        return userInfoRepository.findById(phone).orElse(null);
    }

    @Override
    public User queryById(String id) {
        return userInfoRepository.findById(id).orElse(null);
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
    public long count() {
        return userInfoRepository.count();
    }
}
