package com.mosaiker.sign.service;
import com.mosaiker.sign.entity.User;

public interface UserService {

    User findUserByPhone(Long phone);

    User findByPhoneAndPassword(String phone, String password);

}
