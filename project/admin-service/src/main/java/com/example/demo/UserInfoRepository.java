package com.example.demo;

import com.example.demo.Entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserInfoRepository extends MongoRepository<User, String> {

  User findByUsernameAndPassword(String username, String password);

  List<User> findByUsername(String username);

  List<User> findByUsernameLike(String name);

  Page<User> findByUsernameLike(String name, Pageable pageable);

  List<User> findByPhoneLike(String phone);

  Page<User> findByPhoneLike(String phone, Pageable pageable);

}
