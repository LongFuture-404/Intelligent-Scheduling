package com.example.intelligentscheduling.dao;

import com.example.intelligentscheduling.entity.Employee;
import jakarta.annotation.Resource;
import org.apache.ibatis.annotations.Mapper;

import java.sql.Time;
import java.util.Date;
import java.util.List;

@Mapper
@Resource(name = "EmployeeDao")
public interface EmployeeDao {
    Employee Select(String acount);

    /**
     * 增加日期时间段下的已有员工安排数
     */
    void employeeCountIncrease(String date,String startTime, String endTime,String storesId);

    /**
     * 读取日期时间段下的已有员工安排数
     */
    Integer employeeCountRead(String date,String startTime,String endTime,String storesId);

    /**
     * 在添加前需要判断dayRemainder【日剩余时间】和weekRemainder【周剩余时间】
     */
    void employeeSchedulingInsert(String employeeId,String date,String startTime,String endTime,String storesId);

    /** [优先选择符合偏好的员工]排班表和偏好表查询
     * 查询员工dayRemainder【日剩余时间】和weekRemainder【周剩余时间】以及偏好dayPrefer【日期偏好】和TimePrefer【时间偏好】
     */
    List<String> employeeSchedulingSelect(String storesId,Integer dayPrefer,String time);
    /** [选择员工]排班表和偏好表查询
     * 查询员工dayRemainder【日剩余时间】和weekRemainder【周剩余时间】
     */
    List<String> employeeSchedulingSelect2(String storesId,Integer dayPrefer,String time,Integer count);
    Integer employeeIsRest(String employeeId,String date,String startTime);
    /**
     * 获取周剩余时间
     */
    Integer employeeWeekSelect(String startWeek,String endWeek,String employeeId);
    Employee employeeSelect(String employeeId);
    void addScheduling(String employeeId,String storesId,String date,String startTime,Integer workTime);
    void addEmployeeCount(String storesId,String date,String startTime,Integer workTime);
    /**
     * 在修改换班时使用
     */
    List<Employee> employeeSchedulingUpdateSelect(Date date,Time startTime,Time endTime,String storesId);
}
