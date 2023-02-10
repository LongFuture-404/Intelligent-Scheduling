package com.example.intelligentscheduling.entity;

import javax.xml.crypto.Data;
import java.sql.Time;
import java.util.Date;

public class Scheduling {
    private String employeeId;
    private String storesId;
    private Date date;
    private Time startTime;
    private Time endTime;

    public Scheduling() {
    }

    public Scheduling(String employeeId, String storesId, Date date, Time startTime, Time endTime) {
        this.employeeId = employeeId;
        this.storesId = storesId;
        this.date = date;
        this.startTime = startTime;
        this.endTime = endTime;
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

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Time getStartTime() {
        return startTime;
    }

    public void setStartTime(Time startTime) {
        this.startTime = startTime;
    }

    public Time getEndTime() {
        return endTime;
    }

    public void setEndTime(Time endTime) {
        this.endTime = endTime;
    }

    @Override
    public String toString() {
        return "Scheduling{" +
                "employeeId='" + employeeId + '\'' +
                ", storesId='" + storesId + '\'' +
                ", date=" + date +
                ", startTime=" + startTime +
                ", endTime=" + endTime +
                '}';
    }
}
