package com.zengkai.entity;

/**
 * 请求参数
 */
public class ReqDTO {
    private String userName;
    private String model;
    private String startDate;
    private String endDate;

    public ReqDTO() {

    }

    public ReqDTO(String userName, String model, String startDate, String endDate) {
        this.userName = userName;
        this.model = model;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }
}
