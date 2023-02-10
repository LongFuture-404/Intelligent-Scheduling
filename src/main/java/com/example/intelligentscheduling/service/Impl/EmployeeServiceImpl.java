package com.example.intelligentscheduling.service.Impl;

import com.example.intelligentscheduling.dao.EmployeeDao;
import com.example.intelligentscheduling.entity.Employee;
import com.example.intelligentscheduling.service.EmployeeService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Time;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@Service("EmployeeService")
public class EmployeeServiceImpl implements EmployeeService {
    @Resource(name = "employeeDao")
    EmployeeDao employeeDao;
    @Transactional
    public Employee SelectUser(String acount){
        try{
            return employeeDao.Select(acount);
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    @Transactional
    public List<String> employeeSchedulingSelect(String startWeek,String endWeek,String date,String storesId, Integer dayPrefer, String time,Integer employeeCountNeed,Integer workTime){
        try{
            List<String> employeeIdList=employeeDao.employeeSchedulingSelect(storesId,dayPrefer,time);
            employeeIdList.addAll(employeeDao.employeeSchedulingSelect(storesId,dayPrefer,time));
            List<String> employees=new ArrayList<>();
            int count=0;
            for (String e:employeeIdList){
                if((employeeDao.employeeWeekSelect(startWeek,endWeek,e)==null)||(employeeDao.employeeWeekSelect(startWeek,endWeek,e)>=workTime)){
                    if(count>=employeeCountNeed){
                        break;
                    }
                    if(((employeeDao.employeeSelect(e).getDayRemainder()==null)||employeeDao.employeeSelect(e).getDayRemainder()>=workTime)&&(employeeDao.employeeIsRest(e,date,time)==null)){
                        employees.add(employeeDao.employeeSelect(e).getEmployeeId());
                        count++;
                    }
                }
            }
//            System.out.println(date+"   "+time+"    "+employees);
            return employees;
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }
    @Transactional
    public void addEmployeeScheduling(String employeeId,String storesId,String date,String startTime,Integer workTime){
        //排班表添加员工排班信息
        //同时添加排班休息时间段
        employeeDao.addScheduling(employeeId,storesId,date,startTime,workTime);
        //添加客流量预测中安排员工数
        employeeDao.addEmployeeCount(storesId,date,startTime,workTime);
    }
}
