package com.example.intelligentscheduling.dao;

import com.example.intelligentscheduling.entity.Scheduling_role;
import jakarta.annotation.Resource;
import org.apache.ibatis.annotations.Mapper;

@Mapper
@Resource(name = "SchedulingRoleDao")
public interface SchedulingRoleDao {
    Scheduling_role SchedulingRoleSelect(String storesId);
}
