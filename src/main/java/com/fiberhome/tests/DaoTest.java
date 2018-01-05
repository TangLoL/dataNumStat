package com.fiberhome.tests;

import com.fiberhome.dao.WZDataNumDao;
import com.fiberhome.entity.WZDataNum;

import javax.annotation.Resource;
import java.util.List;

public class DaoTest {

    @Resource
    private WZDataNumDao wzDataNumDao;

    public  void getWZData(){
       List<WZDataNum> l  = wzDataNumDao.getWZNumData();
       for (WZDataNum wzDataNum :l){
           System.out.println(wzDataNum.toString());
       }
    }

    public static void main(String[] args) {
        DaoTest d = new DaoTest();
        d.getWZData();
    }
}
