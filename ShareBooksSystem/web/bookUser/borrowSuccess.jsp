<%--
  Created by IntelliJ IDEA.
  User: 10537
  Date: 2018/6/19
  Time: 18:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>borrowSuccess</title>
    <%--<script type="text/javascript">--%>
        <%--window.onload=function ( ){--%>
            <%--borrowCode=sessionStorage.borrowCode;--%>
            <%--console.log(shareCode);--%>
            <%--document.getElementById("borrowCode").innerText="您的分享码为："+borrowCode;--%>
        <%--}--%>
    <%--</script>--%>
</head>
<body>
<h3>请求借阅图书成功！！！</h3>
<p id="borrowCode"><%=session.getAttribute("borrowCode")%></p>
<p>请持借阅码找操作员分享您的图书。</p>
</body>
</html>
