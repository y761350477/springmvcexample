package com.yc.upload;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;

/**
 * Created by Administrator on 2017/5/26 0026.
 */
@Controller

public class Demo {
    /**注意：文件如果大小为0字节，会导致上传失败的！
     * 单文件上传
     * @param fileSubmit
     * @param session
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/upload.do", method = RequestMethod.POST)
    // 这里的MultipartFile对象变量名跟表单中的file类型的input标签的name相同，所以框架会自动用MultipartFile对象来接收上传过来的文件，当然也可以使用@RequestParam("img")指定其对应的参数名称
    public String upload(MultipartFile fileSubmit, HttpSession session)
            throws Exception {
        // 如果没有文件上传，MultipartFile也不会为null，可以通过调用getSize()方法获取文件的大小来判断是否有上传文件
        if (fileSubmit.getSize() > 0) {
            // 得到项目在服务器的真实根路径，如：/home/tomcat/webapp/项目名/images
            String path = session.getServletContext().getRealPath("");
            // 得到文件的原始名称，如：美女.png
            String fileName = fileSubmit.getOriginalFilename();
            System.out.println(fileName);
            // 通过文件的原始名称，可以对上传文件类型做限制，如：只能上传jpg和png的图片文件
            if (fileName.endsWith("jpg") || fileName.endsWith("png")) {
                File file = new File(path, fileName);
                fileSubmit.transferTo(file);
                return "success";
            }
        }
        return "error";
    }

    /**
     * 多文件上传
     * @param imgs
     * @param session
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/uploadPlus.do", method = RequestMethod.POST)
    // 这里的MultipartFile[] imgs表示前端页面上传过来的多个文件，imgs对应页面中多个file类型的input标签的name
    public String uploadPlus(MultipartFile[] imgs, HttpSession session)
            throws Exception {
        for (MultipartFile img : imgs) {
            if (img.getSize() > 0) {
                String path = session.getServletContext().getRealPath("");
                String fileName = img.getOriginalFilename();
                if (fileName.endsWith("jpg") || fileName.endsWith("png")) {
                    File file = new File(path, fileName);
                    img.transferTo(file);
                }
            }
        }
        return "success";
    }

    @RequestMapping(value="/uploadPro.do",method= RequestMethod.POST)
    public String uploadPro(MultipartFile[] imgs1, MultipartFile[] imgs2, MultipartFile[] imgs3, HttpSession session)
            throws Exception {
        String path = session.getServletContext().getRealPath("");
        for (MultipartFile img : imgs1) {
            uploadFile(path, img);
        }
        for (MultipartFile img : imgs2) {
            uploadFile(path, img);
        }
        for (MultipartFile img : imgs3) {
            uploadFile(path, img);
        }
        return "success";
    }
    private void uploadFile(String path, MultipartFile img) throws IOException {
        if (img.getSize() > 0) {
            String fileName = img.getOriginalFilename();
            if (fileName.endsWith("jpg") || fileName.endsWith("png")) {
                File file = new File(path, fileName);
                img.transferTo(file);
            }
        }
    }
}
