package com.example.demo;

import com.example.demo.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserInfoRepository extends JpaRepository<User, String> {

  List<User> findByUsername(String username);

  List<User> findByUsernameLike(String name);

  User findByPhone(String phone);

  List<User> findByPhoneLike(String phone);

  void deleteByPhone(String phone);

}
