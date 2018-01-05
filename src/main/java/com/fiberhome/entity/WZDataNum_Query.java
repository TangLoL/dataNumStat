package com.fiberhome.entity;

public class WZDataNum_Query {
    private String city;
    private String dates;
    private int sumnum;
    private String companyname;

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getDates() {
        return dates;
    }

    public void setDates(String dates) {
        this.dates = dates;
    }

    public int getSumnum() {
        return sumnum;
    }

    public void setSumnum(int sumnum) {
        this.sumnum = sumnum;
    }

    public String getCompanyname() {
        return companyname;
    }

    public void setCompanyname(String companyname) {
        this.companyname = companyname;
    }

    @Override
    public String toString() {
        return "WZDataNum_Query{" +
                "city='" + city + '\'' +
                ", dates='" + dates + '\'' +
                ", sumnum=" + sumnum +
                ", companyname='" + companyname + '\'' +
                '}';
    }
}
