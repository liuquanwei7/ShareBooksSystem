<%@ page import="com.sharebookssystem.model.User" %><%--
  Created by IntelliJ IDEA.
  User: Cammer
  Date: 2018/6/7
  Time: 23:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
    <title>管理员修改用户信息</title>
    <meta charset="UTF-8" content="text/html"/>
</head>
<body>
<% User user = (User)session.getAttribute("managerChooseUser"); %>
<div><a href="nowUserPage.action"><--返回</a></div>
<div><s:fielderror><s:param>managerChangeUserFailError</s:param></s:fielderror></div>
    <div>
    <form action="managerChangeUserInfo.action" method="post">
        <table>
            <tr>
                <td>用户姓名:</td>
                <td><input type="text" name="userName" value="<%=user.getUserName()%>"/></td>
            </tr>
            <tr>
                <td>账号:</td>
                <td><input type="text" name="userAccount" value="<%=user.getUserAccount()%>"/></td>
            </tr>
            <tr>
                <td>密码:</td>
                <td><input type="text" name="userPassword" value="<%=user.getUserPassword()%>"/></td>
            </tr>
            <tr>
                <td>学号:</td>
                <td><input type="text" name="userIdentity" value="<%=user.getUserIdentity()%>"/></td>
            </tr>
            <tr>
                <td>性别:</td>
                <td>
                    <% if (user.getUserGender().equals("男")){%>
                    男:<input type="radio" name="userGender" value="男" checked="checked"/>
                    女:<input type="radio" name="userGender" value="女"/>
                    <% }else{ %>
                    男:<input type="radio" name="userGender" value="男"/>
                    女:<input type="radio" name="userGender" value="女" checked="checked"/>
                    <% } %>
                </td>
            </tr>
            <tr>
                <td>年龄:</td>
                <td><input type="number" name="userAge" max="80" min="10" value="<%=user.getUserAge()%>"/></td>
            </tr>
            <tr>
                <td>权限:</td>
                <td><input type="number" name="userPermission" max="4" min="0" value="<%=user.getUserPermission()%>"></td>
            </tr>
            <tr>
                <td><input type="submit" value="修改"></td>
            </tr>
        </table>
    </form>
</div>
</body>
</html>
