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

</head>
<body>
<script src="js/jquery-3.2.1.js"></script>
<script type="text/javascript" src="js/bootstrap.min.js" ></script>
<script src="js/homepage.js"></script>
<div id="naver">

    <img src="img/logo.png"/>
    <div id="logo_text"><span>HIMB</span></div>
    <ul id="flex_naver">
        <li class="nr" onmouseover="nrselect(this)" onmouseleave="nrleave(this)"  ><a href="homepage.jsp">首页</a></li>
        <li class="nr" onmouseover="nrselect(this)" onmouseleave="nrleave(this)"><a href="introduce.jsp">产品体验</a></li>
        <li class="nr" onmouseover="nrselect(this)" onmouseleave="nrleave(this)"><a href="history.jsp">关于我们</a></li>
        <li class="nr" onmouseover="nrselect(this)" onmouseleave="nrleave(this)"><a data-toggle="modal" data-target="#myModal" href="#">登陆注册</a></li>
    </ul>
</div>
<div id="container">
        <div id="container_re_left">
            <img src="img/bg_re.jpg">
        </div>
        <div id="container_re_right">
        <div class="modal-dialog" style="margin:0 auto;width: 70%" >
            <div class="modal-content">
                <!--登陆框头部-->
                <div class="modal-header">
                    <h4 class="modal-title" id="myModalLabel">
                        欢迎注册！
                    </h4>
                </div>
                <!--登陆框中间部分(from表单)-->
                <div class="modal-body">
                    <form class="form-horizontal" action="userRegisterAction"  namespace="/bookUi" method="post" role="form">
                        <!--用户名框-->
                        <div class="form-group">
                            <label  for="userName" class="col-sm-2 control-label">姓名</label>
                            <div class="col-sm-10">
                                <input type="text" class="form-control" name="user.userName"  id="userName" placeholder="userName" required="required">
                            </div>
                        </div>
                        <!--用户框-->
                        <div class="form-group">
                            <label for="userAccount" class="col-sm-2 control-label">账号</label>
                            <div class="col-sm-10">
                                <input type="text" class="form-control" name="user.userAccount"  id="userAccount" placeholder="userAccount" required="required">
                            </div>
                        </div>
                        <!--密码框-->
                        <div class="form-group">
                            <label for="password" class="col-sm-2 control-label" >密码</label>
                            <div class="col-sm-10">
                                <input type="text" class="form-control" name="user.userPassword" id="password" placeholder="password" required="required">
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="Identity" class="col-sm-2 control-label" >学号</label>
                            <div class="col-sm-10">
                                <input type="text" class="form-control" name="user.userIdentity" id="Identity" placeholder="Identity" required="required">
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="Email" class="col-sm-2 control-label" >邮箱</label>
                            <div class="col-sm-10">
                                <input type="text" class="form-control" name="user.userEmail" id="Email" placeholder="Email" required="required">
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="Identity" class="col-sm-2 control-label" >性别</label>
                            <div class="col-sm-2">
                                <input type="radio" name="userGender" value="男"/>
                                <input type="radio" name="userGender" value="女"/>
                            </div>
                        </div>

                        <div class="form-group">
                            <label for="userAge" class="col-sm-2 control-label" >年龄</label>
                            <div class="col-sm-10">
                                <input type="text" class="form-control" name="user.userAge" id="userAge" placeholder="userAge" required="required">
                            </div>
                        </div>

                        <div class="modal-footer" id="btn_gp">
                            <button type="submit" class="btn btn-default">注册</button>
                        </div>
                    </form>
                </div>
            </div>
        </div>
        </div>
</div>
<div id="foot">
    <div id="foot_title">
        联系我们
    </div>
    <hr color="#306255" size="0.3">
    <div id="foot_main">

        <div id="foot_main_title">北理珠621徒步浪科技有限公司</div>

        <div class="foot_txt"> <img  src="img/phone.png" width="20px" height="20px"/> 咨询热线:110101010101</div>
        <div class="foot_txt"><img  src="img/phone.png" width="20px" height="20px"/> 合作电话:111111111111</div>
        <div class="foot_txt"><img  src="img/email.png" width="20px" height="20px"/> 邮箱:sssssssss@163.com</div>
        <div class="foot_txt"><img  src="img/ad.png" width="20px" height="20px"/> 公司地址:珠海市唐家湾镇北理珠34栋</div>
    </div>
</div>
</body>
</html>
