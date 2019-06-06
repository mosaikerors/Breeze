package com.mosaiker.manage_hean.Repository;

import com.mosaiker.manage_hean.Entity.Hean;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Date;
import java.util.List;

public interface HeanRepository extends MongoRepository<Hean, Long>{
    List<Hean> findByUserId(long userId);
    List<Hean> findByPosition(String position);
    List<Hean> findByTimeBetween(Date beginTime, Date endTime);
}