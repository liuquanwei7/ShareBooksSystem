<%--
  Created by IntelliJ IDEA.
  User: Cammer
  Date: 2018/6/7
  Time: 15:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
    <title>管理员增加用户</title>
    <meta charset="UTF-8" content="text/html"/>
    <script src="https://cdn.bootcss.com/jquery/3.2.1/jquery.min.js"></script>
    <script src="https://cdn.bootcss.com/popper.js/1.12.5/umd/popper.min.js"></script>
    <script src="https://cdn.bootcss.com/bootstrap/4.1.0/js/bootstrap.min.js"></script>
</head>
<body>
<div id="top">
    <jsp:include page="../bookManagement/manager_top.jsp" flush="true" />
</div>
<div id="left" style="top:50px; position:absolute">
    <jsp:include page="../bookManagement/manager_left.jsp" flush="true" />
</div>
<div id="pan_main" style="left:450px;top:100px;margin: 0 auto;width: 800px;height: 500px;position:absolute">
    <div><a href="nowUserPage.action"><--返回</a></div>
    <div><s:fielderror><s:param>managerAddUserFailError</s:param></s:fielderror></div>
    <div>
        <form action="managerAddUser.action" method="post">
        <table>
            <tr>
                <td>用户姓名:</td>
                <td><input type="text" name="userName"/></td>
            </tr>
            <tr>
                <td>账号:</td>
                <td><input type="text" name="userAccount"/></td>
            </tr>
            <tr>
                <td>密码:</td>
                <td><input type="password" name="userPassword"/></td>
            </tr>
            <tr>
                <td>确认密码:</td>
                <td><input type="password" name="s_Password"/></td>
            </tr>
            <tr>
                <td>邮件:</td>
                <td><input type="email" name="userEmail"/></td>
            </tr>
            <tr>
                <td>学号:</td>
                <td><input type="text" name="userIdentity"/></td>
            </tr>
            <tr>
                <td>性别:</td>
                <td>
                    男:<input type="radio" name="userGender" value="男" checked="checked"/>
                    女:<input type="radio" name="userGender" value="女"/>
                </td>
            </tr>
            <tr>
                <td>年龄:</td>
                <td><input type="number" name="userAge" max="80" min="10" value="20"/></td>
            </tr>
            <tr>
                <td>权限:</td>
                <td><input type="number" name="userPermission" max="4" min="0" value="2"></td>
            </tr>
            <tr>
                <td><input type="submit" value="提交"></td>
            </tr>
        </table>
        </form>
    </div>
</div>
</body>
</html>
