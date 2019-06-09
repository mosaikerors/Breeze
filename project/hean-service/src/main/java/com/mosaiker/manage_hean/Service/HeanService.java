package com.mosaiker.manage_hean.Service;

import com.mosaiker.manage_hean.Entity.Hean;

import java.util.Date;
import java.util.List;

public interface HeanService {
    List<Hean> searchByTime(Date beginTime, Date endTime);
    List<Hean> searchByUser(long userId);
    List<Hean> searchByPosition(String position, float range);
}