package com.mosaiker.sign.service;
import com.mosaiker.sign.entity.User;

public interface UserService {

    User findUserByPhone(Long phone);

    String addUser(String name, Long phone, String password);

    String activate(String code);

    String activate(String code, int role);

    User findByPhoneAndPassword(String phone, String password);

}
