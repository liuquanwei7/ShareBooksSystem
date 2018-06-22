<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>主页</title>

	<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">
	<link rel="stylesheet" href="css/homepage.css" />
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
        <%  session.removeAttribute("error");     session.removeAttribute("user");
        session.removeAttribute("personalbooks");        session.removeAttribute("books");
         session.removeAttribute("myPersonalBookid"); session.removeAttribute("comPersonnalbook");

         session.removeAttribute("myPersonalBookid"); session.removeAttribute("comPersonnalbook");
        %>
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
	<div id="container_introduce">
		<img src="img/introduce.png" />

	</div>
	<div id="container_advantage">
		<div id="container_advantage_left">
			<img src="img/ad_leftman.png" />
		</div>
		<div id="container_advantage_right">
			<div id="ad_title">
				方便免费 ● 阅读体系
			</div>
			<hr  color="dimgray"/>
			<div id="ad_text">
				<span>缺乏资金购书？</span>	<br />
				<span>书店离得太远?</span>
				<br />
				<span>HIMB通过共享图书的方式获取海量</span><br />
				<span>图书，各种你想要的书应有尽有。</span><br />
				<span>并且我们在此承诺，终生免费</span>
			</div>
		</div>
	</div>
	<div id="container_shelf">
		<div id="shelf_left">
			<img src="img/shelf.png"/>
		</div>
		<div id="shelf_right">
			<div id="right_title">借阅机智能化</div>
			<hr color="dimgray"/>
			<div id="right_txt">
				<span>HIMB共享图书馆</span><br />
				<span>一起共享图书，获取知识终生免费</span><br />
				<span>随机获得开锁码，开柜取书、还书</span>
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
