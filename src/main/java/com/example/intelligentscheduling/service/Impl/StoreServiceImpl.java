package com.example.intelligentscheduling.service.Impl;

import com.example.intelligentscheduling.dao.StoreDao;
import com.example.intelligentscheduling.entity.Scheduling_role;
import com.example.intelligentscheduling.entity.Store;
import com.example.intelligentscheduling.service.StoreService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("StoreService")
public class StoreServiceImpl implements StoreService {
    @Resource(name = "storeDao")
    StoreDao storeDao;
    @Transactional
    public Integer getEmployeeNeed(String storesId, String date, Integer weekDay, String startTime) {
        Scheduling_role scheduling_role=storeDao.storesRoleSelect(storesId,date,startTime);
        Integer storesSize = scheduling_role.getStoresSize();

        int employeeCountNeed;
        if(((weekDay<=5&&weekDay>=1)&&startTime.equals("8:00"))||((weekDay>=5&&weekDay<=7)&&startTime.equals("9:00"))){
            employeeCountNeed=(int)Math.ceil((double)storesSize/scheduling_role.getBeforeEmployeeArea())-scheduling_role.getEmployeeCount();
        }
        else if(((weekDay<=5&&weekDay>=1)&&startTime.equals("21:00"))||(weekDay>=5&&weekDay<=7)&&startTime.equals("22:00")){
            employeeCountNeed=(int)Math.ceil((double)storesSize/scheduling_role.getAfterEmployeeArea())+scheduling_role.getAfterEmployeeMore()-scheduling_role.getEmployeeCount();
        }
        else {
            employeeCountNeed=(int)Math.ceil(scheduling_role.getCustomer_traffic()/scheduling_role.getEmployeeNeed())-scheduling_role.getEmployeeCount();
        }
        return employeeCountNeed;
    }
    @Transactional
    public Store StoreSelect(String storesId){
        try{
            return storeDao.storeSelect(storesId);
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }
    @Transactional
    public void UpdateStore(String storesId,String storesName,String storesAddress,String storesSize){
        try{
            storeDao.updateStore(storesId,storesName,storesAddress,storesSize);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
