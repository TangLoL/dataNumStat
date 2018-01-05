package com.fiberhome.entity;

import java.io.Serializable;

public class WZDataNum implements Serializable {

    private int dealFlag;

    private String dataSource;

    private String dataType;

    private String upAreaId;

    private String companyName;

    private String ispId;

    private int sucRecordNum;

    private int erRecordNum;

    private int statDataDate;

    private int statDate;

    private String reMark;

    private String siteCode;

    private String subDataType;

    private String deviceCode;

    private int exceprecordNum;


    public WZDataNum() {
    }

    public int getDealFlag() {
        return dealFlag;
    }

    public void setDealFlag(int dealFlag) {
        this.dealFlag = dealFlag;
    }

    public String getDataSource() {
        return dataSource;
    }

    public void setDataSource(String dataSource) {
        this.dataSource = dataSource;
    }

    public String getDataType() {
        return dataType;
    }

    public void setDataType(String dataType) {
        this.dataType = dataType;
    }

    public String getUpAreaId() {
        return upAreaId;
    }

    public void setUpAreaId(String upAreaId) {
        this.upAreaId = upAreaId;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getIspId() {
        return ispId;
    }

    public void setIspId(String ispId) {
        this.ispId = ispId;
    }

    public int getSucRecordNum() {
        return sucRecordNum;
    }

    public void setSucRecordNum(int sucRecordNum) {
        this.sucRecordNum = sucRecordNum;
    }

    public int getErRecordNum() {
        return erRecordNum;
    }

    public void setErRecordNum(int erRecordNum) {
        this.erRecordNum = erRecordNum;
    }

    public int getStatDataDate() {
        return statDataDate;
    }

    public void setStatDataDate(int statDataDate) {
        this.statDataDate = statDataDate;
    }

    public int getStatDate() {
        return statDate;
    }

    public void setStatDate(int statDate) {
        this.statDate = statDate;
    }

    public String getReMark() {
        return reMark;
    }

    public void setReMark(String reMark) {
        this.reMark = reMark;
    }

    public String getSiteCode() {
        return siteCode;
    }

    public void setSiteCode(String siteCode) {
        this.siteCode = siteCode;
    }

    public String getSubDataType() {
        return subDataType;
    }

    public void setSubDataType(String subDataType) {
        this.subDataType = subDataType;
    }

    public String getDeviceCode() {
        return deviceCode;
    }

    public void setDeviceCode(String deviceCode) {
        this.deviceCode = deviceCode;
    }

    public int getExceprecordNum() {
        return exceprecordNum;
    }

    public void setExceprecordNum(int exceprecordNum) {
        this.exceprecordNum = exceprecordNum;
    }

    @Override
    public String toString() {
        return "WZDataNum{" +
                "dealFlag=" + dealFlag +
                ", dataSource='" + dataSource + '\'' +
                ", dataType='" + dataType + '\'' +
                ", upAreaId='" + upAreaId + '\'' +
                ", companyName='" + companyName + '\'' +
                ", ispId='" + ispId + '\'' +
                ", sucRecordNum=" + sucRecordNum +
                ", erRecordNum=" + erRecordNum +
                ", statDataDate=" + statDataDate +
                ", statDate=" + statDate +
                ", reMark='" + reMark + '\'' +
                ", siteCode='" + siteCode + '\'' +
                ", subDataType='" + subDataType + '\'' +
                ", deviceCode='" + deviceCode + '\'' +
                ", exceprecordNum=" + exceprecordNum +
                '}';
    }
}
