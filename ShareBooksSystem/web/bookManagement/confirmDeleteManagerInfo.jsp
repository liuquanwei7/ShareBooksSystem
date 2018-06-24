<%--
  Created by IntelliJ IDEA.
  User: LiuQuanwei
  Date: 2018/6/23
  Time: 14:08
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
    <title>确认删除管理员信息</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://cdn.bootcss.com/bootstrap/4.1.0/css/bootstrap.min.css">
    <link rel="stylesheet" href="/bookManagement/css/confirmDeleteBook.css">
    <script src="https://cdn.bootcss.com/jquery/3.2.1/jquery.min.js"></script>
    <script src="https://cdn.bootcss.com/popper.js/1.12.5/umd/popper.min.js"></script>
    <script src="https://cdn.bootcss.com/bootstrap/4.1.0/js/bootstrap.min.js"></script>
    <script type="text/javascript">
        function confirmDeleteManagerInfo(managerId){
            if(confirm("你确定删除该管理员信息吗?请谨慎操作！")){
                location.href="confirmDeleteManagerInfoAction?managerId="+managerId;
            }
        }
    </script>
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
        <div id="">
            <div class="container">
                <div class="container" id="deleteTitle">
                    <h3 class="display-5">确认删除管理员信息</h3>
                </div>
                <div class="container" id="imContent">
                    <form method="post" action="confirmDeleteBookAction" namespace="/bookManagement">
                        <s:iterator value="#session.managerDeleteManagerInfoItem" status="st" var="managers" >
                            <div class="form-inline">
                                <label>管理员Id:</label>
                                <s:property value="#managers.managerId"/>
                            </div>
                            <br/>
                            <div class="form-inline">
                                <label>管理员账号:</label>&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp
                                <s:property value="#managers.managerAccount"/>
                            </div>
                            <br/>

                            <div class="form-inline">
                                <label >管理员姓名:</label>&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp
                                <s:property value="#managers.managerName"/>
                            </div>
                            <br/>

                            <div class="form-inline">
                                <br/>
                                <label>年龄:</label>&nbsp&nbsp&nbsp
                                <s:property value="#managers.managerAge"/>
                            </div>
                            <br/>

                            <div class="form-inline">
                                <label>性别:</label>&nbsp
                                <s:property value="#managers.managerGender"/>
                            </div>
                            <br/>
                            <div class="form-inline">
                                <label>职位:</label>
                                <s:property value="#managers.managerPermission"/>
                            </div>
                            <span class="text-danger"><s:property value="#session.managerDeleteManagerInfoError"/></span>
                            <a class="btn btn-primary" href="javascript:confirmDeleteManagerInfo('<s:property value="#managers.managerId"/>')" role="button" id="delete">删除</a>
                            <a class="btn btn-primary" href="queryManagerInfo.jsp" role="button" id="back">返回</a>
                        </s:iterator>

                    </form>
                </div>
            </div>
        </div>
    </div>
</div>

<% session.removeAttribute("managerDeleteBookError"); %>
<% session.removeAttribute("managerDeleteManagerInfoError"); %>
</body>
</html>
