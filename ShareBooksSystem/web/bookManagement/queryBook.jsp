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
            <h3 class="display-5">查询图书系统</h3>
        </div>
        <div class="container" id="queryBook_main">
            <form method="post" action="queryBookAction" namespace="/bookManagement">
                <div class="row">
                    <div class="col">
                        <label for="bookId">图书编号:</label>
                        <input type="text" class="form-control" id="bookId" name="book.bookId">
                    </div>
                    <div class="col">
                        <label for="bookName">书名:</label>
                        <input type="text" class="form-control" id="bookName" name="book.bookName">
                    </div>
                    <div class="col">
                        <label for="bookAuthor">作者:</label>
                        <input type="text" class="form-control" id="bookAuthor" name="book.bookAuthor">
                    </div>
                    <div class="col">
                        <label for="bookPublish">出版社:</label>
                        <input type="text" class="form-control" id="bookPublish" name="book.bookPublish">
                    </div>
                    <div class="col">
                        <label for="bookPrice">价格:</label>
                        <input type="number" class="form-control" id="bookPrice" name="book.bookPrice">
                    </div>
                    <div class="col">
                        <label for="bookCategory">图书类型:</label>
                        <select class="form-control" id="bookCategory" name="book.bookCategory">
                            <option>教材</option>
                            <option>计算机</option>
                            <option></option>
                            <option></option>
                        </select>
                    </div>
                </div>
                <div class="col">
                    <button type="submit" class="btn btn-primary" id="query">查询</button>
                </div>
            </form>
        </div>
        <div>
            <table class="table table-bordered table-hover" >
                <tr>
                    <th>id</th><th>图书名称</th><th>作者</th><th>出版社</th><th>价格</th><th>图书类型</th><th>操作</th>
                </tr>
                <s:iterator value="#session.books" status="st" var="book" >
                    <tr>
                        <td><s:property value="#book.bookId"/></td>
                        <td><s:property value="#book.bookName"/></td>
                        <td><s:property value="#book.bookAuthor"/></td>
                        <td><s:property value="#book.bookPublish"/></td>
                        <td><s:property value="#book.bookPrice"/></td>
                        <td><s:property value="#book.bookCategory"/></td>
                        <td>
                            <a href="javascript:addBooking()">添加</a>
                            <a href="javascript:changeBooking('<s:property value="id"/>')">修改</a>
                            <a href="javascript:deleteBooking('<s:property value="id"/>')">删除</a>
                        </td>
                    </tr>
                </s:iterator>
            </table>
        </div>
    </div>
    <% session.removeAttribute("books"); %>
</body>
</html>
