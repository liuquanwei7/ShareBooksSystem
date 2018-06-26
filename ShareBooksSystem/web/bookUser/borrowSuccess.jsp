<%@ taglib prefix="s" uri="/struts-tags" %>
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
<s:include value="newNav.jsp"/>
<div style="margin: 0 auto;width: 500px;height: 100px;text-align: center;font-size: 20px;margin-top: 30px;">
    <%--加入购物车成功！！！--%>
<h3>请求借阅图书成功！！！</h3>
<p id="borrowCode"><%=session.getAttribute("borrowCode")%></p>
<p>请持借阅码找操作员借阅图书。</p>
</div>
</body>
</html>
