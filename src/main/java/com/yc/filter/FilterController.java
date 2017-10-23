package com.yc.filter;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by YC on 2017/6/22.
 */
@Controller
public class FilterController {
    @RequestMapping("/filter.php")
    public String ShowFilter(String name,String pwd) {
        System.out.println(name);
        System.out.println(pwd);
        System.out.println("Filter显示");
        return "Msg";
    }
    @RequestMapping("/test/filter.php")
    public String ShowFilter1(String name,String pwd) {
        System.out.println(name);
        System.out.println(pwd);
        System.out.println("Filter显示");
        return "Msg";
    }
    @RequestMapping("/test/testFilter.php")
    public String ShowFilter2(String name,String pwd) {
        System.out.println(name);
        System.out.println(pwd);
        System.out.println("Filter显示");
        return "Msg";
    }

    @RequestMapping("/test.form")
    public String test(String name,String pwd) {
        System.out.println(name);
        System.out.println(pwd);
        System.out.println("Test显示");
        return "Msg";
    }

    @RequestMapping("/FirstPage.form")
    public String show() {
        return "OnePage";
    }

}
