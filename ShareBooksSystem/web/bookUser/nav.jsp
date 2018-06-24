<%--
  Created by IntelliJ IDEA.
  User: 10537
  Date: 2018/6/23
  Time: 15:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>nav</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <%--<link rel="stylesheet" href="https://cdn.bootcss.com/bootstrap/4.1.0/css/bootstrap.min.css">--%>
    <link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">
    <link rel="stylesheet" href="/bookUi/css/fixed.css" />
    <link rel="stylesheet" href="/bookUi/css/UserInfor.css"/>
    <link rel="stylesheet" href="/bookUi/css/home.css">
    <script src="/bookUi/js/homepage.js"></script>
</head>
<body>
<div id="naver">

    <img src="/bookUi/img/logo.png"/>
    <div id="logo_text"><span>&nbsp;HIMB</span></div>
    <ul id="flex_naver">
        <li class="nr" onmouseover="nrselect(this)" onmouseleave="nrleave(this)"><a href="aheadhome.jsp">主页</a></li>
        <li class="nr" onmouseover="nrselect(this)" onmouseleave="nrleave(this)"><a href="ChangePerson.jsp">管理个人信息</a></li>
        <li class="nr" onmouseover="nrselect(this)" onmouseleave="nrleave(this)"><a href="borrows.jsp">查看已借书籍</a></li>
        <li class="nr" onmouseover="nrselect(this)" onmouseleave="nrleave(this)"><a  href="checkBooks.jsp">查询书籍</a></li>
    </ul>
</div>
</body>
</html>
