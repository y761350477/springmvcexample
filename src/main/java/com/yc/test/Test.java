package com.yc.test;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@Controller
public class Test {
    /*
     * YC_CMT:
     * 2017/10/19
     *
     * 使用@RequestParam("jsp页面属性name值") Object object
     * 优点：可以在后台通过使用object来替换使用name，进行数据的使用
     * 缺点：必须和jsp页面的属性值绑定，如果jsp中没有相应的name值，则会bad错误
     */
    @RequestMapping("/test.php")
    public void test(@RequestParam("user") String na, @RequestParam("pass") String  ps, HttpServletRequest request, HttpServletResponse response) {
        System.out.println(na);
        System.out.println(ps);
        try {
            PrintWriter writer = response.getWriter();
            writer.write("HelloWorld!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
