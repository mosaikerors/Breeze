package com.mosaiker.manage_hean.Repository;

import com.mosaiker.manage_hean.Entity.Hean;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface HeanRepository extends MongoRepository<Hean, Long>{
    List<Hean> findByUserId(long userId);
    List<Hean> findByPosition(String position);
    List<Hean> findByTimeBetween(Date beginTime, Date endTime);
    void deleteByUserIdAndTime(long userId, Date time);
}