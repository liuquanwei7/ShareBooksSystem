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
    <link rel="stylesheet" href="/bookManagement/css/manage_login.css">
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
            <div>
                <form method="post" action="managerLoginAction" namespace="/bookManagement" autocomplete="off">

                    <div class="form-group">
                        <label for="email">邮箱账号:</label>
                        <div id="managerAccount">
                            <input type="email" class="form-control" id="email" name="manager.managerAccount">
                            &nbsp&nbsp<span class="text-danger" id="managerLoginAccountError"><s:property value="#session.managerLoginAccountError"/></span>
                        </div>
                    </div>


                    <div class="form-group">
                        <label for="password">密码:</label>
                        <div id="managerPassword">
                            <input type="password" class="form-control" id="password" name = "manager.managerPassword">
                            &nbsp&nbsp<span class="text-danger" id="managerLoginPasswordError"><s:property value="#session.managerLoginPasswordError"/></span>
                        </div>

                    </div>
                    <div class="form-inline" id="managerPosition">
                        <div class="radio">
                            <label>
                                <input type="radio" name="manager.managerPermission" id="manager" value=0 checked>管理员
                            </label>
                        </div>
                        &nbsp;&nbsp;
                        <div class="radio">
                            <label>
                                <input type="radio" name="manager.managerPermission" id="operator" value=1 >操作员
                            </label>
                        </div>
                        &nbsp;&nbsp;&nbsp;
                        <div class="radio">
                            <label>
                                <input type="radio" name="manager.managerPermission" id="admin" value=2 >admin
                            </label>
                        </div>
                    </div>
                    &nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp<span class="text-danger"><s:property value="#session.managerLoginNoAccountError"/></span>
                    <br/>
                    <div class="form-inline" id="button2">
                        <button type="reset" class="btn btn-primary" id="reset">重置</button>
                        <button type="submit" class="btn btn-primary" id="login">登录</button>
                    </div>
                    <% session.removeAttribute("managerLoginAccountError"); %>
                    <% session.removeAttribute("managerLoginPasswordError"); %>
                    <% session.removeAttribute("managerLoginNoAccountError"); %>
                </form>
            </div>

        </div>
    </div>
</body>
</html>
