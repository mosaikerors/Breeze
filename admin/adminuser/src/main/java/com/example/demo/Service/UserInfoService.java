package com.example.demo.Service;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import com.example.demo.Entity.User;
import org.springframework.stereotype.Service;

import java.util.List;
@Service("userInfoService")
public interface UserInfoService {
    void batchSave(List<User> studentList);

    User queryByPhone(String phone);
    Page<User> findAll(Pageable pageable);

    Page<User> queryByUsernameAndPage(int page, int rows, String name);

    List<User> queryByUsernameLike(String name);

    List<User> queryByPhoneLike(String phone);
    Page<User> queryByPhoneAndPage(int page, int rows, String name);

    List<User> findAllExample(Example<User> example);
    User queryById(String id);

    void update(User user);


    String create(User user);


    void delByPhone(String phone);


    List<User> findByUsername(String username);


    User checkLogin(String username, String password);
}



