package com.yc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Map;

/**
 * Created by YC on 2017/6/18.
 */
@Controller
@RequestMapping(value="/annex")//表明下面的所有的路径都要加上这个路径
public class ShowController {

    //user的属性值，可以通过自主设置，或者是通过地址栏赋值,优先级是主动设置的优于地址栏赋值的
    @RequestMapping("/hello")
    public String sayHello(ModelMap modelMap, User user, @RequestParam("name")String name){
        user.setAge(17);
        user.setName("YangChen");
        modelMap.addAttribute("hello", "Hello World!");
        modelMap.addAttribute("_user",user);
        return "Msg";
    }

    //通过ModelAndView的方式返回数据
    @RequestMapping("/login")
    public ModelAndView login(){
        ModelAndView modelAndView = new ModelAndView("Login");//传入跳转的jsp文件名，或者不传值，打开注释信息
        modelAndView.addObject("msg", "nihs");
//        modelAndView.setViewName("Login");
        return modelAndView;
    }

    //参数Map<String,String> hm和ModelMap mm是一样可以传值的，如果传入的名字一样的情况下，ModelMap的优先级大于Map；
    @RequestMapping("testMap")
    public String testMapAndModelMap(Map<String,String> map, ModelMap mm){
        map.put("test1", "testValue1");
        map.put("test2", "testValue2");
        mm.addAttribute("test1", "testValue1");
        mm.addAttribute("test2", "testValue2");
        return "Msg";
    }

    //在地址栏输入信息是不区分位置先后的，都能获取值，如果没有设置就为null
    @RequestMapping("/test")
    public String login2(String name,int age,String sex){
        System.out.println(name);
        System.out.println(age);
        System.out.println(sex);
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


    //传入对象，可以通过在地址栏直接拼接属性的名字进行赋值
    //比如：http://localhost:8080/test1?name=1&age=2，便可以获取User的属性值
    @RequestMapping("/test1")
    public String login3(User user){
        System.out.println("年龄："+user.getAge());
        System.out.println("名字："+user.getName());
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
