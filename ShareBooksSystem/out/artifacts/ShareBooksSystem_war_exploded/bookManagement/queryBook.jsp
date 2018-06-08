<%--
  Created by IntelliJ IDEA.
  User: LiuQuanwei
  Date: 2018/6/7
  Time: 22:05
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
    <title>查询</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://cdn.bootcss.com/bootstrap/4.1.0/css/bootstrap.min.css">
    <script src="https://cdn.bootcss.com/jquery/3.2.1/jquery.min.js"></script>
    <script src="https://cdn.bootcss.com/popper.js/1.12.5/umd/popper.min.js"></script>
    <script src="https://cdn.bootcss.com/bootstrap/4.1.0/js/bootstrap.min.js"></script>
</head>
<body>
    <div class="container">
        <div class="container" id="queryBook_title">
            <h3 class="display-3">查询图书系统</h3>
        </div>
        <div class="container" id="queryBook_main">
            <form method="post" action="managerLoginAction" namespace="/bookManagement">
                <div class="form-inline">
                    <label>图书编号:</label>
                    <input type="text" class="form-control" id="bookId">
                </div>
                <div class="form-inline">
                    <label>书名:</label>
                    <input type="text" class="form-control" id="bookName">
                </div>
                <div class="form-inline">
                    <label>作者:</label>
                    <input type="text" class="form-control" id="bookAuthor">
                </div>
                <div class="form-inline">
                    <label>出版社:</label>
                    <input type="text" class="form-control" id="bookPublish">
                </div>
                <button type="submit" class="btn btn-primary" id="login">查询</button>
            </form>
        </div>
    </div>
</body>
</html>
