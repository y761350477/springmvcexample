<%--
  Created by IntelliJ IDEA.
  User: YC
  Date: 2017/8/16
  Time: 10:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>

    <title>Title</title>
    <script src="../js/jquery-3.2.1.js"></script>
    <script>
        function test() {
            var getInputParam = $("#text").val();
            alert(getInputParam);

            $.ajax({
                url:"../return.php",
                data:{
                    "param": 2
                },
                dateTyep : "text",
                traditional:true,
                type:"post",
                success:function(data){
                    alert(data);
//                    window.location.reload();
                },
                error:function(data){
                    alert("操作失败");
                }
            });
        }

    </script>
</head>
<body>
<input type="text" value="12" id="text"><br/>
<button onclick="test()">Click</button>
</body>
</html>
