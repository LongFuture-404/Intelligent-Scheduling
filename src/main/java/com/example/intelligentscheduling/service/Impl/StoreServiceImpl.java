package com.example.intelligentscheduling.service.Impl;

import com.example.intelligentscheduling.dao.StoreDao;
import com.example.intelligentscheduling.entity.Scheduling;
import com.example.intelligentscheduling.entity.Scheduling_role;
import com.example.intelligentscheduling.service.StoreService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service("StoreService")
public class StoreServiceImpl implements StoreService {
    @Resource(name = "storeDao")
    StoreDao storeDao;
    @Override
    public Integer getEmployeeNeed(String storesId, String date, String startTime) {
        Scheduling_role scheduling_role=storeDao.storesRoleSelect(storesId,date,startTime);
        Integer storesSize = scheduling_role.getStoresSize();

        int employeeCountNeed;
        if(startTime.equals("8:00")||(startTime.equals("9:00"))){
            employeeCountNeed=(int)Math.ceil((double)storesSize/scheduling_role.getBeforeEmployeeArea())-scheduling_role.getEmployeeCount();
        }
        else if(startTime.equals("23:00")||(startTime.equals("24:00"))){
            employeeCountNeed=(int)Math.ceil((double)storesSize/scheduling_role.getAfterEmployeeArea())+scheduling_role.getAfterEmployeeMore()-scheduling_role.getEmployeeCount();
        }
        else {
            employeeCountNeed=(int)Math.ceil(scheduling_role.getCustomer_traffic()/scheduling_role.getEmployeeNeed())-scheduling_role.getEmployeeCount();
        }
        return employeeCountNeed;
    }
}
