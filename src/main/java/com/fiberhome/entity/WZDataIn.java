package com.fiberhome.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "ST_WZDATAIN_STAT")
public class WZDataIn {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "ST_WZIN_SEQ")
    @SequenceGenerator(sequenceName = "st_wzdatain_seq",allocationSize = 1,name = "ST_WZIN_SEQ")
    private int id;

    @Column(nullable = false,length = 50)
    private String unit;

    @Column(nullable = false,columnDefinition = "varchar2(50) default '是' ",length = 50)
    private String fixedNetWork;

    @Column(nullable = false,columnDefinition = "varchar2(50) default '是' ",length = 50)
    private String mobileInternet;

    @Column(nullable = false,columnDefinition = "varchar2(50) default '是' ",length = 50)
    private String netBar;

    @Column(nullable = false,columnDefinition = "varchar2(50) default '是' ",length = 50)
    private String wifi;

    @Column(nullable = false,columnDefinition = "varchar2(50) default '是' ",length = 50)
    private String obtain;

    @Column(nullable = false)
    private String factory;

    @Column(nullable = false)
    private String time;

    public WZDataIn(){}

    public WZDataIn(List list) {
        this.unit = String.valueOf(list.get(0));
        this.fixedNetWork = String.valueOf(list.get(1));
        this.mobileInternet = String.valueOf(list.get(2));
        this.netBar = String.valueOf(list.get(3));
        this.wifi = String.valueOf(list.get(4));
        this.obtain = String.valueOf(list.get(5));
        this.factory = String.valueOf(list.get(6));
        this.time = String.valueOf(list.get(7));
    }



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public String getFixedNetWork() {
        return fixedNetWork;
    }

    public void setFixedNetWork(String fixedNetWork) {
        this.fixedNetWork = fixedNetWork;
    }

    public String getMobileInternet() {
        return mobileInternet;
    }

    public void setMobileInternet(String mobileInternet) {
        this.mobileInternet = mobileInternet;
    }

    public String getNetBar() {
        return netBar;
    }

    public void setNetBar(String netBar) {
        this.netBar = netBar;
    }

    public String getWifi() {
        return wifi;
    }

    public void setWifi(String wifi) {
        this.wifi = wifi;
    }

    public String getObtain() {
        return obtain;
    }

    public void setObtain(String obtain) {
        this.obtain = obtain;
    }

    public String getFactory() {
        return factory;
    }

    public void setFactory(String factory) {
        this.factory = factory;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }


    @Override
    public String toString() {
        return "WZDataIn{" +

                "unit='" + unit + '\'' +
                ", fixedNetWork='" + fixedNetWork + '\'' +
                ", mobileInternet='" + mobileInternet + '\'' +
                ", netBar='" + netBar + '\'' +
                ", wifi='" + wifi + '\'' +
                ", obtain='" + obtain + '\'' +
                ", factory='" + factory + '\'' +
                ", time='" + time + '\'' +
                '}';
    }
}
