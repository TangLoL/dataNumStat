package com.fiberhome.controller;

import com.fiberhome.entity.NodeControlRate;
import com.fiberhome.mapper.NodeControlRateDao;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by zyf on 2017/12/8.
 */
@RestController
@RequestMapping("/NodeControlRate")
public class NodeControlRateController {
    @Resource
    private NodeControlRateDao nodeControlRateDao;

//    @RequestMapping("/save")
//    public String saveData(){
//
//        return "success";
//    }

    /**
     * 给时间参数，返回给定时间的数据，否则给最近时间的数据
     * @param time
     * @return
     */
    @RequestMapping("/getCurrentData")
    public List<NodeControlRate> getCurrentData(@RequestParam(value = "time",required = false) String time){
        if (time==null) {
            List<NodeControlRate> list = nodeControlRateDao.getRecentData();
            return list;
        }
        else {
            List<NodeControlRate> list= nodeControlRateDao.getData(time);
            return list;
        }
    }

}
