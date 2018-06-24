<%--
  Created by IntelliJ IDEA.
  User: LiuQuanwei
  Date: 2018/6/23
  Time: 14:50
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
    <title>修改管理员密码</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://cdn.bootcss.com/bootstrap/4.1.0/css/bootstrap.min.css">
    <link rel="stylesheet" href="/bookManagement/css/changeManagerPassword.css">
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
            <jsp:include page="manager_left.jsp" flush="true" />
        </div>
        <div id="main">
            <div id="mainImport">
                <div class="container" id="change_title">
                    <h3 class="display-5">修改密码</h3>
                </div>
                <div class="container" id="change_main">
                    <form method="post" action="changeManagerPassword" namespace="/bookManagement">
                        <div class="form-inline">
                            <label for="managerAccount">邮箱账号:</label>&nbsp&nbsp&nbsp&nbsp&nbsp
                            <input type="email" class="form-control" id="managerAccount" name="manager.managerAccount" readonly="true" value= '<s:property value="#session.managerLoginAccount"/>'>
                        </div>
                        <br/>
                        <span class="text-danger queryError"><s:property value="#session.managerRegisterAccountError"/></span>
                        <div class="form-inline">
                            <label for="oldManagerPassword">原密码:</label>&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp
                            <input type="password" class="form-control" id="oldManagerPassword" name="oldManagerPassword" >
                        </div>
                        <br/>
                        <span class="text-danger queryError"><s:property value="#session.managerChangeOldPasswordError"/></span>
                        <div class="form-inline">
                            <label for="managerPassword">新密码:</label>&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp
                            <input type="password" class="form-control" id="managerPassword" name="newManagerPassword" >
                        </div>
                        <br/>
                        <span class="text-danger queryError"><s:property value="#session.managerChangeNewPasswordError"/></span>
                        <div class="form-inline">
                            <label for="managerPasswordCon">确认新密码:</label>&nbsp&nbsp
                            <input type="password" class="form-control" id="managerPasswordCon" name="newManagerPasswordCon" >
                        </div>
                        <br/>
                        <span class="text-danger queryError"><s:property value="#session.managerChangeNewPasswordConError"/></span>

                        <span class="text-danger"><s:property value="#session.managerChangePasswordError"/></span>
                        <div id="buttonTwo">
                            <button type="submit" class="btn btn-primary" id="update">修改</button>
                            <a class="btn btn-primary" href="主页" role="button" id="back">返回</a>
                        </div>

                    </form>
                </div>
            </div>

        </div>
    </div>

    <% session.removeAttribute("managerRegisterAccountError"); %>
    <% session.removeAttribute("managerChangeOldPasswordError"); %>
    <% session.removeAttribute("managerChangeNewPasswordError"); %>
    <% session.removeAttribute("managerChangeNewPasswordConError"); %>
    <% session.removeAttribute("managerChangePasswordError"); %>

</body>
</html>
