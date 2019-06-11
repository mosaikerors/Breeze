package com.mosaiker.sign.service;

import com.mosaiker.sign.entity.Admin;
import com.mosaiker.sign.entity.Player;
import com.mosaiker.sign.entity.Thirdparty;
import com.mosaiker.sign.entity.User;
import com.mosaiker.sign.repository.AdminRepository;
import com.mosaiker.sign.repository.PlayerRepository;
import com.mosaiker.sign.repository.ThirdPartyRepository;
import com.mosaiker.sign.repository.UserRepository;
import com.mosaiker.sign.utils.UserUtil;
import com.mosaiker.sign.utils.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private AdminRepository adminRepository;

    @Autowired
    private PlayerRepository playerRepository;

    @Autowired
    private ThirdPartyRepository thirdPartyRepository;

    @Override
    public User findUserByPhone(Long phone) {
        return userRepository.findByPhone(phone);
    }

    @Override
    public String addUser(String name, Long phone, String password) {
        if (userRepository.existsByPhoneAndStatusIsNot(phone, 0))
            return "该手机号已被注册";
        try {
            String code = Utils.randomNumber(20);
            if (Utils.sendCode(phone, code)) {
                User user = UserUtil.updateUserWith(
                        userRepository.findByPhone(phone), phone, name, password, code);
                userRepository.save(user);
                return "ok";
            } else
                return "验证码发送失败，请稍后再重试";
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return "add user fail";
        }
    }

    @Override
    public String activate(String code, int role) {
        User user = userRepository.findByCodeEquals(code);
        if (user == null)
            return "认证已过期";

        if (user.getStatus() != 0)
            return "用户已认证，请不要重复认证";

        user.setStatus(role);
        user.setCode("");
        userRepository.save(user);
        switch (role) {
            case 1:
                playerRepository.save(UserUtil.createPlayerFromUser(user)); break;
            case 2:
                adminRepository.save(UserUtil.createAdminFromUser(user)); break;
            case 3:
                thirdPartyRepository.save(UserUtil.createThirdPartyFromUser(user)); break;
        }
        return "ok";
    }

    @Override
    public String activate(String code) {
        return activate(code, 1);
    }

    @Override
    public User findByPhoneAndPassword(String phone, String password){
        return userRepository.findByPhoneAndPassword(phone, password);
    }

}
