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

</head>
<body>
<script src="js/jquery-3.2.1.js"></script>
<script type="text/javascript" src="js/bootstrap.min.js" ></script>
<script src="js/homepage.js"></script>
<div id="naver">

    <img src="img/logo.png"/>
    <div id="logo_text"><span>HIMB</span></div>
    <ul id="flex_naver">
        <li class="nr" onmouseover="nrselect(this)" onmouseleave="nrleave(this)"  ><a href="ChangePerson.jsp">管理个人信息</a></li>
        <li class="nr" onmouseover="nrselect(this)" onmouseleave="nrleave(this)"><a href="aheadhome.jsp">主页</a></li>
        <li class="nr" onmouseover="nrselect(this)" onmouseleave="nrleave(this)"><a href="borrows.jsp">查看已借书籍</a></li>
        <li class="nr" onmouseover="nrselect(this)" onmouseleave="nrleave(this)"><a  href="../bookUser/checkBooks.jsp">查询书籍</a></li>
    </ul>
</div>
<% User u=(User) session.getAttribute("user"); %>
<script>
   window.onload=function () {
       <%--document.getElementById("userName").value=<%=u.getUserName()%>--%>
       var uSex=document.getElementsByClassName("ug")
       // alert(uSex);
       alert(uSex.length);
       for(var i=0;i<uSex.length;i++){

           // alert(uSex[0].value);
           if(uSex[i].value=="<%=u.getUserGender()%>"){

               uSex[i].checked = "checked";
           }
       }
   }

</script>

<div id="container">
    <div id="container_re_left">
        <img src="img/changeBg.jpg">
    </div>
    <div id="container_re_right">
        <div class="modal-dialog" style="margin:0 auto;width: 70%" >
            <div class="modal-content">
                <!--登陆框头部-->
                <div class="modal-header">
                    <h4 class="modal-title" id="myModalLabel">
                        Welcome,&nbsp;
                        <%=u.getUserName() %>
                    </h4>
                </div>
                <!--登陆框中间部分(from表单)-->
                <div class="modal-body">
                    <form class="form-horizontal"  action="userChangeAction" name="changeF" namespace="/bookUi" method="post" role="form">
                        <!--用户名框-->
                        <div class="form-group">
                            <label  for="userName" class="col-sm-2 control-label">姓名</label>
                            <div class="col-sm-8">
                                <input type="text" class="form-control" name="user.userName" value="<%=u.getUserName() %>" id="userName" placeholder="姓名长度不大于20位" required="required">
                            </div>
                            <span> <% if(session.getAttribute("userNameError")!=null){  %><%=session.getAttribute("userNameError") %><%session.removeAttribute("userNameError"); }%></span>
                        </div>
                        <!--用户框-->
                        <div class="form-group">
                            <label for="userAccount" class="col-sm-2 control-label">账号</label>
                            <div class="col-sm-8">
                                <input type="text" class="form-control" name="user.userAccount"  id="userAccount" value="<%=u.getUserAccount() %>" placeholder="账户长度大于10位小于6位" required="required">
                            </div>
                            <span> <% if(session.getAttribute("userAccountError")!=null){  %><%=session.getAttribute("userAccountError") %><%session.removeAttribute("userAccountError"); }%></span>

                        </div>
                        <!--密码框-->
                        <div class="form-group">
                            <label for="password" class="col-sm-2 control-label" >密码</label>
                            <div class="col-sm-8">
                                <input type="text" class="form-control" name="user.userPassword" id="password" value="<%=u.getUserPassword() %>" placeholder="密码长度大于5位小于10位" required="required">
                            </div>
                            <span> <% if(session.getAttribute("userPasswordError")!=null){  %><%=session.getAttribute("userPasswordError") %><%session.removeAttribute("userPasswordError"); }%></span>

                        </div>
                        <div class="form-group">
                            <label for="Identity" class="col-sm-2 control-label" >学号</label>
                            <div class="col-sm-8">
                                <input type="text" class="form-control" name="user.userIdentity" value="<%=u.getUserIdentity()%>" id="Identity" placeholder="学号长度小于20位" required="required">
                            </div>
                            <span> <% if(session.getAttribute("userIdentityError")!=null){  %><%=session.getAttribute("userIdentityError") %><%session.removeAttribute("userIdentityError"); }%></span>

                        </div>
                        <div class="form-group">
                            <label for="Email" class="col-sm-2 control-label" >邮箱</label>
                            <div class="col-sm-8">
                                <input type="text" class="form-control" name="user.userEmail" value="<%=u.getUserEmail()%>" id="Email" placeholder="邮箱" required="required">
                            </div>
                            <span> <% if(session.getAttribute("userEmailError")!=null){  %><%=session.getAttribute("userEmailError") %><%session.removeAttribute("userEmailError"); }%></span>

                        </div>
                        <div class="form-group">
                            <label for="Identity" class="col-sm-2 control-label" >性别</label>
                            <div class="col-sm-2" style="display: flex; flex-direction: row " >
                                男   <input type="radio" name="user.userGender" class="ug" value="男" />
                                女 <input type="radio" name="user.userGender" class="ug" value="女"/>
                                <input type="hidden" name="user.userGender"  value=""/>
                            </div>
                            <span> <% if(session.getAttribute("userGenderError")!=null){  %><%=session.getAttribute("userGenderError") %><%session.removeAttribute("userGenderError"); }%></span>

                        </div>

                        <div class="form-group">
                            <label for="userAge" class="col-sm-2 control-label" >年龄</label>
                            <div class="col-sm-8">
                                <input type="text" class="form-control" value="<%=u.getUserAge()%>" name="userAge" id="userAge" placeholder="年龄必须小于200" required="required">
                            </div>
                            <span> <% if(session.getAttribute("userAgeError")!=null){  %><%=session.getAttribute("userAgeError") %><%session.removeAttribute("userAgeError"); }%></span>

                        </div>
                        <div class="modal-footer" id="btn_gp">
                            <button type="submit" style="margin: 0 auto" class="btn btn-default col-sm-5">完成</button>

                        </div>

                    </form>
                </div>
            </div>
        </div>
    </div>
</div>
<script>

</script>

</body>
</html>

