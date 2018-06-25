<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: yuanp
  Date: 2018/6/12
  Time: 17:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>注册用户</title>
    <link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">
    <link rel="stylesheet" href="css/fixed.css" />
    <link rel="stylesheet" href="css/register.css">
    <link rel="stylesheet" href="css/BorrowAlready.css">
</head>
<body>
<script src="js/jquery-3.2.1.js"></script>
<script type="text/javascript" src="js/bootstrap.min.js" ></script>
<script src="js/homepage.js"></script>
<s:include value="newNav.jsp"></s:include>
<%--<div id="naver">--%>

    <%--<img src="img/logo.png"/>--%>
    <%--<div id="logo_text"><span>HIMB</span></div>--%>
    <%--<ul id="flex_naver">--%>
        <%--<li class="nr" onmouseover="nrselect(this)" onmouseleave="nrleave(this)"  ><a href="ChangePerson.jsp">管理个人信息</a></li>--%>
        <%--<li class="nr" onmouseover="nrselect(this)" onmouseleave="nrleave(this)"><a href="aheadhome.jsp">主页</a></li>--%>
        <%--<li class="nr" onmouseover="nrselect(this)" onmouseleave="nrleave(this)"><a href="borrows.jsp">查看已借书籍</a></li>--%>
        <%--<li class="nr" onmouseover="nrselect(this)" onmouseleave="nrleave(this)"><a href="UserInfor.jsp">个人中心</a></li>--%>
        <%--<li class="nr" onmouseover="nrselect(this)" onmouseleave="nrleave(this)"><a  href="../bookUser/checkBooks.jsp">查询书籍</a></li>--%>
    <%--</ul>--%>
<%--</div>--%>
<script>
    function queryReturn(id){
        alert(id);
        location.href="queryReturnAction?id="+id;
    }

    var strSession = "<%=session.getAttribute("ReturnSuccess") %>".toString();
    if( strSession == ""||strSession=="null") {
    }
    else {
        alert(strSession);
        <%  session.removeAttribute("ReturnSuccess");%>
    }

</script>
<div id="container">
    <div id="container_re_left" style="width: 40%">
        <img src="img/bg_demo3.jpg">
    </div>
    <div id="container_re_right" style="width: 60%;">
        <div id="main_books" >
            <s:iterator value="books" status="st" var="book">
                <div class="main_center" >
                    <div class="center_left"   align="center" >
                        <img referrerpolicy="no-referrer" src="<s:property value="#book.bookPicture"/>" width="150px" height="200px/">
                        <div><s:property value="#book.bookName"/></div>
                        <div style="display: flex;flex-direction: row">
                            <div><s:property value="#book.bookAuthor"/></div>
                            <div> <s:property value="#book.bookPublish"/></div>
                        </div>
                    </div>
                    <div class="center_right" >

                        <a href="javascript:queryReturn('<s:property value="#book.bookId"/>')">申请还书</a>
                        <div><span>价格&nbsp;</span><s:property value="#book.bookPrice"/>元</div>
                    </div>

                </div>

            </s:iterator>
        </div>
    </div>
</div>
<script>

</script>

</body>
</html>



