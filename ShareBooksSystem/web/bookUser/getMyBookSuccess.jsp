<%@ taglib prefix="s" uri="/struts-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: 10537
  Date: 2018/6/22
  Time: 18:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>GetMyBookSuccess</title>
</head>
<body>
<s:include value="newNav.jsp"/>
<p style="margin: 0 auto;width: 500px;height: 100px;text-align: center;font-size: 20px;">
    加入购物车成功！！！
申请索回书籍成功！！
<br>
请持索回码找操作员拿回个人书籍
<br>
索回码：<%=session.getAttribute("getBookCode") %>
</p>
</body>
</html>
