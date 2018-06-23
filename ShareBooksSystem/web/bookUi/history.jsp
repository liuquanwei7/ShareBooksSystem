<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>关于我们</title>
	<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">
	<link rel="stylesheet" href="css/fixed.css" />
	<link rel="stylesheet" href="css/history.css" />

</head>
<body>
<script src="js/jquery-3.2.1.js"></script>
<script type="text/javascript" src="js/bootstrap.min.js" ></script>
<script src="js/homepage.js"></script>
<script>
    var strSession = "<%=session.getAttribute("error") %>".toString();
    if( strSession == ""||strSession=="null") {
    }
    else {
        alert(strSession);
        <%  session.removeAttribute("error");     session.removeAttribute("user");%>
    }
</script>
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
<%--登陆注册模态框--%>
<!-- 模态框（Modal） -->
<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true" data-backdrop="true">
	<div class="modal-dialog" style="margin:10% auto;width: 35%">
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
				<form class="form-horizontal" action="userLoginAction"  namespace="/bookUi" method="post" role="form">
					<!--用户框-->
					<div class="form-group">
						<label for="username" class="col-sm-2 control-label">用户名</label>
						<div class="col-sm-10">
							<input type="text" class="form-control" name="user.userAccount" id="username" placeholder="username" required="required">
						</div>
					</div>
					<!--密码框-->
					<div class="form-group">
						<label for="password" class="col-sm-2 control-label" >密码</label>
						<div class="col-sm-10">
							<input type="password" class="form-control" name="user.userPassword" id="password" placeholder="password" required="required">
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
					<!--登陆按钮-->
					<div class="modal-footer" id="btn_gp">
						<button type="submit" class="btn btn-default">登录</button>

						<button type="button" class="btn btn-default" onclick="window.location.href='register.jsp'">注册</button>


					</div>
				</form>
			</div>
		</div>
	</div>
</div>


<script src="js/jquery-1.8.3.min.js"></script>
<div id="container">
	<div id="container_in">
		<div id="in_img">
			<img src="img/ad_bg.jpg"/>
		</div>
		<div id="container_in_txt">
			<h1>公司简介</h1>
			<div class="clear"></div>
			<div><hr />
				<p>随着互联网的迅速发展，传统的图书馆越来越满足不了现在的需求了，而共享图书平台为了解决个人图书资源的闲置流动问题，从而方便了人们借书和还书。我们的平台分为管理员端和用户使用端，普通用户可以在前台进行查看图书和上传借阅图书，管理员可以在后台对图书和人员信息的管理。 </p>
			</div>

		</div>

	</div>
	<div id="container_his">
		<h1>发展历程</h1>
		<div class="clear"></div>
		<div id="his_sp"><hr />
			<div class="sp_same"><img src="img/circle.png" width="30px" height="30px"/><p><span>2018年2月--</span>HIMB项目正式启动</p></div>
			<div class="sp_same"><img src="img/circle.png" width="30px" height="30px"/><p><span>2018年3月--</span>HIMB项目UI设计完成</p></div>
			<div class="sp_same"><img src="img/circle.png" width="30px" height="30px"/><p><span>2018年4月--</span>HIMB搭建服务器，部署mySql数据库</p></div>
			<div class="sp_same"><img src="img/circle.png" width="30px" height="30px"/><p><span>2018年5月--</span>HIMB项目后台pojo类持续更新版本</p></div>
			<div class="sp_same"><img src="img/circle.png" width="30px" height="30px"/><p><span>2018年6月--</span>HIMB正式完成，上线北理工</p></div>
			<div class="sp_same"><img src="img/circle.png" width="30px" height="30px"/><p><span>2018年7月--</span>HIMB获得融资3000万，a股上市</p></div>
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
