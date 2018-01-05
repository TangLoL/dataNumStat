package com.fiberhome.controller;

import com.fiberhome.common.ExcelProcess;
import com.fiberhome.dao.CustomerDao;
import com.fiberhome.entity.Customer;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

@Controller
@RequestMapping("/test")
public class CustomerController {

    @Resource
    private CustomerDao customerDao;

    @Resource
    private ExcelProcess excelProcess;

    @ResponseBody
    @RequestMapping("/list")
    public List<Customer> list(){
        return customerDao.findAll();
    }


    @RequestMapping("/add")
    public String add(){
        Customer customer = new Customer();
        customer.setName("tmc");
        customer.setEmail("1026198058@qq.com");
        customerDao.save(customer);
        return "redirect:/test/list";
    }

    @RequestMapping(value = "/upload",method = RequestMethod.POST)
    @ResponseBody
    public String upload(@RequestParam(value = "file") MultipartFile file, HttpServletRequest request){
        System.out.println("xxxxx");

        Workbook workbook = excelProcess.getWorkBook(file);
        List list = excelProcess.importExcelContent2BeanList(workbook,0,1,Customer.class);

        if(list == null){
            System.out.println("null");
        }else{
            for(Object o : list){
                Customer p = (Customer) o;
                System.out.println(p.toString());
            }
        }
        excelProcess.closeWorkBook(workbook);

//        System.out.println("fileName : " + fileName);
        return "success";
    }
}
