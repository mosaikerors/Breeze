package com.example.demo.Service;

import com.example.demo.Entity.User;
import org.springframework.stereotype.Service;

import java.util.List;

public interface UserInfoService {

    User queryByPhone(String phone);

    List<User> findAll();

    User queryById(String id);

    void update(User user);

    long count();

}



