package com.fiberhome.controller;

import com.fiberhome.common.ExcelProcess;
import com.fiberhome.entity.WZDataIn;
import com.fiberhome.service.WZDataInService;
import org.apache.log4j.Logger;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/wzdatain")
public class WZDataInController {

    Logger logger = Logger.getLogger(WZDataInController.class);

    @Resource
    private ExcelProcess excelProcess;
    @Resource
    private WZDataInService WZDataInService;

    /**
     * 上传WZ接入情况统计表
     * @param file
     * @param time
     * @return
     */
    @RequestMapping(value = "/upload")
    public String upload(@RequestParam(value = "file") MultipartFile file, @RequestParam(value = "time",required = false) String time){
//        String realPath = request.getSession().getServletContext().getRealPath("/");
//        logger.info("本工程的资源目录为" + realPath);
        System.out.println("/");
        if (time==null){
            String filename=file.getOriginalFilename();
            filename=filename.substring(0,filename.lastIndexOf("."));
            System.out.println(filename);
            time=filename.substring(filename.length()-10,filename.length());
        }
        if (WZDataInService.getDataByTime(time)!=null && WZDataInService.getDataByTime(time).size()!=0){
            return "this date already exist";
        }
//        time="2017-12-18";
        Workbook workbook = excelProcess.getWorkBook(file);
        List<WZDataIn> list = excelProcess.importExcelContent2BeanList(workbook,0,4,WZDataIn.class,time);
        excelProcess.closeWorkBook(workbook);
        Boolean b = WZDataInService.saveList(list);
        logger.info("wzdatain upload ---");
        return b.toString();
    }

    /**
     * 获取所有WZ接入数据
     * @param time
//     * @param request
     * @return
     */

    @ResponseBody
    @RequestMapping(value = "/showlist")
    public List<WZDataIn> showList(@RequestParam(value = "time" ,required = false) String time ){
        if(time == null || "".equals(time)){
            SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
            time = sf.format(new Date());
        }
        System.out.println(time);
//        String realPath = request.getSession().getServletContext().getRealPath("/");
//        logger.info("本工程的资源目录为" + realPath);
        return WZDataInService.getLatestListByTime(time);
    }

}
