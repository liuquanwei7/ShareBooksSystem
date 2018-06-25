<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="com.sharebookssystem.model.User" %>
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
    <title>修改用户</title>
    <link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">
    <link rel="stylesheet" href="css/fixed.css" />
    <link rel="stylesheet" href="css/register.css">
    <link rel="stylesheet" href="css/Comments.css">
    <script src="js/page.js"></script>
</head>
<body onload="goPage(1,5)">
<script src="js/jquery-3.2.1.js"></script>
<script type="text/javascript" src="js/bootstrap.min.js" ></script>
<script src="js/homepage.js"></script>
<script>
    var comSession = "<%=session.getAttribute("succcessComment") %>".toString();
    if( comSession == ""||comSession=="null") {
    }
    else {
        alert(comSession);
        <%  session.removeAttribute("succcessComment");%>
    }
    function deleteCommentAction(id){
        if(confirm("你确定删除该用户吗?")){
            location.href="deleteCommentAction?id="+id;
        }
    }
</script>
<div id="naver">

    <img src="img/logo.png"/>
    <div id="logo_text"><span>HIMB</span></div>
    <ul id="flex_naver">
        <li class="nr" onmouseover="nrselect(this)" onmouseleave="nrleave(this)"  ><a href="ChangePerson.jsp">管理个人信息</a></li>
        <li class="nr" onmouseover="nrselect(this)" onmouseleave="nrleave(this)"><a href="aheadhome.jsp">主页</a></li>
        <li class="nr" onmouseover="nrselect(this)" onmouseleave="nrleave(this)"><a href="borrows.jsp">查看已借书籍</a></li>
        <li class="nr" onmouseover="nrselect(this)" onmouseleave="nrleave(this)"><a href="UserInfor.jsp">个人中心</a></li>
        <li class="nr" onmouseover="nrselect(this)" onmouseleave="nrleave(this)"><a  href="../bookUser/checkBooks.jsp">查询书籍</a></li>
    </ul>
</div>


<div id="container">
    <div id="container_re_left">
        <img src="img/bg_demo2.jpg">
    </div>
    <div id="container_re_right">
        <div id="container_comments">
            <div id="com_bookName">
                <h3>《<%=session.getAttribute("myBookName") %>》书评区</h3>
            </div>
            <table  id="idda"  cellspacing="10">
                <s:iterator value="commentItems" status="st" var="commentItem">

                    <s:iterator value="users" status="st" var="user">
                        <%--userid  <s:property value="#user.userId"/>--%>
                         <%--reviewerid<s:property value="#commentItem.getReviewer().getUserId()"/>--%>
                        <s:if test="#commentItem.getReviewer().getUserId()==#user.userId">
                            <tr class="com_hr">
                              <s:if test="#session.userid==#user.userId">

                                <td class="commets_name"style="width:100%;display: flex;flex-direction: row;justify-content: space-between ">
                                    <s:property value="#user.userName"/>
                                    <a href="javascript:deleteCommentAction('<s:property value="#commentItem.commentItemId"/>')" style="color: darkgray;text-decoration: none">x</a>
                                </td>

                                <td class="commets_text">
                                    <s:property value="#commentItem.review"/>


                                </td>

                              </s:if>
                                <s:else>
                                        <td class="commets_name">
                                            <s:property value="#user.userName"/>
                                        </td>

                                        <td class="commets_text">
                                            <s:property value="#commentItem.review"/>

                                        </td>
                                    </tr>
                                </s:else>
                        </s:if>

                    </s:iterator>
                </s:iterator>
            </table>
            <table id="idta2" width="30%" align="center" style="">
                <tr><td><div id="barcon" name="barcon"></div></td></tr>
            </table>
        </div>
        <div id="main_comPosts">
            <s:form action="CommentPostAction" class="col-sm-12" method="POST">
                <div id="com_textarea">
                    <s:label value="发表评论"  style="color:black"></s:label>
                     <s:textarea class="col-sm-10" style="height:100px" name="commentItem.review" ></s:textarea>
                </div>
                <div id="com_submit">
                         <s:submit class=" col-sm-2 btn btn-default" value="提交"/>
                </div>
            </s:form>
         </div>
    </div>
</div>

                    <%--<%--%>
                        <%--session.removeAttribute("CommentUsername");--%>
                        <%--session.removeAttribute("allComments");--%>
                    <%--%>--%>
</body>
</html>



