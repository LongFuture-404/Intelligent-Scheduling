package com.example.intelligentscheduling.entity;

import java.sql.Time;
import java.util.Arrays;
import java.util.Date;

public class Scheduling {
    private String employeeId;
    private String storesId;
    private String date;
    private String startTime;
    private String endTime;
    private String[] weekJS;
    public Scheduling() {
    }

    public Scheduling(String employeeId, String storesId, String date, String startTime, String endTime, String[] weekJS) {
        this.employeeId = employeeId;
        this.storesId = storesId;
        this.date = date;
        this.startTime = startTime;
        this.endTime = endTime;
        this.weekJS = weekJS;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public String getStoresId() {
        return storesId;
    }

    public void setStoresId(String storesId) {
        this.storesId = storesId;
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

    public String[] getWeekJS() {
        return weekJS;
    }

    public void setWeekJS(String[] weekJS) {
        this.weekJS = weekJS;
    }

    @Override
    public String toString() {
        return "Scheduling{" +
                "employeeId='" + employeeId + '\'' +
                ", storesId='" + storesId + '\'' +
                ", date='" + date + '\'' +
                ", startTime='" + startTime + '\'' +
                ", endTime='" + endTime + '\'' +
                ", weekJS=" + Arrays.toString(weekJS) +
                '}';
    }
}
