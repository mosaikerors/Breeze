package com.mosaiker.sign.service;
import com.mosaiker.sign.entity.User;

public interface UserService {
    public User findUserByPhone(Long phone);
    public String addUser(String name, Long phone, String password);
    public String activate(String code);
    public String activate(String code, int role);
}
