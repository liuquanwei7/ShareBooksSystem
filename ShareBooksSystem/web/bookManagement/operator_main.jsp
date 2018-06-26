<%--
  Created by IntelliJ IDEA.
  User: LiuQuanwei
  Date: 2018/6/24
  Time: 11:39
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
    <title>操作员主页面</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://cdn.bootcss.com/bootstrap/4.1.0/css/bootstrap.min.css">
    <link rel="stylesheet" href="css/operator_main.css">
    <script src="https://cdn.bootcss.com/jquery/3.2.1/jquery.min.js"></script>
    <script src="https://cdn.bootcss.com/popper.js/1.12.5/umd/popper.min.js"></script>
    <script src="https://cdn.bootcss.com/bootstrap/4.1.0/js/bootstrap.min.js"></script>
    <script type="text/javascript">
        function exit() {
            if(confirm("你确定退出登录吗？")){
                location.href="managerExitLogin";
            }
        }
    </script>
</head>
<body>
    <div id="main" class="container">
        <div class="row">
            <div class="col">
                <a class="btn btn-primary btn-lg" href="operatorShareBook.jsp" role="button" id="share">借出图书</a>
            </div>
            <div class="col">
                <a class="btn btn-primary btn-lg" href="operatorBorrowBook.jsp" role="button" id="borrow">借阅图书</a>
            </div>
            <div class="col">
                <a class="btn btn-primary btn-lg" href="operatorReturnBook.jsp" role="button" id="return">归还图书</a>
            </div>
            <div class="col">
                <a class="btn btn-primary btn-lg" href="operatorGetBook.jsp" role="button" id="recover">收回图书</a>
            </div>
        </div>
        <a class="btn btn-primary" href="javascript:exit()" role="button" id="back">退出登录</a>
    </div>
</body>
</html>
