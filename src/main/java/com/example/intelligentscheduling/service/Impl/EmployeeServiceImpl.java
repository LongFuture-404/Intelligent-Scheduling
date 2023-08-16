package com.example.intelligentscheduling.service.Impl;

import com.example.intelligentscheduling.dao.EmployeeDao;
import com.example.intelligentscheduling.dao.SchedulingRoleDao;
import com.example.intelligentscheduling.entity.Employee;
import com.example.intelligentscheduling.entity.EmployeeScheduling;
import com.example.intelligentscheduling.entity.Scheduling;
import com.example.intelligentscheduling.entity.Scheduling_role;
import com.example.intelligentscheduling.service.EmployeeService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import static com.example.intelligentscheduling.DateMethods.getEndTime;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

@Service("EmployeeService")
public class EmployeeServiceImpl implements EmployeeService {
    @Resource(name = "employeeDao")
    EmployeeDao employeeDao;
    @Resource(name = "schedulingRoleDao")
    SchedulingRoleDao schedulingRoleDao;

    @Transactional
    public List<Employee> EmployeeSelect(String storesId){
        try{
            return employeeDao.allEmployeeSelect(storesId);
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }
    @Transactional
    public void EmployeeInsert( Employee employee){
        try{
            employeeDao.employeeInsert(employee);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    @Transactional
    public void EmployeeUpdate( Employee employee){
        try{
            employeeDao.employeeUpdate(employee);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    @Transactional
    public void EmployeeDelete(String employeeId,String storesId){
        try{
            employeeDao.employeeDelete(employeeId,storesId);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Transactional
    public void Scheduling_roleUpdate(Scheduling_role schedulingRole){
        try{
            employeeDao.scheduling_roleUpdate(schedulingRole);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    @Transactional
    public Scheduling_role Scheduling_roleSelect(String storesId){
        try{
            return schedulingRoleDao.SchedulingRoleSelect(storesId);
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }
    @Transactional
    public Employee SelectUser(String account){
        try{
            return employeeDao.Select(account);
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
        return employeeDao.SchedulingSelect(date,storesId);
    }
    //换班情况下员工查找
    @Transactional
    public ArrayList<Employee> getUpdateEmployeeSelect(Scheduling scheduling){
        //对换班日期时段的员工进行筛选，选择符合换班条件的员工
        String storeId=scheduling.getStoresId();
        String date=scheduling.getDate();
        String startTime=scheduling.getStartTime();
        String endTime=scheduling.getEndTime();
        return employeeDao.updateEmployeeSelect(storeId,date,startTime,endTime);
    }
    //添加情况下员工查找
    @Transactional
    public ArrayList<Employee> getInsertEmployeeSelect(Scheduling scheduling){
        //查找该店铺所有符合新增排班条件的员工
        String storeId=scheduling.getStoresId();
        String startWeek=scheduling.getWeekJS()[0];
        String endWeek=scheduling.getWeekJS()[6];
        String date=scheduling.getDate();
        String startTime=scheduling.getStartTime();
        String endTime=scheduling.getEndTime();
        return employeeDao.insertEmployeeSelect(storeId,startWeek,endWeek,date,startTime,endTime);
    }
}
