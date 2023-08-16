package com.example.intelligentscheduling.dao;

import com.example.intelligentscheduling.entity.Scheduling_role;
import com.example.intelligentscheduling.entity.Store;
import jakarta.annotation.Resource;
import org.apache.ibatis.annotations.Mapper;

@Mapper
@Resource(name = "StoreDao")
public interface StoreDao {
    Store storeSelect(String storesId);
    /**
     * 店铺排班规则查询 scheduling_role和stores表
     */
    Scheduling_role storesRoleSelect(String storesId, String date, String startTime);
    void updateStore(String storesId,String storesName,String storesAddress,String storesSize);
}
