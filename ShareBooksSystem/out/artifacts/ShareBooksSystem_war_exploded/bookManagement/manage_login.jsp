<%--
  Created by IntelliJ IDEA.
  User: LiuQuanwei
  Date: 2018/6/5
  Time: 15:51
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
    <title>管理员登陆</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://cdn.bootcss.com/bootstrap/4.1.0/css/bootstrap.min.css">
    <link rel="stylesheet" href="css/manage_login.css">
    <script src="https://cdn.bootcss.com/jquery/3.2.1/jquery.min.js"></script>
    <script src="https://cdn.bootcss.com/popper.js/1.12.5/umd/popper.min.js"></script>
    <script src="https://cdn.bootcss.com/bootstrap/4.1.0/js/bootstrap.min.js"></script>
</head>
<body>
    <div class="container">
        <div class="container" id="title">
            <h3 class="display-5">共享图书管理员系统</h3>
        </div>
        <div class="container" id="main">
            <form method="post" action="managerLoginAction" namespace="/bookManagement">
                <div class="form-group">
                    <label for="email">邮箱账号:</label>
                    <input type="email" class="form-control" id="email" name="manager.managerAccount">
                </div>
                <div class="form-group">
                    <label for="password">密码:</label>
                    <input type="password" class="form-control" id="password" name = "manager.managerPassword">
                </div>
                <button type="submit" class="btn btn-primary" id="login">登陆</button>
            </form>
        </div>
    </div>

</body>
</html>
