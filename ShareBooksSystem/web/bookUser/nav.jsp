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
    <%--<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">--%>
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <script src="js/jquery-3.3.1.min.js"></script>
    <!-- Include all compiled plugins (below), or include individual files as needed -->
    <script src="js/bootstrap.min.js"></script>
    <link rel="stylesheet" href="/bookUi/css/fixed.css" />
    <link rel="stylesheet" href="/bookUi/css/UserInfor.css"/>
    <link rel="stylesheet" href="/bookUi/css/home.css">
    <script src="/bookUi/js/homepage.js"></script>
</head>
<body>
<div id="naver">

    <img src="/bookUi/img/logo.png"/>
    <div id="logo_text"><span>&nbsp;HIMB</span></div>
    <ul id="flex_naver" class="navbar-nav ">
        <li class="nr" onmouseover="nrselect(this)" onmouseleave="nrleave(this)"><a href="aheadhome.jsp">主页</a></li>
        <li class="nr" onmouseover="nrselect(this)" onmouseleave="nrleave(this)"><a href="ChangePerson.jsp">管理个人信息</a></li>
        <li class="nr" onmouseover="nrselect(this)" onmouseleave="nrleave(this)"><a href="borrows.jsp">查看已借书籍</a></li>
        <li class="nr" onmouseover="nrselect(this)" onmouseleave="nrleave(this)"><a  href="checkBooks.jsp">查询书籍</a></li>
        <li class="nav-item dropdown">
            <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                Dropdown
            </a>
            <div class="dropdown-menu" aria-labelledby="navbarDropdown">
                <a class="dropdown-item" href="#">Action</a>
                <a class="dropdown-item" href="#">Another action</a>
                <div class="dropdown-divider"></div>
                <a class="dropdown-item" href="#">Something else here</a>
            </div>
        </li>
    </ul>
</div>
</body>
</html>
