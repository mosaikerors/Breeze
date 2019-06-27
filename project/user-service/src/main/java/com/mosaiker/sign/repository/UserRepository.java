package com.mosaiker.sign.repository;

import com.mosaiker.sign.entity.User;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {
    User findByPhone(Long phone);
    User findByPhoneAndPassword(String phone, String password);
    @Modifying
    @Transactional
    void deleteUserByPhone(Long phone);
}
