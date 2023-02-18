package com.example.intelligentscheduling.service;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface StoreService {
    Integer getEmployeeNeed(String storesId, String date, Integer weekDay, String startTime);
}
