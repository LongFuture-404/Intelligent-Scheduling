package com.example.intelligentscheduling.service;

import com.example.intelligentscheduling.entity.Scheduling;
import com.example.intelligentscheduling.entity.Scheduling_role;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface StoreService {
    Integer getEmployeeNeed(String storesId, String date, String startTime);
}
