<%--
  Created by IntelliJ IDEA.
  User: LiuQuanwei
  Date: 2018/6/5
  Time: 23:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>
<%@ page import="com.sharebookssystem.model.User" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">

<html>
<head>
    <title>Title</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://cdn.bootcss.com/bootstrap/4.1.0/css/bootstrap.min.css">
    <link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">
    <link rel="stylesheet" href="css/fixed.css" />
    <link rel="stylesheet" href="css/UserInfor.css"/>
    <link rel="stylesheet" href="css/home.css">
<style type="text/css">
    #container{
        background:url("img/UserBg.jpg") center center fixed no-repeat;
        -webkit-background-size:cover;
        background-attachment:fixed;
        background-position: center center;
    }
</style>
    <script src="https://cdn.bootcss.com/jquery/3.2.1/jquery.min.js"></script>
    <script src="https://cdn.bootcss.com/popper.js/1.12.5/umd/popper.min.js"></script>
    <script src="https://cdn.bootcss.com/bootstrap/4.1.0/js/bootstrap.min.js"></script>

</head>
<body>
<script type="text/javascript" src="js/bootstrap.min.js" ></script>
<script src="js/homepage.js"></script>
<script>
    var strSession = "<%=session.getAttribute("succcessRegister") %>".toString();
    if( strSession == ""||strSession=="null") {
    }
    else {
        alert(strSession);
        <%  session.removeAttribute("succcessRegister");%>
    }


    var strSessions = "<%=session.getAttribute("ReturnSuccess") %>".toString();
    if( strSessions == ""||strSessions=="null") {
    }
    else {
        alert(strSessions);
        <%  session.removeAttribute("ReturnSuccess");%>
    }

    function showBookInfoAction(id){
            location.href="../bookUser/showBookInfoAction?personalBookId="+id;
    }
</script>

<div id="naver">

    <img src="img/logo.png"/>
    <div id="logo_text"><span>&nbsp;个人中心</span></div>
    <ul id="flex_naver">

            <li class="nr" onmouseover="nrselect(this)" onmouseleave="nrleave(this)"  ><a href="ChangePerson.jsp">管理个人信息</a></li>
            <li class="nr" onmouseover="nrselect(this)" onmouseleave="nrleave(this)"><a href="aheadhome.jsp">主页</a></li>
            <li class="nr" onmouseover="nrselect(this)" onmouseleave="nrleave(this)"><a href="borrows.jsp">查看已借书籍</a></li>
            <li class="nr" onmouseover="nrselect(this)" onmouseleave="nrleave(this)"><a href="UserInfor.jsp">个人中心</a></li>
            <li class="nr" onmouseover="nrselect(this)" onmouseleave="nrleave(this)"><a  href="../bookUser/checkBooks.jsp">查询书籍</a></li>

    </ul>
</div>
<div id="container">
    <div id="container_main">
        <div id="container_main_head">
            <div id= "c_m_t"><% User u=(User) session.getAttribute("user"); %>
                <span><%=u.getUserName()%></span><p>Welcome</p>
            </div>
            <div id="main_na">
                <img src="img/UserInNa.jpg" />
            </div>

        </div>
        <div id="container_main_info">
            <div id="container_books">
                <div align="left" id="home_title"><h1>本周最热</h1></div>
                            <div class="main_center">

                                <s:iterator value="books" status="st1" var="book">
                                    <s:iterator value="personalBooks" status="st2" var="personalBook">
                                            <s:if test="#st1.count==#st2.count">
                                            <div class="book_info"   align="center" >
                                                <img referrerpolicy="no-referrer" src="<s:property value="#book.bookPicture"/>" width="150px" height="200px/">
                                                <div><s:property value="#book.bookName"/></div>
                                                <div style="display: flex;flex-direction: row">
                                                    <div><s:property value="#book.bookAuthor"/></div>
                                                    <div> <s:property value="#book.bookPublish"/></div>
                                                </div>
                                                <a href="javascript:showBookInfoAction('<s:property value="#personalBook.personalBookId"/>')">查看</a>
                                                <div><span>价格&nbsp;</span><s:property value="#book.bookPrice"/>元</div>
                                            </div>
                                            </s:if>
                                      </s:iterator>
                                </s:iterator>

                          </div>

            </div>
        </div>
    </div>
</div>
</body>
</html>
