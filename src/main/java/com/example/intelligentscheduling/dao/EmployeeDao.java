package com.example.intelligentscheduling.dao;

import com.example.intelligentscheduling.entity.Employee;
import com.example.intelligentscheduling.entity.EmployeeScheduling;
import jakarta.annotation.Resource;
import org.apache.ibatis.annotations.Mapper;

import java.sql.Time;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Mapper
@Resource(name = "EmployeeDao")
public interface EmployeeDao {
    Employee Select(String acount);
    /** [优先选择符合偏好的员工]排班表和偏好表查询
     * 查询员工dayRemainder【日剩余时间】和weekRemainder【周剩余时间】以及偏好dayPrefer【日期偏好】和TimePrefer【时间偏好】
     */
    List<String> employeeSchedulingSelect(String storesId,Integer dayPrefer,String time);
    /** [选择员工]排班表和偏好表查询
     * 查询员工dayRemainder【日剩余时间】和weekRemainder【周剩余时间】
     */
    List<String> employeeSchedulingSelect2(String storesId,Integer dayPrefer,String time);
    /**
     * 获取周剩余时间
     */
    Integer employeeWeekSelect(String startWeek,String endWeek,String employeeId);
    Employee employeeSelect(String employeeId,String date);
    void addScheduling(String employeeId,String storesId,String date,String startTime,String endTime,Integer dayRemainder,Integer weekRemainder);
    void addEmployeeCount(String storesId,String date,String startTime,String endTime);
    ArrayList<EmployeeScheduling> SchulingSelect(String date,String storesId);
    /**
     * 在修改换班时使用
     */
    List<Employee> employeeSchedulingUpdateSelect(Date date,Time startTime,Time endTime,String storesId);
}
