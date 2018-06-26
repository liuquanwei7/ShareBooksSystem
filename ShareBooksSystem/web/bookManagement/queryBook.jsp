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
    <link rel="stylesheet" href="/bookManagement/css/queryBook.css">
    <script src="/bookManagement/js/queryBook.js"></script>
    <script src="https://cdn.bootcss.com/jquery/3.2.1/jquery.min.js"></script>
    <script src="https://cdn.bootcss.com/popper.js/1.12.5/umd/popper.min.js"></script>
    <script src="https://cdn.bootcss.com/bootstrap/4.1.0/js/bootstrap.min.js"></script>
    <script type="text/javascript">
        window.onload=function (){
            var str = "<%=session.getAttribute("managerBookShow") %>".toString();

            if(str=="null"||str==""){

            }
            else{
                document.getElementById("show").style.display = "block";
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
            <div class="container" id="queryBook_title">
                <h3 class="display-5">管理图书信息</h3>
            </div>
            <div class="container" id="queryBook_main">
                <form method="post" action="queryBookAction" namespace="/bookManagement">
                    <div class="row">
                        <div class="col">
                            <label for="bookId">图书编号:</label>
                            <input type="number" class="form-control" id="bookId" name="book.bookId">
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
                            <label for="bookPrice">价格(￥):</label>
                            <input type="number" class="form-control" id="bookPrice" name="book.bookPrice">
                        </div>
                        <div class="col">
                            <label for="bookCategory">图书类型:</label>
                            <input type="text" class="form-control" id="bookCategory" name="book.bookCategory">
                        </div>
                        <div class="col">
                            <div id="queryButton">
                                <button type="reset" class="btn btn-primary" id="reset">重置</button>&nbsp&nbsp
                                <button type="submit" class="btn btn-primary" id="query">查询</button>
                            </div>
                        </div>
                    </div>
                    <a class="btn btn-primary" href="queryAllBookAction.action" role="button" id="queryAll">查询全部图书</a>

                </form>
                <span class="text-danger" id="queryError"><s:property value="#session.managerQueryNullError"/><s:property value="#session.managerQueryNoBookError"/><s:property value="#session.managerQueryLowPriceError"/></span>

                <div id="show">
                    <table class="table table-bordered table-hover" >
                        <tr>
                            <th>id</th><th>图书名称</th><th>作者</th><th>出版社</th><th>价格(￥)</th><th>图书类型</th><th>操作</th>
                        </tr>
                        <s:iterator value="#session.managerBooks" status="st" var="book" >
                            <tr>
                                <td><s:property value="#book.bookId"/></td>
                                <td><s:property value="#book.bookName"/></td>
                                <td><s:property value="#book.bookAuthor"/></td>
                                <td><s:property value="#book.bookPublish"/></td>
                                <td><s:property value="#book.bookPrice"/></td>
                                <td><s:property value="#book.bookCategory"/></td>
                                <td>
                                    <a href="javascript:updateBook('<s:property value="#book.bookId"/>')" class="text-primary">修改</a>
                                    <a href="javascript:deleteBooking('<s:property value="#book.bookId"/>')" class="text-primary">删除</a>
                                </td>
                            </tr>
                        </s:iterator>
                    </table>
                    <div id="byPage">
                        <ul class="pagination">
                            <li class="page-item"><a class="page-link" href="queryBookByPageAction?pageNo=1">首页</a></li>
                            <c:choose>
                                <c:when test="${currentPage>1}">
                                    <li class="page-item"><a class="page-link" href="queryBookByPageAction?pageNo=${currentPage-1}">上一页</a></li>
                                </c:when>
                            </c:choose>
                            <c:choose>
                                <c:when test="${currentPage<totalPage}">
                                    <li class="page-item"><a class="page-link" href="queryBookByPageAction?pageNo=${currentPage+1}">下一页</a></li>
                                </c:when>
                            </c:choose>
                            <li class="page-item"><a class="page-link" href="queryBookByPageAction?pageNo=${totalPage}">尾页</a></li>
                        </ul>
                    </div>
                    <span class="text-info" id="spanError"><s:property value="#session.managerPageError"/></span>
                </div>

            </div>
        </div>
    </div>

    <% session.removeAttribute("managerQueryNoBookError"); %>
    <% session.removeAttribute("managerQueryLowPriceError"); %>
    <% session.removeAttribute("managerQueryNullError"); %>
    <% session.removeAttribute("managerBookShow"); %>
    <% session.removeAttribute("managerPageError"); %>

</body>
</html>
