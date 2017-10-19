package com.yc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletResponse;

@Controller
public class TestReturn {
    @RequestMapping("/return.php")
    public String sayHello(@RequestParam("param") int param, HttpServletResponse httpServletResponse) {
        System.out.println(param);
        if (param > 0) {
            return "true";
        } else {
            return "false";
        }
    }
}
