<%--
  Created by IntelliJ IDEA.
  User: LiuQuanwei
  Date: 2018/6/21
  Time: 11:10
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
    <title>管理员注册</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://cdn.bootcss.com/bootstrap/4.1.0/css/bootstrap.min.css">
    <link rel="stylesheet" href="/bookManagement/css/manager_register.css">
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
        <div class="container" id="registerTitle">
            <h3 class="display-5">注册管理员账号</h3>
        </div>
        <div id="mainContent">
            <form method="post" action="managerRegisterAction" namespace="/bookManagement">
                <div class="form-inline">
                    <label for="managerAccount">邮箱账号:</label>&nbsp&nbsp
                    <input type="email" class="form-control" id="managerAccount" name="manager.managerAccount" placeholder="请输入账号">
                </div>
                <br/>
                <span class="text-danger queryError"><s:property value="#session.managerRegisterAccountError"/></span>
                <div class="form-inline">
                    <label for="managerPassword">密码:</label>&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp
                    <input type="password" class="form-control" id="managerPassword" name="manager.managerPassword" placeholder="请输入密码">
                </div>
                <br/>
                <span class="text-danger queryError"><s:property value="#session.managerRegisterPasswordError"/></span>
                <div class="form-inline">
                    <label for="managerPasswordCon">确认密码:</label>&nbsp&nbsp
                    <input type="password" class="form-control" id="managerPasswordCon" name="managerPasswordCon" placeholder="请输入确认密码">
                </div>
                <br/>
                <span class="text-danger queryError"><s:property value="#session.managerRegisterPasswordConError"/></span>
                <div class="form-inline">
                    <label for="managerName">姓名:</label>&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp
                    <input type="text" class="form-control" id="managerName" name="manager.managerName">
                </div>
                <br/>
                <span class="text-danger queryError"><s:property value="#session.managerRegisterNameError"/></span>
                <div class="form-inline">
                    <label for="managerAge">年龄:</label>&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp
                    <input type="number" class="form-control" id="managerAge" name="manager.managerAge">
                </div>
                <br/>
                <span class="text-danger queryError"><s:property value="#session.managerRegisterAgeError"/></span>
                <div class="form-inline" id="gender">
                    <label>性别:</label>
                    <div class="radio">
                        <label>
                            <input type="radio" name="manager.managerGender" id="male" value="男" checked>男
                        </label>
                    </div>
                    <div class="radio">
                        <label>
                            <input type="radio" name="manager.managerGender" id="female" value="女">女
                        </label>
                    </div>
                </div>

                <div class="form-inline" id="mPosition">
                    <label>职位:</label>
                    <div class="radio">
                        <label>
                            <input type="radio" name="manager.managerPermission" id="manager" value=0 checked>管理员
                        </label>
                    </div>
                    <div class="radio">
                        <label>
                            <input type="radio" name="manager.managerPermission" id="operator" value=1>操作员
                        </label>
                    </div>
                </div>
                <div id="registerButton" class="form-inline">
                    <button type="reset" class="btn btn-primary" id="reset">重置</button>
                    <button type="submit" class="btn btn-primary" id="register">注册</button>
                </div>
            </form>
        </div>
    </div>
</div>
    <% session.removeAttribute("managerRegisterAccountError"); %>
    <% session.removeAttribute("managerRegisterPasswordError"); %>
    <% session.removeAttribute("managerRegisterPasswordConError"); %>
    <% session.removeAttribute("managerRegisterNameError"); %>
    <% session.removeAttribute("managerRegisterAgeError"); %>
</body>
</html>
