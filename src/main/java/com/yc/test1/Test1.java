package com.yc.test1;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller
public class Test1 {
    @RequestMapping("/NewTest1.php")
    public String Test1(Map<String, Object> map) {
        List<String> strLists = new ArrayList<String>();
        strLists.add("A");
        strLists.add("B");
        strLists.add("C");
        strLists.add("D");
        map.put("strLists",strLists);
        return "NewTest1";
    }

    @RequestMapping("/NewTest2.php")
    public String Test2(ModelMap modelMap) {
        List<String> strLists = new ArrayList<String>();
        strLists.add("A");
        strLists.add("B");
        strLists.add("C");
        strLists.add("D");
        modelMap.put("strLists",strLists);
        return "NewTest2";
    }

    @RequestMapping("/NewTest3.php")
    public void Test4(HttpServletResponse httpServletResponse) {

        PrintWriter printWriter = null;
        try {
            printWriter = httpServletResponse.getWriter();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            printWriter.close();
        }
    }
}
