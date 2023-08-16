package com.example.intelligentscheduling.entity;

public class EmployeeScheduling {
    private String employeeId;
    private String employeeName;
    private String employeePosts;
    private String storesId;
    private String employeeEmail;
    private String schedulingCol;
    private String date;
    private String startTime;
    private String endTime;

    public EmployeeScheduling() {
    }

    public EmployeeScheduling(String employeeId, String employeeName, String employeePosts, String storesId, String employeeEmail, String schedulingCol, String date, String startTime, String endTime) {
        this.employeeId = employeeId;
        this.employeeName = employeeName;
        this.employeePosts = employeePosts;
        this.storesId = storesId;
        this.employeeEmail = employeeEmail;
        this.schedulingCol = schedulingCol;
        this.date = date;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public String getSchedulingCol() {
        return schedulingCol;
    }

    public void setSchedulingCol(String schedulingCol) {
        this.schedulingCol = schedulingCol;
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

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    @Override
    public String toString() {
        return "EmployeeScheduling{" +
                "employeeId='" + employeeId + '\'' +
                ", employeeName='" + employeeName + '\'' +
                ", employeePosts='" + employeePosts + '\'' +
                ", storesId='" + storesId + '\'' +
                ", employeeEmail='" + employeeEmail + '\'' +
                ", schedulingCol='" + schedulingCol + '\'' +
                ", date='" + date + '\'' +
                ", startTime='" + startTime + '\'' +
                ", endTime='" + endTime + '\'' +
                '}';
    }
}
