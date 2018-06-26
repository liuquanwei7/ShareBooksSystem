<%--
  Created by IntelliJ IDEA.
  User: LiuQuanwei
  Date: 2018/6/22
  Time: 17:26
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
    <title>确认删除图书</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://cdn.bootcss.com/bootstrap/4.1.0/css/bootstrap.min.css">
    <link rel="stylesheet" href="/bookManagement/css/confirmDeleteBook.css">
    <script src="https://cdn.bootcss.com/jquery/3.2.1/jquery.min.js"></script>
    <script src="https://cdn.bootcss.com/popper.js/1.12.5/umd/popper.min.js"></script>
    <script src="https://cdn.bootcss.com/bootstrap/4.1.0/js/bootstrap.min.js"></script>
    <script type="text/javascript">
        function confirmDeleteBook(bookId){
            if(confirm("你确定删除该书籍信息吗?请谨慎操作！")){
                location.href="confirmDeleteBookAction?bookId="+bookId;
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
                            <h3 class="display-5">确认删除图书信息</h3>
                        </div>
                        <div id="deleteBook_main">
                            <div class="container" id="imContent">
                                <form method="post" action="confirmDeleteBookAction" namespace="/bookManagement">
                                    <s:iterator value="#session.managerDeleteBookItem" status="st" var="managerBooks" >
                                        <div class="form-inline">
                                            <label>图书编号:</label>
                                            <s:property value="#managerBooks.bookId"/>
                                        </div>
                                        <br/>
                                        <div class="form-inline">
                                            <label>书名:</label>&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp
                                            <s:property value="#managerBooks.bookName"/>
                                        </div>
                                        <br/>

                                        <div class="form-inline">
                                            <label >作者:</label>&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp
                                            <s:property value="#managerBooks.bookAuthor"/>
                                        </div>
                                        <br/>

                                        <div class="form-inline">
                                            <br/>
                                            <label>出版社:</label>&nbsp&nbsp&nbsp
                                            <s:property value="#managerBooks.bookPublish"/>
                                        </div>
                                        <br/>

                                        <div class="form-inline">
                                            <label>价格(￥):</label>&nbsp
                                            <s:property value="#managerBooks.bookPrice"/>
                                        </div>
                                        <br/>

                                        <div class="form-inline">
                                            <label>图书类型:</label>
                                            <s:property value="#managerBooks.bookCategory"/>
                                        </div>
                                        <span class="text-danger"><s:property value="#session.managerDeleteBookError"/></span>
                                        <a class="btn btn-primary" href="javascript:confirmDeleteBook('<s:property value="#managerBooks.bookId"/>')" role="button" id="delete">删除</a>
                                        <a class="btn btn-primary" href="queryBook.jsp" role="button" id="back">返回</a>
                                    </s:iterator>
                                </form>
                            </div>

                            <div id="bookPicture">
                                <img src='<s:property value="#session.managerBooksPicture"/>' name="book.bookPicture" alt="网络错误" referrerpolicy="no-referrer" >
                            </div>
                        </div>

                    </div>
                </div>
            </div>
        </div>

    <% session.removeAttribute("managerDeleteBookError"); %>
    <% session.removeAttribute("managerDeleteBookItem"); %>
</body>
</html>
