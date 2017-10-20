package com.yc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;

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

    /*
     * YC_CMT:
     * 2017/10/20
     *
     * 如果后台传到jsp页面的值是一个Integer类型，那么前台拿到的是什么类型呢？
     * 经过传递String的数字值，在jsp可以通过带引号，不带引号都能满足判断条件；
     * 经过传递Integer的值，在jsp可以通过带引号，不带引号都能满足判断条件；
     * 推测传到jsp页面的值都是 字符串；
     */
    @RequestMapping("/testToValue.php")
    public String testToValue(HashMap map) {
        Integer testParam = 123;

        map.put("testParam", testParam);
        return "testParamType";
    }
}
