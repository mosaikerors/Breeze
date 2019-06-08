package com.mosaiker.sign.repository;

import com.mosaiker.sign.entity.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {
    User findByPhone(Long phone);
    boolean existsByPhoneAndStatusIsNot(Long phone, int notStatus);
    User findByCodeEquals(String code);
    User findByPhoneAndPassword(String phone, String password);
}
