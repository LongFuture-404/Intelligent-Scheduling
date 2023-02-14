package com.example.intelligentscheduling.service.Impl;

import com.example.intelligentscheduling.dao.EmployeeDao;
import com.example.intelligentscheduling.entity.Employee;
import com.example.intelligentscheduling.entity.EmployeeScheduling;
import com.example.intelligentscheduling.service.EmployeeService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import static com.example.intelligentscheduling.DateMethods.getEndTime;

import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;


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
            employeeIdList.addAll(employeeDao.employeeSchedulingSelect2(storesId,dayPrefer,time));
            List<String> employees=new ArrayList<>();
            int count=0;
            SimpleDateFormat f = new SimpleDateFormat("HH:mm");
            Date startTime=f.parse(time);
            for (String e:employeeIdList){

                if((employeeDao.employeeWeekSelect(startWeek,endWeek,e)==null)||(employeeDao.employeeWeekSelect(startWeek,endWeek,e)>=workTime)){
                    if(count>=employeeCountNeed){
                        break;
                    }
                    if(employeeDao.employeeSelect(e,date)==null){
                        employees.add(e);
                        count++;
                    }
                    if(employeeDao.employeeSelect(e,date)!=null){
                        Date endTime=f.parse(employeeDao.employeeSelect(e,date).getEndTime());
                        if((employeeDao.employeeSelect(e,date).getDayRemainder()>=workTime)&&(startTime.after(endTime))){
                            employees.add(e);
                            count++;
                        }
                    }
                }
            }
            if(employees.size()<employeeCountNeed){
                List<String> error = new ArrayList<>();
                String moreNeed= String.valueOf(employeeCountNeed-employees.size());
                error.add("error");
                error.add(moreNeed);
                return error;
            }
//            System.out.println(date+"   "+time+"    "+employees);
            return employees;
        }
        catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }
    @Transactional
    public void addEmployeeScheduling(String startWeek,String endWeek,String employeeId,String storesId,String date,String startTime,Integer workTime) throws ParseException {
        int dayRemainder=0,weekRemainder=0;
        int maxDayTime=8;
        int maxWeekTime=40;
        String endTime=getEndTime(startTime,"hour",workTime);
        if(endTime.equals("00:00"))
        {
            endTime="24:00";
        }
        if(employeeDao.employeeSelect(employeeId,date)==null){
            dayRemainder=maxDayTime-workTime;
        }
        else if(employeeDao.employeeSelect(employeeId,date)!=null){
            dayRemainder=employeeDao.employeeSelect(employeeId,date).getDayRemainder()-workTime;
        }
        if(employeeDao.employeeWeekSelect(startWeek,endWeek,employeeId)==null){
            weekRemainder=maxWeekTime-workTime;
        }
        else if(employeeDao.employeeWeekSelect(startWeek,endWeek,employeeId)!=null){
            weekRemainder=employeeDao.employeeWeekSelect(startWeek,endWeek,employeeId)-workTime;
        }
        //排班表添加员工排班信息
        //同时添加排班休息时间段
        employeeDao.addScheduling(employeeId,storesId,date,startTime,endTime,dayRemainder,weekRemainder);
        //添加客流量预测中安排员工数
        employeeDao.addEmployeeCount(storesId,date,startTime,endTime);
    }
    @Transactional
    public ArrayList<EmployeeScheduling> getEmployeeScheduling(String date,String storesId){
        return employeeDao.SchulingSelect(date,storesId);
    }
}
