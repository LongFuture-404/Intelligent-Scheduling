package com.example.intelligentscheduling.controller;

import com.example.intelligentscheduling.entity.Employee;
import com.example.intelligentscheduling.entity.Scheduling;
import com.example.intelligentscheduling.entity.Scheduling_role;
import com.example.intelligentscheduling.service.EmployeeService;
import com.example.intelligentscheduling.service.StoreService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

import static com.example.intelligentscheduling.DateMethods.*;

@RestController
@RequestMapping("/EmployeeController")
@CrossOrigin
public class EmployeeController {
//    周一~周五：早9点~晚9点
//    周末：早10点~晚10点
//    单个班次最少2小时，最多4小时。员工可以连续排多个班次
//    午餐时间：时间范围（如11点到14点，半小时）
//    晚餐时间：时间范围（如17点到20点，半小时）
//    休息时间：时间范围（不限。半小时）

    @Resource(name = "EmployeeService")
    EmployeeService service;
    @Resource(name = "StoreService")
    StoreService storeService;
    @ResponseBody
    @RequestMapping("/getUserByIdByPass")
    public Employee login(@RequestParam(value = "UserId") String acount,
                          @RequestParam(value = "PassWord") String pwd){
        Employee employee=service.SelectUser(acount);
        if(employee!=null) {
            if (employee.getPassWord().equals(pwd)) {
                return employee;
            } else {
                return null;
            }
        }
        else {
            return new Employee();
        }
    }
    //返回本周的排班安排数据
    @ResponseBody
    @RequestMapping("/GetScheduling")
    public ArrayList<Scheduling> GetScheduling(@RequestParam("weekJS[]")String[] SchedulingWeek,
                                               @RequestParam("storeId")String storeId) throws Exception {
        return null;
    }
    //只进行添加排班操作，不返回任何数据
    @ResponseBody
    @RequestMapping("/AutoSchedulingTime")
    public void AutoSchedulingTime(@RequestParam("weekJS[]")String[] SchedulingWeek,
                                   @RequestParam("storeId")String storeId) throws ParseException {
        //1. 根据客流量预测获取各个时间段的员工数需求生成 数组
        int weekDay=0;
        String startTime,endTime;
        Integer employeeCountNeed;
        int workTime;
        for(String date:SchedulingWeek) {
            weekDay++;
            if(weekDay<5){
                startTime = "8:00";
                endTime="21:30";
            }
            else {
                startTime = "9:00";
                endTime="22:30";
            }
            do{
                if((weekDay<5&&(startTime.equals("11:00")||startTime.equals("13:00")||startTime.equals("21:00")))
                    ||((weekDay>=5&&weekDay<7)&&(startTime.equals("12:00")||startTime.equals("14:00")||startTime.equals("22:00")))){
                    workTime = 2;
                }
                else {
                    workTime = 3;
                }
                employeeCountNeed = storeService.getEmployeeNeed(storeId, date, startTime);
                if(employeeCountNeed>0){
                    List<String> employees=service.employeeSchedulingSelect(SchedulingWeek[0],SchedulingWeek[6],date,storeId,weekDay,startTime,employeeCountNeed,workTime);
                    for (String employee:employees){
                        service.addEmployeeScheduling(employee,storeId,date,startTime,workTime);
                    }
                }
                else{
                    continue;
                }
                GregorianCalendar calendar = new GregorianCalendar();
                SimpleDateFormat f = new SimpleDateFormat("HH:mm");
                Date nextTime=f.parse(startTime);
                calendar.setTime(nextTime);
                calendar.add(Calendar.MINUTE,30);
                startTime=f.format(calendar.getTime());
            }while (!startTime.equals(endTime));
        }
        //2. 根据排班安排对数组进行操作 时间段=0则不进行操作 不等于0则根据偏好工作时间安排员工并且在其工作时间段对应数组-1
        //isFirst指店员是否在本日安排了班次
//        service.employeeSchedulingSelect("1","1", time, 2);
        //3. 所有时间段数组=0后停止操作

    }
    @ResponseBody
    @RequestMapping("/UpdateScheduling")
    public void UpdateScheduling(@RequestParam("employeeCol[]")Integer employeeCol,
                                 @RequestParam("weekJS")String weekLastDay) throws Exception {

    }
//    @ResponseBody
//    @RequestMapping("/GetDate")
//    public List<String> GetDate(@RequestParam(value = "week",required = false)Integer week) throws Exception {
//        Date date=new Date();
//        Calendar calendar=Calendar.getInstance();
//        calendar.setTime(date);
//        calendar.add(Calendar.DATE,week);
//        List<String> array=getTimeInterval(calendar.getTime());
//        String start_time= array.get(0);
//        String end_time= array.get(1);
//        List<String> lDate = findDates(start_time, end_time);
//        return lDate;
//    }
}
