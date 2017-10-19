<%--
  Created by IntelliJ IDEA.
  User: YC
  Date: 2017/8/11
  Time: 13:34
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
<frameset id="fr" name="fr" rows="63,*,50" cols="*" framespacing="0" frameborder="no" border="0">
    <frame src="<%=basePath %>admin/top.php" name="topFrame" scrolling="no" noresize="noresize" id="topFrame" title="topFrame"/>
    <frameset id="mfr" name="mfr" cols="203,*" framespacing="0" frameborder="no" border="0">
        <frame src="<%=basePath %>admin/left.php" name="leftFrame" id="leftFrame" title="leftFrame"/>
        <frame src="<%=basePath %>admin/workbench.php" name="mainFrame" id="mainFrame" title="mainFrame" />
    </frameset>
    <frame src="<%=basePath %>admin/footer.php" name="footerFrame" scrolling="no" noresize="noresize" id="footerFrame" title="footerFrame"/>
</frameset>
<%--<noframes></noframes>--%>
<body>

</body>
</html>
