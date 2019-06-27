package com.mosaiker.sign.service;

import com.mosaiker.sign.entity.User;
import com.mosaiker.sign.repository.UserRepository;
import com.mosaiker.sign.utils.UserUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User findUserByPhone(Long phone) {
        return userRepository.findByPhone(phone);
    }

    @Override
    public User findByPhoneAndPassword(String phone, String password){
        return userRepository.findByPhoneAndPassword(phone, password);
    }

}
