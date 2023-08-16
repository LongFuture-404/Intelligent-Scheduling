package com.example.intelligentscheduling.entity;

public class Store {
    private String storesId;
    private String storesName;
    private String storesAddress;
    private Integer storesSize;

    public Store() {
    }

    public Store(String storesId, String storesName, String storesAddress, Integer storesSize) {
        this.storesId = storesId;
        this.storesName = storesName;
        this.storesAddress = storesAddress;
        this.storesSize = storesSize;
    }

    public String getStoresId() {
        return storesId;
    }

    public void setStoresId(String storesId) {
        this.storesId = storesId;
    }

    public String getStoresName() {
        return storesName;
    }

    public void setStoresName(String storesName) {
        this.storesName = storesName;
    }

    public String getStoresAddress() {
        return storesAddress;
    }

    public void setStoresAddress(String storesAddress) {
        this.storesAddress = storesAddress;
    }

    public Integer getStoresSize() {
        return storesSize;
    }

    public void setStoresSize(Integer storesSize) {
        this.storesSize = storesSize;
    }

    @Override
    public String toString() {
        return "Store{" +
                "storesId='" + storesId + '\'' +
                ", storesName='" + storesName + '\'' +
                ", storesAddress='" + storesAddress + '\'' +
                ", storesSize=" + storesSize +
                '}';
    }
}
