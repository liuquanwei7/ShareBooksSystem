<%--
  Created by IntelliJ IDEA.
  User: LiuQuanwei
  Date: 2018/6/25
  Time: 9:31
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
    <title>操作员确认分享图书</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://cdn.bootcss.com/bootstrap/4.1.0/css/bootstrap.min.css">
    <link rel="stylesheet" href="css/operatorConfirmShareBook.css">
    <script src="https://cdn.bootcss.com/jquery/3.2.1/jquery.min.js"></script>
    <script src="https://cdn.bootcss.com/popper.js/1.12.5/umd/popper.min.js"></script>
    <script src="https://cdn.bootcss.com/bootstrap/4.1.0/js/bootstrap.min.js"></script>
    <script type="text/javascript">
        function confirmShareBook(shareCode){
            if(confirm("确认信息无误")){
                location.href="operatorConfirmShareBookAction?shareCode="+shareCode;
            }
        }
    </script>
</head>
<body>
    <div id="main">
        <div class="container" id="queryBook_title">
            <h3 class="display-5">确认分享信息</h3>
        </div>
        <div>
            <form method="post" action="" namespace="/bookManagement">
                <s:iterator value="#session.operatorShareBook" status="st" var="operatorBooks" >
                    <div id="bookPicture">
                        <img src='<s:property value="#operatorBooks.bookPicture"/>' alt="网络错误" referrerpolicy="no-referrer" >
                    </div>
                    <br/>
                    <div class="form-inline">
                        <label>书名:</label>&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp
                        <s:property value="#operatorBooks.bookName"/>
                    </div>
                    <br/>
                    <div class="form-inline">
                        <label >作者:</label>&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp
                        <s:property value="#operatorBooks.bookAuthor"/>
                    </div>
                    <br/>
                    <div class="form-inline">
                        <br/>
                        <label>出版社:</label>&nbsp&nbsp&nbsp
                        <s:property value="#operatorBooks.bookPublish"/>
                    </div>
                    <br/>
                </s:iterator>
                <s:iterator value="#session.operatorShareUser" status="st" var="user" >
                    <div class="form-inline">
                        <label>分享者姓名:</label>&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp
                        <s:property value="#user.userName"/>
                    </div>
                    <br/>
                    <div class="form-inline">
                        <label >分享者学号:</label>&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp
                        <s:property value="#user.userIdentity"/>
                    </div>
                    <br/>
                </s:iterator>
                <span class="text-danger"><s:property value="#session.operatorConfirmShareBookError"/></span>
                <div id="twoButton">
                    <a class="btn btn-primary" href="javascript:confirmShareBook('<s:property value="#session.operatorShareCode"/>')" role="button" id="confirm">确认分享</a>
                    <a class="btn btn-primary" href="operatorShareBook.jsp" role="button" id="back">返回</a>
                </div>

            </form>
        </div>

    </div>
    <% session.removeAttribute("operatorConfirmShareBookError"); %>
</body>
</html>
