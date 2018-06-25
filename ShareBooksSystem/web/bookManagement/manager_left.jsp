<%--
  Created by IntelliJ IDEA.
  User: LiuQuanwei
  Date: 2018/6/21
  Time: 21:35
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
    <title>导航栏</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://cdn.bootcss.com/bootstrap/4.1.0/css/bootstrap.min.css">
    <link rel="stylesheet" href="/bookManagement/css/manager_left.css">
    <script src="https://cdn.bootcss.com/jquery/3.2.1/jquery.min.js"></script>
    <script src="https://cdn.bootcss.com/popper.js/1.12.5/umd/popper.min.js"></script>
    <script src="https://cdn.bootcss.com/bootstrap/4.1.0/js/bootstrap.min.js"></script>
</head>
<body>
    <div left>
        <ul>
            <li><a href="manage_main.jsp">主页</a></li>
            <li><a href="queryBook.jsp">管理图书信息</a></li>
            <li><a href="changeManagerPassword.jsp">修改密码</a></li>
            <li><a href="nowUserPage.action">管理用户信息</a></li>
            <li><a href="nowTopFtBPage.action">查看图书借阅排行</a></li>
            <li><a href="nowTopCategoryPage.action">查看同类书籍借阅排行</a></li>
        </ul>
    </div>
</body>
</html>
