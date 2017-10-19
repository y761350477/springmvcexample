<%--
  Created by IntelliJ IDEA.
  User: YC
  Date: 2017/8/14
  Time: 18:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Title</title>
    <script src="../js/jquery-3.2.1.js"></script>
    <script>
        function deletes(){
            var getInput = $("#t1").val();
            alert(getInput);
            //获取所有选中项
        }

    </script>
</head>
<body>
<input type="checkbox" value="1" name='cb'/>

<button onclick="deletes()">Click</button>
<input type="text" id="t1" value="1">
</body>
</html>
