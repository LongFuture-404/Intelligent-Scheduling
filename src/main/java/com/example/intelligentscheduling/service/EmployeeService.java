package com.example.intelligentscheduling.service;

import com.example.intelligentscheduling.entity.Employee;
import com.example.intelligentscheduling.entity.EmployeeScheduling;
import org.apache.ibatis.annotations.Mapper;

import java.sql.Time;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Mapper
public interface EmployeeService {

    Employee SelectUser(String acount);

    List<String> employeeSchedulingSelect(String startWeek,String endWeek,String date,String storesId,Integer dayPrefer,String time,Integer employeeCountNeed,Integer workTime);
    void addEmployeeScheduling(String startWeek,String endWeek,String employeeId,String storesId,String date,String startTime,Integer workTime) throws ParseException;
    ArrayList<EmployeeScheduling> getEmployeeScheduling(String date);
}
