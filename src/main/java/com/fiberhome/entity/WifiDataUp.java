package com.fiberhome.entity;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by zyf on 2017/12/8.
 */
@Entity
@Table(name = "ST_WIFIDATAUP")
public class WifiDataUp implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "wifi_id")
    @SequenceGenerator(sequenceName = "wifi_id",allocationSize = 1,name = "wifi_id")
    @Column(unique = true)
    private Integer id;
    @Column(nullable = false,length = 100)
    private String unit;
    @Column(nullable = false,length = 10)
    private String report;
    @Column(nullable = false,length = 20)
    private String time;

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public String getReport() {
        return report;
    }

    public void setReport(String report) {
        this.report = report;
    }


    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
