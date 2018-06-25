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
    <%--<link rel="stylesheet" href="/bookUi/css/UserInfor.css"/>--%>
    <%--<link rel="stylesheet" href="/bookUi/css/home.css">--%>
    <link rel="stylesheet" href="css/nav.css">
    <%--<link href="css/bootstrap.min.css" rel="stylesheet">--%>
    <link rel="stylesheet" href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <link rel="stylesheet" href="/bookUi/css/fixed.css" />
    <script src="https://cdn.bootcss.com/jquery/3.2.1/jquery.min.js"></script>

    <script src="js/jquery-3.3.1.min.js"></script>
    <%--<!-- Include all compiled plugins (below), or include individual files as needed -->--%>

    <script src="https://cdn.bootcss.com/popper.js/1.12.5/umd/popper.min.js"></script>
    <%--<script src="js/bootstrap.min.js"></script>--%>
    <script src="https://cdn.bootcss.com/bootstrap/4.1.0/js/bootstrap.min.js"></script>

    <%--<script src="https://cdn.bootcss.com/jquery/2.1.1/jquery.min.js"></script>--%>
    <%--<script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>--%>
    <script src="/bookUi/js/homepage.js"></script>
</head>
<body>
<div id="naver" >

    <img src="/bookUi/img/logo.png"/>
    <div id="logo_text"><a href="../bookUi/aheadhome.jsp"><span>&nbsp;HIMB</span></a></div>
    <ul id="flex_naver" class="navbar-nav ">
        <li id="serch_nav">
            <form class="form-inline my-2 my-lg-0 nav_form" action="getCheckBookAction" method="post">
                <input class="form-control mr-sm-2 nav_ss" type="search" placeholder="书名/作者"
                       aria-label="Search" name="check_data">
                <button  class="nav_ss "  type="submit">
                    <%--<img  src="image/nav_serch.png" style="width:20px; height:20px;">--%>
                    <%--</img>--%>
                </button>
            </form>
        </li>
        <li class="nr dropdown"  onmouseover="nrselect(this)"  onmouseleave="nrleave(this)">
            <a class="dropdown-toggle" href="#" data-toggle="dropdown"><span>图书</span>
            <%--<img  style="width: 10px;height: 10px" src="image/bot_logo.png" />--%>
        </a>
            <ul  class="dropdown-menu " role="menu">
                <li><a href="../bookUi/borrows.jsp">已借图书</a></li>
                <li class="divider"></li>
                <li><a href="showMyBookAction">个人图书</a></li>
                <li class="divider"></li>
                <li><a class="btn-group" href="addBook.jsp">添加图书</a></li>
            </ul>
        </li>
        <li class="nr dropdown" onmouseover="nrselect(this)"  data-toggle="dropdown" onmouseleave="nrleave(this)">
            <a class="dropdown-toggle" href="#" data-toggle="dropdown">个人信息
            <%--<img  style="width: 10px;height: 10px" src="image/bot_logo.png" />--%>
        </a>
            <ul class="dropdown-menu">
                <li><a href="../bookUi/UserInfor.jsp">个人中心</a></li>
                <li class="divider"></li>

                <li><a href="../bookUi/ChangePerson.jsp">管理信息</a></li>
            </ul>
        </li>
        <li class="nr" onmouseover="nrselect(this)" onmouseleave="nrleave(this)">
            <a href="">借阅车</a>
        </li>
    </ul>
</div>
</body>
</html>











<%--
  Created by IntelliJ IDEA.
  User: 10537
  Date: 2018/6/23
  Time: 15:42
  To change this template use File | Settings | File Templates.
--%>
<%--<%@ page contentType="text/html;charset=UTF-8" language="java" %>--%>
<%--<html>--%>
<%--<head>--%>
    <%--<title>nav</title>--%>
    <%--<meta charset="utf-8">--%>
    <%--<meta name="viewport" content="width=device-width, initial-scale=1">--%>
    <%--&lt;%&ndash;<link rel="stylesheet" href="https://cdn.bootcss.com/bootstrap/4.1.0/css/bootstrap.min.css">&ndash;%&gt;--%>
    <%--&lt;%&ndash;<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">&ndash;%&gt;--%>
    <%--<link href="css/bootstrap.min.css" rel="stylesheet">--%>
    <%--<script src="js/jquery-3.3.1.min.js"></script>--%>
    <%--<!-- Include all compiled plugins (below), or include individual files as needed -->--%>
    <%--<script src="js/bootstrap.min.js"></script>--%>
    <%--<link rel="stylesheet" href="/bookUi/css/fixed.css" />--%>
    <%--<link rel="stylesheet" href="/bookUi/css/UserInfor.css"/>--%>
    <%--<link rel="stylesheet" href="/bookUi/css/home.css">--%>
    <%--<script src="/bookUi/js/homepage.js"></script>--%>
<%--</head>--%>
<%--<body>--%>
<%--<div id="naver">--%>

    <%--<img src="/bookUi/img/logo.png"/>--%>
    <%--<div id="logo_text"><span>&nbsp;HIMB</span></div>--%>
    <%--<ul id="flex_naver" class="navbar-nav ">--%>
        <%--<li class="nr" onmouseover="nrselect(this)" onmouseleave="nrleave(this)"><a href="aheadhome.jsp">主页</a></li>--%>
        <%--<li class="nr" onmouseover="nrselect(this)" onmouseleave="nrleave(this)"><a href="ChangePerson.jsp">管理个人信息</a></li>--%>
        <%--<li class="nr" onmouseover="nrselect(this)" onmouseleave="nrleave(this)"><a href="borrows.jsp">查看已借书籍</a></li>--%>
        <%--<li class="nr" onmouseover="nrselect(this)" onmouseleave="nrleave(this)"><a  href="checkBooks.jsp">查询书籍</a></li>--%>
        <%--<li class="nav-item dropdown">--%>
            <%--<a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">--%>
                <%--Dropdown--%>
            <%--</a>--%>
            <%--<div class="dropdown-menu" aria-labelledby="navbarDropdown">--%>
                <%--<a class="dropdown-item" href="#">Action</a>--%>
                <%--<a class="dropdown-item" href="#">Another action</a>--%>
                <%--<div class="dropdown-divider"></div>--%>
                <%--<a class="dropdown-item" href="#">Something else here</a>--%>
            <%--</div>--%>
        <%--</li>--%>
    <%--</ul>--%>
<%--</div>--%>
<%--</body>--%>
<%--</html>--%>
