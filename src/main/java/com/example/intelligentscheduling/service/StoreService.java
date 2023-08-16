package com.example.intelligentscheduling.service;

import com.example.intelligentscheduling.entity.Store;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface StoreService {
    Integer getEmployeeNeed(String storesId, String date, Integer weekDay, String startTime);

    Store StoreSelect(String storesId);

    void UpdateStore(String storesId,String storesName, String storesAddress, String storesSize);
}
