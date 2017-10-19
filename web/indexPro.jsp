<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/7/4 0004
  Time: 下午 5:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="uploadPro.do" method="post" enctype="multipart/form-data">

    一次选择多个文件的多文件上传 : <br />
    <input type="file" name="imgs1" multiple><br /> <br />

    一次选择一个文件的多文件上传 : <br />
    <input type="file" name="imgs2"><br />
    <input type="file" name="imgs2"><br /><br />

    单文件上传 : <br />
    <input type="file" name="imgs3"><br /><br />
    <input type="submit" name="提交">
</form>
</body>
</html>
