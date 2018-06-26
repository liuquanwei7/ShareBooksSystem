<%--
  Created by IntelliJ IDEA.
  User: LiuQuanwei
  Date: 2018/6/25
  Time: 18:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">

<html>
<head>
    <title>admin主页</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://cdn.bootcss.com/bootstrap/4.1.0/css/bootstrap.min.css">
    <link rel="stylesheet" href="/bookManagement/css/manage_main.css">
    <script src="https://cdn.bootcss.com/jquery/3.2.1/jquery.min.js"></script>
    <script src="https://cdn.bootcss.com/popper.js/1.12.5/umd/popper.min.js"></script>
    <script src="https://cdn.bootcss.com/bootstrap/4.1.0/js/bootstrap.min.js"></script>
</head>
<body>
    <div id="top">
        <jsp:include page="manager_top.jsp" flush="true" />
    </div>
    <div id="all">
        <div id="left">
            <jsp:include page="admin_left.jsp" flush="true" />
        </div>
        <div id="main">
            <div class="container" id="main_title">
                <h3 class="display-5">共享图书管理员系统</h3>
            </div>
            <div class="container" id="queryBook_main">
                截至当前本系统统计:
                <br/>
                <br/>
                <br/>
                <p>用户人数:<s:property value="#session.managerCountOfUser"/></p>
                <p>分享书籍数量:<s:property value="#session.managerCountOfBooks"/></p>
                <p>用户借阅次数:<s:property value="#session.managerCountOfBorrowHistory"/></p>
                <p>用户评论数量:<s:property value="#session.managerCountOfComment"/></p>
                <p>管理员人数:<s:property value="#session.managerCountOfManager"/></p>
                <a class="btn btn-success" href="adminLoginMainPageAction" role="button" id="re">刷新</a>
            </div>
        </div>
    </div>
</body>
</html>
