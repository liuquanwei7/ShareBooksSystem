<%--
  Created by IntelliJ IDEA.
  User: LiuQuanwei
  Date: 2018/6/22
  Time: 15:18
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
    <title>修改书籍信息成功</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://cdn.bootcss.com/bootstrap/4.1.0/css/bootstrap.min.css">
    <link rel="stylesheet" href="/bookManagement/css/updateBookSuccess.css">
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
            <div id="message">
                <h1 class="display-4">修改成功</h1>
                <a class="btn btn-success" href="queryBook.jsp" role="button" id="back">返回</a>
            </div>
        </div>
    </div>

</body>
</html>
