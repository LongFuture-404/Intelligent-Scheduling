package com.example.intelligentscheduling.service;

import com.example.intelligentscheduling.entity.Employee;
import com.example.intelligentscheduling.entity.EmployeeScheduling;
import com.example.intelligentscheduling.entity.Scheduling;
import com.example.intelligentscheduling.entity.Scheduling_role;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.RequestBody;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

@Mapper
public interface EmployeeService {
    List<Employee> EmployeeSelect(String storesId);
    void EmployeeInsert( Employee employee);
    void EmployeeUpdate(Employee employee);
    void EmployeeDelete(String employeeId,String storesId);
    Scheduling_role Scheduling_roleSelect(String storesId);
    void Scheduling_roleUpdate(Scheduling_role schedulingRole);
    Employee SelectUser(String account);
    List<String> employeeSchedulingSelect(String startWeek,String endWeek,String date,String storesId,Integer dayPrefer,String time,Integer employeeCountNeed,Integer workTime);
    void addEmployeeScheduling(String startWeek,String endWeek,String employeeId,String storesId,String date,String startTime,Integer workTime) throws ParseException;
    ArrayList<EmployeeScheduling> getEmployeeScheduling(String date,String storesId);
    ArrayList<Employee> getUpdateEmployeeSelect(Scheduling scheduling);
    ArrayList<Employee> getInsertEmployeeSelect(Scheduling scheduling);

}
