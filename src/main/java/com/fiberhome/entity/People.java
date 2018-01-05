package com.fiberhome.entity;

import java.util.List;

public class People {
    private String name;
    private String age;
    private String work;
    private String time;

    public People(){}

    public People(List list){
        this.name = String.valueOf(list.get(0));
        this.age = String.valueOf(list.get(1));
        this.work = String.valueOf(list.get(2));
        this.time = String.valueOf(list.get(3));
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getWork() {
        return work;
    }

    public void setWork(String work) {
        this.work = work;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

}
