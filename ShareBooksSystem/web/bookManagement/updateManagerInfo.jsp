<%--
  Created by IntelliJ IDEA.
  User: LiuQuanwei
  Date: 2018/6/23
  Time: 10:13
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
    <title>修改管理员信息</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://cdn.bootcss.com/bootstrap/4.1.0/css/bootstrap.min.css">
    <link rel="stylesheet" href="/bookManagement/css/updateManagerInfo.css">
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
            <div id="mainInfo">
                <div  id="queryManagerInfo_title">
                    <h3 class="display-5">修改管理员信息</h3>
                </div>
                <div  id="queryManagerInfo_main" >
                    <form method="post" action="updateManagerInfoAction" namespace="/bookManagement">
                    <s:iterator value="#session.managerInfo" status="st" var="managers" >
                        <div class="form-inline">
                            <label for="managerInfoId">管理员ID:</label>
                            <input type="text" class="form-control" id="managerInfoId" name="manager.managerId" value= '<s:property value="#managers.managerId"/>' readonly="true">
                        </div>
                        <br/>
                        <div class="form-inline">
                            <label for="managerAccount">邮箱账号:</label>
                            <input type="email" class="form-control" id="managerAccount" name="manager.managerAccount" value= '<s:property value="#managers.managerAccount"/>' >
                        </div>
                        <br/>
                        <span class="text-danger queryError"><s:property value="#session.managerUpdateManagerAccountError"/></span>

                        <div class="form-inline">
                            <label for="managerName">姓名:</label>&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp
                            <input type="text" class="form-control" id="managerName" name="manager.managerName" value= '<s:property value="#managers.managerName"/>' >
                        </div>
                        <br/>
                        <span class="text-danger queryError"><s:property value="#session.managerUpdateManagerNameError"/></span>

                        <div class="form-inline">
                            <label for="managerAge">年龄:</label>&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp
                            <input type="number" class="form-control" id="managerAge" name="manager.managerAge" value= '<s:property value="#managers.managerAge"/>' >
                        </div>
                        <br/>
                        <span class="text-danger queryError"><s:property value="#session.managerUpdateManagerAgeError"/></span>

                        <div class="form-inline" id="gender">
                            <label>性别:</label>
                            <div class="radio">
                                <label>
                                    <input type="radio" name="manager.managerGender" class="checkMale" id="male" value="男" checked/>男
                                </label>
                            </div>
                            <div class="radio">
                                <label>
                                    <input type="radio" name="manager.managerGender" id="female" value='女'>女
                                </label>
                            </div>
                        </div>
                    <br/>
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
                    </s:iterator>
                        <br/>
                        <span class="text-danger"><s:property value="#session.managerUpdateBookError"/></span>
                        <div id="checkTwo">

                            <a class="btn btn-primary" href="queryManagerInfo.jsp" role="button" id="update">返回</a>
                            <button type="submit" class="btn btn-primary" id="back">修改</button>
                        </div>

                    </form>
                </div>
            </div>
        </div>
    </div>
    <% session.removeAttribute("managerUpdateManagerAccountError"); %>
    <% session.removeAttribute("managerUpdateManagerNameError"); %>
    <% session.removeAttribute("managerUpdateManagerAgeError"); %>
    <% session.removeAttribute("managerUpdateBookError"); %>

</body>
</html>
