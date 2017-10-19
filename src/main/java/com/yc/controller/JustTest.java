package com.yc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by YC on 2017/8/11.
 */
@Controller
public class JustTest {
    @RequestMapping("/JustTest.php")
    public String justDefault() {
        System.out.println("sayHello");
        return "default";
    }

    @RequestMapping("/Test1.php")
    public void test1() {
        System.out.println("测试打印几次！");
    }

    @RequestMapping("/admin/left.php")
    public String left() {
        System.out.println("sayHello");
        return "left";
    }

    @RequestMapping("/admin/workbench.php")
    public String workbench() {
        System.out.println("sayHello");
        return "workbench";
    }

    @RequestMapping("/admin/footer.php")
    public String footer() {
        System.out.println("sayHello");
        return "footer";
    }

    @RequestMapping("/admin/top.php")
    public String top() {
        System.out.println("sayHello");
        return "top";
    }

    @RequestMapping("/a.php")
    public String a() {
        System.out.println("sayHello");
        return "A";
    }

    @RequestMapping("/b.php")
    public String b() {
        System.out.println("sayHello");
        return "B";
    }
}
