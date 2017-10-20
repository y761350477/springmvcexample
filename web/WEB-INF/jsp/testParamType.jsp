<%--
  Created by IntelliJ IDEA.
  User: YC
  Date: 2017/10/20
  Time: 15:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
${testParam}
<c:if test="${testParam == '123'}">测试</c:if>
</body>
</html>
