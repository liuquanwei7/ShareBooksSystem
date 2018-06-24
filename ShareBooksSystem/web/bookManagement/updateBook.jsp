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
    <link rel="stylesheet" href="/bookManagement/css/updateBook.css">
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
            <div class="container">
                <div class="container" id="queryBook_title">
                    <h3 class="display-5">修改图书信息</h3>
                </div>
                <div class="container" id="queryBook_main" >
                    <form method="post" action="updateBookAction" namespace="/bookManagement">
                        <s:iterator value="#session.managerBooks" status="st" var="managerBooks" >
                            <div class="form-inline">
                                <label for="bookId">图书编号:</label>
                                <input type="text" class="form-control" id="bookId" name="book.bookId" value= '<s:property value="#managerBooks.bookId"/>' readonly="true">
                            </div>
                            <br/>
                            <div class="form-inline">
                                <label for="bookName">书名:</label>&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp
                                <input type="text" class="form-control" id="bookName" name="book.bookName" value= '<s:property value="#managerBooks.bookName"/>' >
                            </div>
                            <br/>
                            <span class="text-danger" id="queryError"><s:property value="#session.managerUpdateBookNameError"/></span>

                            <div class="form-inline">
                                <label for="bookAuthor">作者:</label>&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp
                                <input maxlength="50"  type="text" class="form-control" id="bookAuthor" name="book.bookAuthor" value='<s:property value="#managerBooks.bookAuthor"/>' >
                            </div>
                            <br/>
                            <span class="text-danger" id="queryError"><s:property value="#session.managerUpdateBookAuthorError"/></span>
                            <div class="form-inline">
                                <br/>
                                <label for="bookPublish">出版社:</label>&nbsp&nbsp&nbsp
                                <input type="text" class="form-control" id="bookPublish" name="book.bookPublish" value= '<s:property value="#managerBooks.bookPublish"/>' >
                            </div>
                            <br/>
                            <span class="text-danger" id="queryError"><s:property value="#session.managerUpdateBookPublishError"/></span>

                            <div class="form-inline">
                                <label for="bookPrice">价格(￥):</label>&nbsp
                                <input type="number" class="form-control" id="bookPrice" name="book.bookPrice" value= '<s:property value="#managerBooks.bookPrice"/>' >
                            </div>
                            <br/>
                            <span class="text-danger" id="queryError"><s:property value="#session.managerUpdateBookPriceError"/></span>

                            <div class="form-inline">
                                <label for="bookCategory">图书类型:</label>
                                <select class="form-control" id="bookCategory" name="book.bookCategory" value= '<s:property value="#managerBooks.bookCategory"/>' >
                                    <option>教材</option>
                                    <option>教材</option>
                                    <option>教材</option>
                                    <option>教材</option>
                                </select>
                            </div>
                        </s:iterator>
                        <span class="text-danger"><s:property value="#session.managerUpdateBookError"/></span>
                        <button type="submit" class="btn btn-primary" id="update">修改</button>
                        <a class="btn btn-primary" href="queryBook.jsp" role="button" id="back">返回</a>
                    </form>
                </div>
            </div>
        </div>
    </div>
    <% session.removeAttribute("managerUpdateBookNameError"); %>
    <% session.removeAttribute("managerUpdateBookAuthorError"); %>
    <% session.removeAttribute("managerUpdateBookPublishError"); %>
    <% session.removeAttribute("managerUpdateBookPriceError"); %>
    <% session.removeAttribute("managerUpdateBookError"); %>
</body>
</html>
