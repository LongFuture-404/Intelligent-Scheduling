package com.example.intelligentscheduling.controller;

import com.example.intelligentscheduling.entity.Employee;
import com.example.intelligentscheduling.entity.EmployeeScheduling;
import com.example.intelligentscheduling.entity.Scheduling;
import com.example.intelligentscheduling.entity.Scheduling_role;
import com.example.intelligentscheduling.service.EmployeeService;
import com.example.intelligentscheduling.service.StoreService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
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
    @RequestMapping("/employeeSelect")
    public List<Employee> EmployeeSelect(@RequestParam("storesId") String storesId){
        return service.EmployeeSelect(storesId);
    }
    @ResponseBody
    @RequestMapping("/employeeInsert")
    public void EmployeeInsert(@RequestBody Employee employee){
        service.EmployeeInsert(employee);
    }
    @ResponseBody
    @RequestMapping("/employeeUpdate")
    public void EmployeeUpdate(@RequestBody Employee employee){
        service.EmployeeUpdate(employee);
    }

    @ResponseBody
    @RequestMapping("/employeeDelete")
    public void EmployeeDelete(@RequestParam("storesId")String storesId,
                               @RequestParam("employeeId")String employeeId){
        service.EmployeeDelete(employeeId,storesId);
    }

    @ResponseBody
    @RequestMapping("/scheduling_roleSelect")
    public Scheduling_role Scheduling_roleSelect(@RequestParam("storesId") String storesId){
        return service.Scheduling_roleSelect(storesId);
    }
    @ResponseBody
    @RequestMapping("/scheduling_roleUpdate")
    public void scheduling_roleUpdate(@RequestBody Scheduling_role schedulingRole){
        service.Scheduling_roleUpdate(schedulingRole);
    }

    @ResponseBody
    @RequestMapping("/getUserByIdByPass")
    public Employee login(@RequestParam("UserId") String account,
                          @RequestParam("PassWord") String pwd){
        Employee employee=service.SelectUser(account);
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
    public ArrayList<EmployeeScheduling> GetScheduling(@RequestParam("weekJS[]")String[] SchedulingWeek,
                                                       @RequestParam("storeId")String storeId) throws Exception {
        ArrayList<EmployeeScheduling> scheduling=new ArrayList<>();
        for(String date:SchedulingWeek){
            ArrayList<EmployeeScheduling> dayScheduling=service.getEmployeeScheduling(date,storeId);
            scheduling.addAll(dayScheduling);
        }
        return scheduling;
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
            if(weekDay<=5){
                startTime = "8:00";
                endTime="21:30";
            }
            else {
                startTime = "9:00";
                endTime="22:30";
            }
            do{
                if((weekDay<=5&&(startTime.equals("11:00")||startTime.equals("13:00")||startTime.equals("21:00")))
                    ||((weekDay>5&&weekDay<=7)&&(startTime.equals("12:00")||startTime.equals("14:00")||startTime.equals("22:00")))){
                    workTime = 2;
                }
                else {
                    workTime = 3;
                }
                employeeCountNeed = storeService.getEmployeeNeed(storeId, date, weekDay, startTime);
//                System.out.println(startTime + " 需要 " + employeeCountNeed);
                if(employeeCountNeed>0){
                    List<String> employees=service.employeeSchedulingSelect(SchedulingWeek[0],SchedulingWeek[6],date,storeId,weekDay,startTime,employeeCountNeed,workTime);
                    if(employees.get(0).equals("error")){
                        System.out.println(date + "  " + startTime + " 无可用员工，请添加 "+employees.get(1)+" 名员工");
                    }
                    else {
                        for (String employee : employees) {
                            service.addEmployeeScheduling(SchedulingWeek[0], SchedulingWeek[6], employee, storeId, date, startTime, workTime);
                        }
                    }
                }
                startTime=getEndTime(startTime,"minutes",30);
            }while (!startTime.equals(endTime));
        }
        System.out.println("执行完毕");
    }
    @ResponseBody
    @RequestMapping("/UpdateSelectScheduling")
    public ArrayList<String> UpdateSelectScheduling(@RequestBody Scheduling scheduling,
                                                    @RequestParam("operation") String operation,
                                                    @RequestParam("schedulingCol") String schedulingCol
//                                        @RequestParam("date")String date,
//                                       @RequestParam("startTime")String startTime,
//                                       @RequestParam("endTime")String endTime,
//                                        @RequestParam("weekJS[]")String[] SchedulingWeek
    ) throws Exception {
//        System.out.println(schedulingCol);
//        System.out.println(date+"  "+startTime+"  "+endTime);
//        System.out.println(scheduling);
        ArrayList<String> employeeName = new ArrayList<>();
        //可以在当日选择时段添加排班的员工
        ArrayList<Employee> employees = new ArrayList<>(service.getInsertEmployeeSelect(scheduling));
        //可以在当日选择时段换班的员工
        if(operation.equals("update")) {
            employees.addAll(service.getUpdateEmployeeSelect(scheduling));
        }
        for (Employee employee : employees) {
            employeeName.add(employee.getEmployeeName());
        }
        return employeeName;
    }
    @ResponseBody
    @RequestMapping("/UpdateScheduling")
    public void UpdateScheduling(@RequestParam(value = "schedulingCol",required = false)String schedulingCol,
                                 @RequestParam("operation")String operation,
                                 @RequestParam("weekJS[]")String[] SchedulingWeek) throws Exception {
        System.out.println(schedulingCol+"   "+operation);
        if(operation.equals("update")) {
            System.out.println("修改操作");
        }
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
