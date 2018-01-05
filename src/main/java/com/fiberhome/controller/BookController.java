package com.fiberhome.controller;

import com.fiberhome.entity.Book;
import com.fiberhome.mapper.BookDao;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by zyf on 2017/11/24.
 */
@Controller
@RequestMapping("/book")
public class BookController {
//    @Resource
//    private BookDao bookDao;
    @Resource
    private BookDao bookDao;
    @RequestMapping("/find")
    public ModelAndView query(){
        ModelAndView mv =new ModelAndView();
        List<Book> list = bookDao.findByName("sddd","sdsda");
        mv.addObject("books",list);
        for (Book book:list){
            System.out.println(book.toString());
        }
        mv.setViewName("books");
        return mv;
    }
    @RequestMapping("/list")
    public String forward(){
        return "forward:/book/find";
    }
    @RequestMapping("/redirect")
    public String redirect(){
        return "redirect:/book/find";
    }
}
