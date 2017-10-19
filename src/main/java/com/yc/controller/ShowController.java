package com.yc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by YC on 2017/6/18.
 */
@Controller
public class ShowController {

    //通过ModelAndView的方式返回数据
    @RequestMapping("/login")
    public ModelAndView login(){
        ModelAndView modelAndView = new ModelAndView("Login");//传入跳转的jsp文件名，或者不传值，打开注释信息
        modelAndView.addObject("msg", "nihs");
//        modelAndView.setViewName("Login");
        return modelAndView;
    }

    //在地址栏输入信息是不区分位置先后的，都能获取值，如果没有设置就为null
    @RequestMapping("/test")
    public String login2(HttpServletResponse response){
        try {
            PrintWriter printWriter = response.getWriter();
//            printWriter.write("my name is 'YangChen'");
            printWriter.write("<h1>md</h1>");
            System.out.println("dadada");
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("测试返回了响应页面之后还会不会执行这段代码？");
        return "Test";
    }

    //上面的情况如果遇到不想让地址栏的属性名和设置的变量名一致的处理方式
    @RequestMapping("/test_")
    public String login2_(@RequestParam("name") String n, ModelMap modelMap) {
        System.out.println(n);
        //传递数据到jsp页面的方法，需要设置ModelMap，jsp页面用${hello}接收
        modelMap.addAttribute("hello", n);
        return "Test";
    }

    //设置跳转重定向，跳到("/login")的页面
    @RequestMapping("/test3")
    public String login4(HttpServletRequest request, HttpSession session){
        request.setAttribute("a","request");
        session.setAttribute("b","session");
//        return "Msg";
//        return "redirect:test1";//重定向不携带数据
        return "forward:test4";//转发可以携带数据
    }

    @RequestMapping("/test4")
    public String login5(HttpServletRequest request, HttpSession session){
        System.out.println(request.getAttribute("a"));
        System.out.println(session.getAttribute("b"));
        return "Test";
    }

    //指定接收的方式设置
    @RequestMapping(value = "/test5",method = RequestMethod.GET)
    public String login6(){
        return "Test";
    }

    @RequestMapping("/login3/?")
    public String login7(){
        return "Test";
    }

    @RequestMapping("/login2/*")
    public String login8(){
        return "Test";
    }

    @RequestMapping("/delete")
    @ResponseBody
    public String delete(int stunos){
        int rs = stunos;
        System.out.println(rs);
        if(rs>0){
            return "true";
        }else{
            return "false";
        }
    }

}
