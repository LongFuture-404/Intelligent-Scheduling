package com.example.intelligentscheduling.dao;

import com.example.intelligentscheduling.entity.Employee;
import com.example.intelligentscheduling.entity.EmployeeScheduling;
import com.example.intelligentscheduling.entity.Scheduling_role;
import jakarta.annotation.Resource;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.data.repository.query.Param;

import java.sql.Time;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Mapper
@Resource(name = "EmployeeDao")
public interface EmployeeDao {
    List<Employee> allEmployeeSelect(String storesId);
    void employeeInsert(Employee employee);
    void employeeUpdate(Employee employee);
    void employeeDelete(String employeeId,String storesId);
    void scheduling_roleUpdate(Scheduling_role schedulingRole);
    Employee Select(String account);
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
    ArrayList<EmployeeScheduling> SchedulingSelect(String date,String storesId);
    /**
     *  查询修改排班符合要求的员工
     */
    ArrayList<Employee> updateEmployeeSelect(String storeId,String date,String startTime,String endTime);
    ArrayList<Employee> insertEmployeeSelect(String storeId,String startWeek,String endWeek,String date,String startTime,String endTime);
    /**
     * 在修改换班时使用
     */
    List<Employee> employeeSchedulingUpdateSelect(Date date,Time startTime,Time endTime,String storesId);

}
