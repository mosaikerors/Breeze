package com.mosaiker.manage_hean.Service;

import com.mosaiker.manage_hean.Entity.Hean;
import com.mosaiker.manage_hean.Repository.HeanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
@Service
public class HeanServiceImpl implements HeanService{
    @Autowired
    public HeanRepository heanRepository;

    @Override
    public  List<Hean> searchByTime(Date beginTime, Date endTime){
        return heanRepository.findByTimeBetween(beginTime,endTime);
    }

    @Override
    public List<Hean> searchByUser(long userId){
        System.out.println(heanRepository.findByUserId(userId).size());
        return heanRepository.findByUserId(userId);
    }

    @Override
    public List<Hean> searchByPosition(String position, float range){
        return heanRepository.findByPosition(position);
    }
}


