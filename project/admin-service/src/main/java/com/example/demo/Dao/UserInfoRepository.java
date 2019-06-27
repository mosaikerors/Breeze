package com.example.demo.Dao;

import com.example.demo.Entity.User;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface UserInfoRepository extends JpaRepository<User, Long> {

  List<User> findByUsername(String username);

  List<User> findByUsernameLike(String name);

  User findByPhone(Long phone);



  void deleteByPhone(Long phone);

}
