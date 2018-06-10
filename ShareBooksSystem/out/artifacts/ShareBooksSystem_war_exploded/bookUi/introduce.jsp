<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>

<html>
<head>
    <meta charset="UTF-8">
    <title>产品体验</title>
    <link rel="stylesheet" type="text/css" href="css/style.css">


    <link rel="stylesheet" href="css/bootstrap.min.css" />
    <link rel="stylesheet" href="css/fixed.css" />
    <link rel="stylesheet" href="css/container_introduce.css" />
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
        <li class="nr" onmouseover="nrselect(this)" onmouseleave="nrleave(this)"><a  data-toggle="modal" data-target="#myModal" href="#">登陆注册</a></li>
    </ul>
</div>

<!-- 模态框（Modal） -->
<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true" data-backdrop="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <!--登陆框头部-->
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">
                    ×
                </button>
                <h4 class="modal-title" id="myModalLabel">
                    欢迎登陆！
                </h4>
            </div>
            <!--登陆框中间部分(from表单)-->
            <div class="modal-body">
                <form class="form-horizontal" method="logins" role="form">
                    <!--用户框-->
                    <div class="form-group">
                        <label for="username" class="col-sm-2 control-label">用户名</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" id="username" placeholder="username" required="required">
                        </div>
                    </div>
                    <!--密码框-->
                    <div class="form-group">
                        <label for="password" class="col-sm-2 control-label" >密码</label>
                        <div class="col-sm-10">
                            <input type="password" class="form-control" id="password" placeholder="password" required="required">
                        </div>
                    </div>
                    <!--记住密码-->
                    <div class="form-group">
                        <div class="col-sm-offset-2 col-sm-10">
                            <div class="checkbox">
                                <label>
                                    <input type="checkbox"> 记住密码
                                </label>
                            </div>
                        </div>
                    </div>
                    <!--登陆按钮-->
                    <div class="form-group">
                        <div class="col-sm-offset-2 col-sm-10">
                            <button type="submit" class="btn btn-default">登录</button>
                        </div>
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>
<div id="container">
    <div id="container_introduce">
        <img src="img/introduce_bg.png" />
    </div>
    <div id="container_main3" >
        <div class="poster-main">
            <img src="img/f2.PNG" width="50%">
            <img src="img/f1.PNG" width="50%">
            <img src="img/f2.PNG" width="50%">
            <img src="img/f2.PNG" width="50%">
            <img src="img/f1.PNG" width="50%">
            <img src="img/f2.PNG" width="50%">

        </div>
    </div>
    <div id="container_main2">
        <img  src="img/textdemo.png"/>
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
<script src="js/jquery-1.8.3.min.js"></script>
<script src="js/poster.js"></script>
<script>
    $(document).ready(function($) {
        var setting = {
            "width":900,
            "height":234,
        };
        Poster.init($(".poster-main"),setting);

    });
    var _$ = jQuery.noConflict(true);
</script>
</body>
</html>
