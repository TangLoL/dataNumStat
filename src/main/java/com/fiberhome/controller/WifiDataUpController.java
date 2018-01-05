package com.fiberhome.controller;

import com.fiberhome.entity.WZDataUp_Fb;
import com.fiberhome.entity.WifiDataUp;
import com.fiberhome.mapper.WifiDataUpDao;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.ServletContext;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by zyf on 2017/12/8.
 */
@RestController
@RequestMapping("/WifiDataUp")
public class WifiDataUpController {
    Logger logger = Logger.getLogger(WifiDataUpController.class);
    @Resource
    private WifiDataUpDao wifiDataUpDao;

    @RequestMapping("/setData")
    public String saveData(WZDataUp_Fb wzDataUp_fb){

        List<WifiDataUp> result=wifiDataUpDao.getRecentDate(wzDataUp_fb.getDate());
        System.out.println(wzDataUp_fb.getData());
        try {
            if (result!=null&&result.size()!=0) {
                for (WifiDataUp dd:update(wzDataUp_fb))
                    System.out.println(dd.getUnit()+"----"+dd.getReport());;
                logger.info("execute update");
            }
            else {
                insert(wzDataUp_fb);
                logger.info("execute insert");

            }
        } catch (Exception e) {
            return "error";
        }
        return "success";
    }
    @RequestMapping("/getData")
    public List<WZDataUp_Fb> getData(@RequestParam(value = "time",required = false)String time){
        List<WifiDataUp> list;
        if (time==null)
            list = wifiDataUpDao.getTopFive(90);
        else
            list = wifiDataUpDao.getRecentDate(time);
        List<WZDataUp_Fb> list1 = null;
        try {
            list1 = translate(list);
        } catch (Exception e) {
            logger.error("数据WifiDataUp转WZDataUp_Fb错误");
            e.printStackTrace();
        } finally {
        }
        return list1;
    }
    @RequestMapping("/getOne")
    public WZDataUp_Fb getOne(@RequestParam(value = "time",required = false)String time){
        try {
//            System.out.println(time);
//            time=time.replaceAll("-","");
//            System.out.println(wifiDataUpDao.getRecentDate(time));
            List<WifiDataUp> list = wifiDataUpDao.getRecentDate(time);
            List<WZDataUp_Fb> list1 = translate(list);
            System.out.println(list1);
            if (list1==null ||list1.size()==0)
                return null;
            else {
                System.out.println(list1.get(0).getJiyuan());
                return list1.get(0);
            }
        } catch (Exception e) {
            logger.error("数据WifiDataUp转WZDataUp_Fb错误");
            e.printStackTrace();
            return null;
        }
    }
    @RequestMapping("/maxDate")
    public String maxDate(){
        String str =wifiDataUpDao.getMaxDate();
        System.out.println(str);
        return str;
    }
    private List<WifiDataUp> update(WZDataUp_Fb wzDataUp_fb){
        List<WifiDataUp> list =wifiDataUpDao.getRecentDate(wzDataUp_fb.getDate());
        for (WifiDataUp up:list){
            if (up.getUnit().contentEquals("郑州")) up.setReport(wzDataUp_fb.getZhengzhou());
            if (up.getUnit().contentEquals("开封")) up.setReport(wzDataUp_fb.getKaifeng());
            if (up.getUnit().contentEquals("洛阳")) up.setReport(wzDataUp_fb.getLuoyang());
            if (up.getUnit().contentEquals("平顶山")) up.setReport(wzDataUp_fb.getPingdings());
            if (up.getUnit().contentEquals("安阳")) up.setReport(wzDataUp_fb.getAnyang());
            if (up.getUnit().contentEquals("鹤壁"))up.setReport(wzDataUp_fb.getHebi());
            if (up.getUnit().contentEquals("新乡")) up.setReport(wzDataUp_fb.getXinxiang());
            if (up.getUnit().contentEquals("焦作")) up.setReport(wzDataUp_fb.getJiaozuo());
            if (up.getUnit().contentEquals("濮阳")) up.setReport(wzDataUp_fb.getPuyang());
            if (up.getUnit().contentEquals("许昌")) up.setReport(wzDataUp_fb.getXuchang());
            if (up.getUnit().contentEquals("漯河")) up.setReport(wzDataUp_fb.getLuohe());
            if (up.getUnit().contentEquals("三门峡")) up.setReport(wzDataUp_fb.getSanmenxia());
            if (up.getUnit().contentEquals("南阳")) up.setReport(wzDataUp_fb.getNanyang());
            if (up.getUnit().contentEquals("商丘")) up.setReport(wzDataUp_fb.getShangqiu());
            if (up.getUnit().contentEquals("信阳")) up.setReport(wzDataUp_fb.getXinyang());
            if (up.getUnit().contentEquals("周口")) up.setReport(wzDataUp_fb.getZhoukou());
            if (up.getUnit().contentEquals("驻马店")) up.setReport(wzDataUp_fb.getZhumadian());
            if (up.getUnit().contentEquals("济源")) up.setReport(wzDataUp_fb.getJiyuan());
        }

        return wifiDataUpDao.save(list);
    }
    private void insert(WZDataUp_Fb data){
        List<WifiDataUp> list = new ArrayList<>();
        for (String str:data.getData()){
            WifiDataUp wd=new WifiDataUp();
            wd.setTime(data.getDate());
            String[] strs=str.split(":");
            wd.setUnit(strs[0]);
            wd.setReport(strs[1]);
            list.add(wd);
        }
        wifiDataUpDao.save(list);
    }

    @org.jetbrains.annotations.Contract("null -> null")
    private List<WZDataUp_Fb> translate(List<WifiDataUp> list){
        if (list==null||list.size()==0)
            return null;
        List<WZDataUp_Fb> wz = new ArrayList<>();
        for (int i =0;i<list.size()/18;i++){
            WZDataUp_Fb data = new WZDataUp_Fb();
            data.setDate(list.get(i).getTime());
            for (int j=i*18;j<i*18+18;j++){
                if (list.get(j).getUnit().contentEquals("郑州"))data.setZhengzhou(list.get(j).getReport());
                if (list.get(j).getUnit().contentEquals("开封"))data.setKaifeng(list.get(j).getReport());
                if (list.get(j).getUnit().contentEquals("洛阳"))data.setLuoyang(list.get(j).getReport());
                if (list.get(j).getUnit().contentEquals("平顶山"))data.setPingdings(list.get(j).getReport());
                if (list.get(j).getUnit().contentEquals("安阳"))data.setAnyang(list.get(j).getReport());
                if (list.get(j).getUnit().contentEquals("鹤壁"))data.setHebi(list.get(j).getReport());
                if (list.get(j).getUnit().contentEquals("新乡"))data.setXinxiang(list.get(j).getReport());
                if (list.get(j).getUnit().contentEquals("焦作"))data.setJiaozuo(list.get(j).getReport());
                if (list.get(j).getUnit().contentEquals("濮阳"))data.setPuyang(list.get(j).getReport());
                if (list.get(j).getUnit().contentEquals("许昌"))data.setXuchang(list.get(j).getReport());
                if (list.get(j).getUnit().contentEquals("漯河"))data.setLuohe(list.get(j).getReport());
                if (list.get(j).getUnit().contentEquals("三门峡"))data.setSanmenxia(list.get(j).getReport());
                if (list.get(j).getUnit().contentEquals("南阳"))data.setNanyang(list.get(j).getReport());
                if (list.get(j).getUnit().contentEquals("商丘"))data.setShangqiu(list.get(j).getReport());
                if (list.get(j).getUnit().contentEquals("信阳"))data.setXinyang(list.get(j).getReport());
                if (list.get(j).getUnit().contentEquals("周口"))data.setZhoukou(list.get(j).getReport());
                if (list.get(j).getUnit().contentEquals("驻马店"))data.setZhumadian(list.get(j).getReport());
                if (list.get(j).getUnit().contentEquals("济源"))data.setJiyuan(list.get(j).getReport());
            }
            wz.add(data);
        }
        return wz;
    }
}
