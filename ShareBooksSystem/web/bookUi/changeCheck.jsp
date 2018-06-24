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
        <li class="nr" onmouseover="nrselect(this)" onmouseleave="nrleave(this)"><a href="UserInfor.jsp">个人中心</a></li>
        <li class="nr" onmouseover="nrselect(this)" onmouseleave="nrleave(this)"><a  href="../bookUser/checkBooks.jsp">查询书籍</a></li>
    </ul>
</div>
<div id="container">
    <div id="container_re_left">
        <img src="img/changeBg.jpg">
    </div>
    <div id="container_re_right">
        <div class="modal-dialog" style="margin:20% auto;width: 70%" >
            <div class="modal-content">
                <!--登陆框头部-->
                <div class="modal-header">
                    <h4 class="modal-title" id="myModalLabel">
                        请输入邮箱中的验证码
                    </h4>
                </div>
                <!--登陆框中间部分(from表单)-->
                <div class="modal-body">
                    <form class="form-horizontal" action="changeCheckAction"  namespace="/bookUi" method="post" role="form">
                        <!--用户名框-->
                        <div class="form-group">
                            <label for="EmailCode" class="col-sm-2 control-label" >验证码</label>
                            <div class="col-sm-8">
                                <input type="text" class="form-control" name="EmailCode" id="EmailCode" placeholder="请输入你邮箱收到的验证码" required="required">
                            </div>
                            <span> <% if(session.getAttribute("EmailCheckError")!=null){  %><%=session.getAttribute("EmailCheckError") %><%session.removeAttribute("EmailCheckError"); }%></span>

                        </div>
                        <div class="modal-footer" id="btn_gp">
                            <button type="submit" style="margin:0 auto" class="btn btn-default col-sm-5">完成</button>
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
