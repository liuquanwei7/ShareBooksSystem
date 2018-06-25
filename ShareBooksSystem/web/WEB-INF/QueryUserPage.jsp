<%--
  Created by IntelliJ IDEA.
  User: Cammer
  Date: 2018/6/3
  Time: 14:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
    <title>管理用户信息</title>
    <meta content="text/html" charset="UTF-8"/>
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

    <div style="">
        <form method="post" action="queryUserInUserPage.action">
            <table>
                <tr>
                    <td>用户名称：<input type="text" name="userName"/></td>
                    <td>学号：<input type="text" name="userIdentity"/></td>
                    <td>用户权限：<input type="number" max="4" min="-1" value="-1" name="userPermission"></td>
                    <td><input type="submit" value="查询"></td>
                    <td><a href="goToManagerAddUser.action">增加用户</a></td>
                </tr>
            </table>
        </form>
    </div>
    <% if (session.getAttribute("queryUsers") == null && (int)session.getAttribute("userPage") == 0){ %>
    <div style="color: blue; font-weight: bold">用户不存在</div>
    <% }else if (session.getAttribute("queryUsers") == null && (boolean)session.getAttribute("userLastPage")){ %>
    <div style="color: blue; font-weight: bold">已是最后一页</div>
    <div>
        <table>
            <tr>
                <td><% if ((boolean)session.getAttribute("userFirstPage")){ %>
                    <span>&nbsp;</span>
                    <% }else{ %>
                    <a href="firstUserPage.action">首页</a>
                    <% } %>
                </td>
                <td>
                    <% if ((boolean)session.getAttribute("userLastPage")){ %>
                    <span>&nbsp;</span>
                    <% }else{ %>
                    <a href="nextUserPage.action">下一页</a>
                    <% } %>
                </td>
                <td>
                    第<%= (int)session.getAttribute("userPage") + 1%>页
                </td>
                <td>
                    <% if ((boolean)session.getAttribute("userFirstPage")){ %>
                    <span>&nbsp;</span>
                    <% }else {%>
                    <a href="formUserPage.action">上一页</a>
                    <% } %>
                </td>
            </tr>
        </table>
    </div>
    <% }else { %>
        <% if (session.getAttribute("queryUsers") != null){ %>
        <div>
            <table border="1">
                <tr style="background-color: darkgray">
                    <td>姓名</td>
                    <td>登录账号</td>
                    <td>密码</td>
                    <td>邮件</td>
                    <td>学号</td>
                    <td>性别</td>
                    <td>年龄</td>
                    <td>权限</td>
                    <td>修改</td>
                </tr>
                    <% int i = 0; %>
                <s:iterator value="#session.queryUsers" status="st" var="user">
                <tr>
                    <td><a href="initUserBooks_DPage?which=<%=i%>"><s:property value="#user.userName"/></a></td>
                    <td><s:property value="#user.userAccount"/></td>
                    <td><s:property value="#user.userPassword"/></td>
                    <td><s:property value="#user.userEmail"/></td>
                    <td><s:property value="#user.userIdentity"/></td>
                    <td><s:property value="#user.userGender"/></td>
                    <td><s:property value="#user.userAge"/></td>
                    <td><s:property value="#user.userPermission"/></td>
                    <td><a href = "managerChooseUser.action?which=<%=i%>">修改</a></td>
                </tr>
                    <% i++; %>
                </s:iterator>
            </table>
        </div>
    <% } %>
    <div>
        <table>
            <tr>
                <td><% if ((boolean)session.getAttribute("userFirstPage")){ %>
                    <span>&nbsp;</span>
                    <% }else{ %>
                    <a href="firstUserPage.action">首页</a>
                    <% } %>
                </td>
                <td>
                    <% if ((boolean)session.getAttribute("userLastPage")){ %>
                    <span>&nbsp;</span>
                    <% }else{ %>
                    <a href="nextUserPage.action">下一页</a>
                    <% } %>
                </td>
                <td>
                    第<%= (int)session.getAttribute("userPage") + 1%>页
                </td>
                <td>
                    <% if ((boolean)session.getAttribute("userFirstPage")){ %>
                    <span>&nbsp;</span>
                    <% }else {%>
                    <a href="formUserPage.action">上一页</a>
                    <% } %>
                </td>
            </tr>
        </table>
    </div>
    <% } %>
</div>
</body>
</html>
