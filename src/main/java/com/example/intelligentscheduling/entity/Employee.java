package com.example.intelligentscheduling.entity;

public class Employee {
    private String employeeId;
    private String employeeName;
    private String employeePosts;
    private String storesId;
    private String employeeEmail;
    private String UserId;
    private String PassWord;
    private String date;
    private String startTime1;
    private String startTime2;
    private String dayPrefer;
    private String endTime;
    private Integer dayRemainder;
    private Integer weekRemainder;
    public Employee() {
    }

    public Employee(String employeeId, String employeeName, String employeePosts, String storesId, String employeeEmail, String userId, String passWord, String date, String startTime1, String startTime2, String dayPrefer, String endTime, Integer dayRemainder, Integer weekRemainder) {
        this.employeeId = employeeId;
        this.employeeName = employeeName;
        this.employeePosts = employeePosts;
        this.storesId = storesId;
        this.employeeEmail = employeeEmail;
        UserId = userId;
        PassWord = passWord;
        this.date = date;
        this.startTime1 = startTime1;
        this.startTime2 = startTime2;
        this.dayPrefer = dayPrefer;
        this.endTime = endTime;
        this.dayRemainder = dayRemainder;
        this.weekRemainder = weekRemainder;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getStartTime1() {
        return startTime1;
    }

    public void setStartTime1(String startTime1) {
        this.startTime1 = startTime1;
    }

    public String getStartTime2() {
        return startTime2;
    }

    public void setStartTime2(String startTime2) {
        this.startTime2 = startTime2;
    }

    public String getDayPrefer() {
        return dayPrefer;
    }

    public void setDayPrefer(String dayPrefer) {
        this.dayPrefer = dayPrefer;
    }

    public Integer getDayRemainder() {
        return dayRemainder;
    }

    public void setDayRemainder(Integer dayRemainder) {
        this.dayRemainder = dayRemainder;
    }

    public Integer getWeekRemainder() {
        return weekRemainder;
    }

    public void setWeekRemainder(Integer weekRemainder) {
        this.weekRemainder = weekRemainder;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public String getEmployeePosts() {
        return employeePosts;
    }

    public void setEmployeePosts(String employeePosts) {
        this.employeePosts = employeePosts;
    }

    public String getStoresId() {
        return storesId;
    }

    public void setStoresId(String storesId) {
        this.storesId = storesId;
    }

    public String getEmployeeEmail() {
        return employeeEmail;
    }

    public void setEmployeeEmail(String employeeEmail) {
        this.employeeEmail = employeeEmail;
    }

    public String getUserId() {
        return UserId;
    }

    public void setUserId(String userId) {
        UserId = userId;
    }

    public String getPassWord() {
        return PassWord;
    }

    public void setPassWord(String passWord) {
        PassWord = passWord;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "employeeId='" + employeeId + '\'' +
                ", employeeName='" + employeeName + '\'' +
                ", employeePosts='" + employeePosts + '\'' +
                ", storesId='" + storesId + '\'' +
                ", employeeEmail='" + employeeEmail + '\'' +
                ", UserId='" + UserId + '\'' +
                ", PassWord='" + PassWord + '\'' +
                ", date='" + date + '\'' +
                ", startTime1='" + startTime1 + '\'' +
                ", startTime2='" + startTime2 + '\'' +
                ", dayPrefer='" + dayPrefer + '\'' +
                ", endTime='" + endTime + '\'' +
                ", dayRemainder=" + dayRemainder +
                ", weekRemainder=" + weekRemainder +
                '}';
    }
}
