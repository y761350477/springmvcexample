<%--
  Created by IntelliJ IDEA.
  User: YC
  Date: 2017/6/18
  Time: 12:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script src="../js/jquery-3.2.1.js"></script>
    <script>
        function test() {
            alert(1);
            var getInput = $("#test1").val();
            alert(getInput);
        }
    </script>
</head>
<body>
    <input type="text" value="12" id="test1">
    <button onclick="test()">Click</button>
    <br/>
    <%--通过post方式提交，获取的中文字符会乱码，get却不会。（乱码可以通过在web.xml中配置filter过滤器解决）--%>
    <form action="/filter" method="post">
        <input type="text" name="name"/>
        <input type="password" name="pwd">
        <input type="submit"/>
    </form>
</body>
</html>
