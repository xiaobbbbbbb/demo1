package com.example.demo.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.text.DateFormat;
import java.util.Date;

@Controller
public class HelloController {
    private static final Logger logger= LoggerFactory.getLogger(HelloController.class);

    @RequestMapping("hello")
    @ResponseBody
    public String hello(){
        return "hello";
    }

    @RequestMapping("index")
    public String index(ModelMap modelMap, HttpServletRequest request){
        modelMap.addAttribute("now", DateFormat.getDateInstance().format(new Date()));
        logger.info("我是控制器日志..");
        return "index";
    }
}
