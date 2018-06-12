<%--
  Created by IntelliJ IDEA.
  User: Standard_lang
  Date: 2018/6/11
  Time: 18:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>ensureBookSuccess</title>
    <script type="text/javascript">
        window.ready=function () {
            shareCode=sessionStorage.shareCode;
            document.getElementById("showCode").value=shareCode;
        }
    </script>
</head>
<body>
<h3>添加图书成功！！！</h3>
<p id="showCode"></p>
</body>
</html>
