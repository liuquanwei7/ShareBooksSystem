<%--
  Created by IntelliJ IDEA.
  User: LiuQuanwei
  Date: 2018/6/10
  Time: 22:28
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
    <title>修改图书</title>
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
        <h3 class="display-5">修改图书</h3>
    </div>
    <div class="container" id="queryBook_main">
        <form method="post" action="queryBookAction" namespace="/bookManagement">
            <div class="form-inline">
                <label for="bookId">图书编号:</label>
                <input type="text" class="form-control" id="bookId" name="book.bookId">
            </div>
            <div class="form-inline">
                <label for="bookName">书名:</label>&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp
                <input type="text" class="form-control" id="bookName" name="book.bookName">
            </div>
            <div class="form-inline">
                <label for="bookAuthor">作者:</label>&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp
                <input type="text" class="form-control" id="bookAuthor" name="book.bookAuthor">
            </div>
            <div class="form-inline">
                <label for="bookPublish">出版社:</label>&nbsp&nbsp&nbsp
                <input type="text" class="form-control" id="bookPublish" name="book.bookPublish">
            </div>
            <div class="form-inline">
                <label for="bookPrice">价格:</label>&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp
                <input type="number" class="form-control" id="bookPrice" name="book.bookPrice">
            </div>
            <div class="form-inline">
                <label for="bookCategory">图书类型:</label>
                <select class="form-control" id="bookCategory" name="book.bookCategory">
                    <option>教材</option>
                    <option>教材</option>
                    <option>教材</option>
                    <option>教材</option>
                </select>
            </div>
            <button type="submit" class="btn btn-primary" id="query">修改</button>
        </form>
    </div>
</div>
</body>
</html>
