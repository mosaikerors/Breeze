package com.example.demo.Dao;

import com.example.demo.Entity.User;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserInfoRepository extends JpaRepository<User, Long> {

  List<User> findByUsername(String username);

  List<User> findByUsernameLike(String name);

  User findByPhone(Long phone);



  void deleteByPhone(Long phone);

}
