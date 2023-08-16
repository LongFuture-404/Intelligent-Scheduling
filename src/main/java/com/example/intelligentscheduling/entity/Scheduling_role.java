package com.example.intelligentscheduling.entity;

public class Scheduling_role {
    private String storesId;
    private Integer storesSize;
    private float employeeNeed;
    private Integer maxDayTime;
    private Integer maxWeekTime;
    private Integer beforeTime;
    private Integer beforeEmployeeArea;
    private Integer afterTime;
    private Integer afterEmployeeArea;
    private Integer afterEmployeeMore;
    private float customer_traffic;
    private Integer employeeCount;
    public Scheduling_role() {
    }

    public Scheduling_role(String storesId, Integer storesSize, float employeeNeed, Integer maxDayTime, Integer maxWeekTime, Integer beforeTime, Integer beforeEmployeeArea, Integer afterTime, Integer afterEmployeeArea, Integer afterEmployeeMore, float customer_traffic, Integer employeeCount) {
        this.storesId = storesId;
        this.storesSize = storesSize;
        this.employeeNeed = employeeNeed;
        this.maxDayTime = maxDayTime;
        this.maxWeekTime = maxWeekTime;
        this.beforeTime = beforeTime;
        this.beforeEmployeeArea = beforeEmployeeArea;
        this.afterTime = afterTime;
        this.afterEmployeeArea = afterEmployeeArea;
        this.afterEmployeeMore = afterEmployeeMore;
        this.customer_traffic = customer_traffic;
        this.employeeCount = employeeCount;
    }

    public Integer getMaxDayTime() {
        return maxDayTime;
    }

    public void setMaxDayTime(Integer maxDayTime) {
        this.maxDayTime = maxDayTime;
    }

    public Integer getMaxWeekTime() {
        return maxWeekTime;
    }

    public void setMaxWeekTime(Integer maxWeekTime) {
        this.maxWeekTime = maxWeekTime;
    }

    public Integer getEmployeeCount() {
        return employeeCount;
    }

    public void setEmployeeCount(Integer employeeCount) {
        this.employeeCount = employeeCount;
    }

    public float getCustomer_traffic() {
        return customer_traffic;
    }

    public void setCustomer_traffic(float customer_traffic) {
        this.customer_traffic = customer_traffic;
    }

    public String getStoresId() {
        return storesId;
    }

    public void setStoresId(String storesId) {
        this.storesId = storesId;
    }

    public Integer getStoresSize() {
        return storesSize;
    }

    public void setStoresSize(Integer storesSize) {
        this.storesSize = storesSize;
    }

    public float getEmployeeNeed() {
        return employeeNeed;
    }

    public void setEmployeeNeed(float employeeNeed) {
        this.employeeNeed = employeeNeed;
    }

    public Integer getBeforeTime() {
        return beforeTime;
    }

    public void setBeforeTime(Integer beforeTime) {
        this.beforeTime = beforeTime;
    }

    public Integer getBeforeEmployeeArea() {
        return beforeEmployeeArea;
    }

    public void setBeforeEmployeeArea(Integer beforeEmployeeArea) {
        this.beforeEmployeeArea = beforeEmployeeArea;
    }

    public Integer getAfterTime() {
        return afterTime;
    }

    public void setAfterTime(Integer afterTime) {
        this.afterTime = afterTime;
    }

    public Integer getAfterEmployeeArea() {
        return afterEmployeeArea;
    }

    public void setAfterEmployeeArea(Integer afterEmployeeArea) {
        this.afterEmployeeArea = afterEmployeeArea;
    }

    public Integer getAfterEmployeeMore() {
        return afterEmployeeMore;
    }

    public void setAfterEmployeeMore(Integer afterEmployeeMore) {
        this.afterEmployeeMore = afterEmployeeMore;
    }

    @Override
    public String toString() {
        return "Scheduling_role{" +
                "storesId='" + storesId + '\'' +
                ", storesSize=" + storesSize +
                ", employeeNeed=" + employeeNeed +
                ", maxDayTime=" + maxDayTime +
                ", maxWeekTime=" + maxWeekTime +
                ", beforeTime=" + beforeTime +
                ", beforeEmployeeArea=" + beforeEmployeeArea +
                ", afterTime=" + afterTime +
                ", afterEmployeeArea=" + afterEmployeeArea +
                ", afterEmployeeMore=" + afterEmployeeMore +
                ", customer_traffic=" + customer_traffic +
                ", employeeCount=" + employeeCount +
                '}';
    }
}
