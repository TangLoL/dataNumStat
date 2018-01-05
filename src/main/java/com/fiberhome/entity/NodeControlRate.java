package com.fiberhome.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created by zyf on 2017/12/8.
 * 网络节点侦控系统控制率情况汇总表
 */
@Entity
@Table(name = "ST_NodeControlRate")
public class NodeControlRate implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "node_id")
    @SequenceGenerator(sequenceName = "node_id",allocationSize = 1,name = "node_id")
    @Column(unique = true)
    private Integer id;
    @Column(length = 255)
    private String unit;
    @Column()
    private long unicomCurrent;
    @Column()
    private long unicomControlled;
    @Column()
    private long mobileCurrent;
    @Column()
    private long mobileControlled;
    @Column()
    private long telecomCurrent;
    @Column()
    private long telecomControlled;
    @Column()
    private long sumCurrent;
    @Column()
    private long sumControlled;
    @Column(precision = 3,scale = 2)//precision数据的长度，scale为小数点位数
    private double controlRate;
    @Column(length = 50)
    private String factory;
    @Column()
    private int rank;
    @Column(length = 10)
    private String time;

    public NodeControlRate(){}
    public NodeControlRate(List list){
        for (int i =0;i<list.size();i++){
            if (list.get(i).toString().equals("")) {
                list.set(i,0);
            }
        }
        unit=String.valueOf(list.get(0));
        unicomCurrent=Long.parseLong(String.valueOf(list.get(1)));
        unicomControlled=Long.parseLong(String.valueOf(list.get(2)));
        telecomCurrent=Long.parseLong(String.valueOf(list.get(3)));
        telecomControlled=Long.parseLong(String.valueOf(list.get(4)));
        mobileCurrent=Long.parseLong(String.valueOf(list.get(5)));
        mobileControlled=Long.parseLong(String.valueOf(list.get(6)));
        sumCurrent=Long.parseLong(String.valueOf(list.get(7)));
        sumControlled=Long.parseLong(String.valueOf(list.get(8)));
        if (list.get(9).toString().length()>4)
            controlRate=Double.parseDouble(list.get(9).toString().substring(0,4));
        else
            controlRate=Double.parseDouble(String.valueOf(list.get(9)));
        factory=String.valueOf(list.get(10));
        rank=Integer.parseInt(String.valueOf(list.get(11)));
        time = String.valueOf(list.get(12));
    }
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public long getUnicomCurrent() {
        return unicomCurrent;
    }

    public void setUnicomCurrent(long unicomCurrent) {
        this.unicomCurrent = unicomCurrent;
    }

    public long getUnicomControlled() {
        return unicomControlled;
    }

    public void setUnicomControlled(long unicomControlled) {
        this.unicomControlled = unicomControlled;
    }

    public long getMobileCurrent() {
        return mobileCurrent;
    }

    public void setMobileCurrent(long mobileCurrent) {
        this.mobileCurrent = mobileCurrent;
    }

    public long getMobileControlled() {
        return mobileControlled;
    }

    public void setMobileControlled(long mobileControlled) {
        this.mobileControlled = mobileControlled;
    }

    public long getTelecomCurrent() {
        return telecomCurrent;
    }

    public void setTelecomCurrent(long telecomCurrent) {
        this.telecomCurrent = telecomCurrent;
    }

    public long getTelecomControlled() {
        return telecomControlled;
    }

    public void setTelecomControlled(long telecomControlled) {
        this.telecomControlled = telecomControlled;
    }

    public long getSumCurrent() {
        return sumCurrent;
    }

    public void setSumCurrent(long sumCurrent) {
        this.sumCurrent = sumCurrent;
    }

    public long getSumControlled() {
        return sumControlled;
    }

    public void setSumControlled(long sumControlled) {
        this.sumControlled = sumControlled;
    }

    public double getControlRate() {
        return controlRate;
    }

    public void setControlRate(double controlRate) {
        this.controlRate = controlRate;
    }

    public String getFactory() {
        return factory;
    }

    public void setFactory(String factory) {
        this.factory = factory;
    }

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
