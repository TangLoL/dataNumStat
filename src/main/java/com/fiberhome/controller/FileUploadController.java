package com.fiberhome.controller;

import com.fiberhome.common.ExcelProcess;
import com.fiberhome.entity.NodeControlRate;
import com.fiberhome.entity.WZDataUp_Fb;
import com.fiberhome.entity.WifiDataUp;
import com.fiberhome.mapper.NodeControlRateDao;
import com.fiberhome.mapper.WifiDataUpDao;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import javax.servlet.http.HttpServletRequest;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by zyf on 2017/12/8.
 */

@RestController
@RequestMapping("/upload")
public class FileUploadController {
    @Autowired
    ApplicationContext context;
    @Autowired
    NodeControlRateDao ncr;
    @RequestMapping(value = "/file",method = RequestMethod.POST)
    public String uploadFile(@RequestParam(value = "name",required = false) String bean, @RequestParam(value = "file",required = true) MultipartFile file){
        if(file!=null){
            ExcelProcess ep=null;
            Workbook workbook=null;
            try {
                ep = new ExcelProcess();
                workbook = ep.getWorkBook(file);
                List<NodeControlRate> save;

                String filename=file.getOriginalFilename();
                filename=filename.substring(0,filename.lastIndexOf("."));
                System.out.println(filename);
                String time=filename.substring(filename.length()-10,filename.length());
                List list =ncr.getData(time);
                if (list!=null&& list.size()!=0){
                    return "当天数据已经存在";
                }
//                String time = "2017-12-17";
                System.out.println(time);
                save = ep.importExcelContent2BeanList(workbook,0,4,NodeControlRate.class,time);
                ep.closeWorkBook(workbook);
                file=null;
//                    List<NodeControlRate> save =new ArrayList<>();
//                    for (Object obj:l)
//                        save.add((NodeControlRate)obj);
                System.out.println(save+"-------");
                ncr.save(save);

                return "上传成功";
            } catch (Exception e) {
                ep.closeWorkBook(workbook);
                e.printStackTrace();
                file=null;
                return "上传失败";
            }
        }
        return "上传失败";
    }

}
