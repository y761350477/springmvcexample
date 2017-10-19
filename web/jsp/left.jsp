<%--
  Created by IntelliJ IDEA.
  User: YC
  Date: 2017/8/11
  Time: 13:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
            + path + "/";
%>
<html>
<head>
    <title>Title</title>
</head>
<body>
    JustLeft.jsp<br/>
    <ul class="sub">
        <li><a class="" href="<%=basePath %>a.php" target="mainFrame"><span class="sub-menu-text">新建案件</span></a></li>
        <li><a class="" href="<%=basePath %>b.php" target="mainFrame"><span class="sub-menu-text">案件列表</span></a></li>
    </ul>
</body>
</html>
