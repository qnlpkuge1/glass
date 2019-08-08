package com.goosun.glass.controller;

import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AppController {


    @GetMapping("/app")
    public ModelAndView app(@RequestParam(value = "udid",required = false) String udid) {

        ModelAndView mv = new ModelAndView();
        mv.setViewName("app.html");

        if(!StringUtils.isEmpty(udid)){
            mv.addObject("udid",udid);
        }
        return mv;
    }
}
