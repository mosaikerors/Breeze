package com.mosaiker.sign.repository;

import com.mosaiker.sign.entity.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {
    User findByPhone(Long phone);
    boolean existsByPhoneAndStatusIsNot(Long phone, int notStatus);
    User findByCodeEquals(String code);
}
