package com.fiberhome.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by zyf on 2017/11/24.
 */

@Controller
@RequestMapping("/mvc")
public class springmvc {

    @RequestMapping("/say")
    public ModelAndView say(){
        ModelAndView mv = new ModelAndView();
        mv.addObject("info","who you are");
        mv.setViewName("mvc1");
        return mv;
    }

}
