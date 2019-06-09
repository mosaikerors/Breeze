package com.mosaiker.sign.repository;

import com.mosaiker.sign.entity.Thirdparty;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ThirdPartyRepository extends CrudRepository<Thirdparty, Long> {
}
