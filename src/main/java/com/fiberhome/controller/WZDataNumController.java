package com.fiberhome.controller;

import com.fiberhome.entity.WZDataNum_Fb;
import com.fiberhome.service.WZDataNumService;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.ServletContext;
import java.util.List;

@Controller
@RequestMapping("/wzdatasum")
public class WZDataNumController {
    Logger logger = Logger.getLogger(WZDataNumService.class);


    @Resource
    private WZDataNumService wzDataNumService;

    /**
     * 按天获取WZ汇聚数据情况统计
     * @param day
     * @return
     */
    @ResponseBody
    @RequestMapping("/getQuery")
    public List<WZDataNum_Fb> getWZDataSum(@RequestParam(value = "day" ,required = false) Integer day){
        System.out.println(day);
        if(day == null || "".equals(day)){
            day = 10;
        }
        logger.info("请求的天数为 : " + day);
        return wzDataNumService.getQueryData(day);
    }
}
