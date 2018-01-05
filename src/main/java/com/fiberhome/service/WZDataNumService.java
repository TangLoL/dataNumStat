package com.fiberhome.service;

import com.fiberhome.mapper.WZDataNumDao;
import com.fiberhome.entity.WZDataNum_Fb;
import com.fiberhome.entity.WZDataNum_Query;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * 连接持久化层与服务层
 */

@Service
public class WZDataNumService {
    @Autowired
    private WZDataNumDao wzDataNumDao;

    Logger logger = Logger.getLogger(WZDataNumService.class);

    private SimpleDateFormat sf = new SimpleDateFormat("yyyyMMddHH");

    /**
     * 将List<WZDataNum_Query>转换为前台需要的格式即WZDataNum_Fb
     * @param ls
     * @return
     */

    private WZDataNum_Fb datafbPlot(List<WZDataNum_Query> ls){
        WZDataNum_Fb fb = new WZDataNum_Fb();
        logger.info("封装对WZDataNum返回数据");
        for(WZDataNum_Query wq : ls) {
            if (wq.getCity().contains("郑州")) {fb.setZhengzhou(wq.getSumnum());}
            if (wq.getCity().contains("开封")) {fb.setKaifeng(wq.getSumnum());}
            if (wq.getCity().contains("洛阳")) {fb.setLuoyang(wq.getSumnum());}
            if (wq.getCity().contains("平顶山")) {fb.setPingdings(wq.getSumnum());}
            if (wq.getCity().contains("安阳")) {fb.setAnyang(wq.getSumnum());}
            if (wq.getCity().contains("鹤壁")) {fb.setHebi(wq.getSumnum());}
            if (wq.getCity().contains("新乡")) {fb.setXinxiang(wq.getSumnum());}
            if (wq.getCity().contains("焦作")) {fb.setJiaozuo(wq.getSumnum());}
            if (wq.getCity().contains("濮阳")) {fb.setPuyang(wq.getSumnum());}
            if (wq.getCity().contains("许昌")) {fb.setXuchang(wq.getSumnum());}
            if (wq.getCity().contains("漯河")) {fb.setLuohe(wq.getSumnum());}
            if (wq.getCity().contains("三门峡")) {fb.setSanmenxia(wq.getSumnum());}
            if (wq.getCity().contains("南阳")) {fb.setNanyang(wq.getSumnum());}
            if (wq.getCity().contains("商丘")) {fb.setShangqiu(wq.getSumnum());}
            if (wq.getCity().contains("信阳")) {fb.setXinyang(wq.getSumnum());}
            if (wq.getCity().contains("周口")) {fb.setZhoukou(wq.getSumnum());}
            if (wq.getCity().contains("驻马店")) {fb.setZhumadian(wq.getSumnum());}
            if (wq.getCity().contains("济源")) {fb.setJiyuan(wq.getSumnum());}
            fb.setDate(wq.getDates());
        }
        logger.info("WZDataNum返回数据success");
        return fb;
    }

    /**
     *从数据库获取数据并对数据进行封装
     * @param day 获取的的时间
     * @return
     */

    public List<WZDataNum_Fb> getQueryData(int day){
        Date lastDate = null;

        try {
            logger.info("数据库最大日期 : " + wzDataNumDao.getMaxDate());
            lastDate = sf.parse(wzDataNumDao.getMaxDate().substring(0,8)+"00");

        } catch (ParseException e) {
            logger.error("日期格式解析错误");
            e.printStackTrace();
        }

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(lastDate);
        calendar.add(Calendar.DAY_OF_MONTH,- day);
        List<List<WZDataNum_Query>> totallist = new ArrayList<>();

        while(calendar.getTime().before(lastDate)){
            String beforedate = null;
            String afterdate = null;
            List<WZDataNum_Query> list = null;
            beforedate =  sf.format(calendar.getTime());
            calendar.add(Calendar.DAY_OF_MONTH,1);
            afterdate = sf.format(calendar.getTime());
            list = wzDataNumDao.getQueryData(beforedate,afterdate);
            logger.info("获取:"+beforedate+"---"+ afterdate+"的数据");
            if(list != null && list.size() !=0){
                totallist.add(list);
            }
        }
        logger.info("获取的数据有: " + totallist.size() + "条");
        List<WZDataNum_Fb> fbList = new ArrayList<WZDataNum_Fb>();
        for(List<WZDataNum_Query> ls : totallist){
            WZDataNum_Fb wzfb = datafbPlot(ls);
            fbList.add(wzfb);
        }
        return fbList;
    }

    public List<WZDataNum_Query> getQueryData(String time,String time2){
        return wzDataNumDao.getQueryData(time,time2);
    }
}
