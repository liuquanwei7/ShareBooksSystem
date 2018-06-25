<%--
  Created by IntelliJ IDEA.
  User: LiuQuanwei
  Date: 2018/6/22
  Time: 21:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">

<html>
<head>
    <title>查询管理员信息</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://cdn.bootcss.com/bootstrap/4.1.0/css/bootstrap.min.css">
    <link rel="stylesheet" href="/bookManagement/css/queryManagerInfo.css">
    <script src="/bookManagement/js/queryManagerInfo.js"></script>
    <script src="https://cdn.bootcss.com/jquery/3.2.1/jquery.min.js"></script>
    <script src="https://cdn.bootcss.com/popper.js/1.12.5/umd/popper.min.js"></script>
    <script src="https://cdn.bootcss.com/bootstrap/4.1.0/js/bootstrap.min.js"></script>
    <script type="text/javascript">

        window.onload=function (){

            var str = "<%=session.getAttribute("managerInfoShow") %>".toString();
            if(str=="null"||str==""){

            }
            else{
                document.getElementById("show").style.display = "block";
            }
        }
    </script>
</head>
<body>
<div id="top">
    <jsp:include page="manager_top.jsp" flush="true" />
</div>
    <div id="all">
        <div id="left">
            <jsp:include page="admin_left.jsp" flush="true" />
        </div>
        <div id="main">
            <div class="container" id="queryManager_title">
                <h3 class="display-5">管理管理员信息</h3>
            </div>
            <div id="mainContent">
                <div id="formShow">
                    <form method="post" action="queryManagerInfoAction.action" namespace="/bookManagement">
                        <div class="form-inline" id="account">
                            <label>邮箱账户:</label>
                            <input type="text" class="form-control"  name="manager.managerAccount">
                        </div>
                        <br/>
                        <div class="form-inline" id="mPosition">
                            <label>职位:</label>
                            <div class="radio">
                                <label>
                                    <input type="radio" name="manager.managerPermission" id="manager" value=0>管理员
                                </label>
                            </div>
                            <div class="radio">
                                <label>
                                    <input type="radio" name="manager.managerPermission" id="operator" value=1>操作员
                                </label>
                                <input type="radio" name="manager.managerPermission" id="defaultHide" value=2 checked>
                            </div>
                        </div>
                        <br/>
                        <span class="text-danger" id="queryError"><s:property value="#session.managerInfoError"/></span>
                        <div id="queryButton">
                            <button type="reset" class="btn btn-primary" id="reset">重置</button>&nbsp&nbsp
                            <button type="submit" class="btn btn-primary" id="query">查询</button>
                        </div>

                    </form>
                </div>
                <div id="show">
                    <table class="table table-bordered table-hover" >
                        <tr>
                            <th>id</th><th>管理员账号</th><th>管理员姓名</th><th>年龄</th><th>性别</th><th>职位</th><th>操作</th>
                        </tr>
                        <s:iterator value="#session.managerInfo" status="st" var="manager" >
                            <tr>
                                <td><s:property value="#manager.managerId"/></td>
                                <td><s:property value="#manager.managerAccount"/></td>
                                <td><s:property value="#manager.managerName"/></td>
                                <td><s:property value="#manager.managerAge"/></td>
                                <td><s:property value="#manager.managerGender"/></td>
                                <td><s:property value="#manager.managerPermission"/></td>
                                <td>
                                    <a href="javascript:updateManagerInfo('<s:property value="#manager.managerId"/>')" class="text-primary">修改</a>
                                    <a href="javascript:deleteManagerInfo('<s:property value="#manager.managerId"/>')" class="text-primary">删除</a>
                                </td>
                            </tr>
                        </s:iterator>
                    </table>
                    <div id="byPage">
                        <ul class="pagination">
                            <li class="page-item"><a class="page-link" href="queryManagerInfoByPageAction?pageNo=1">首页</a></li>
                            <c:choose>
                                <c:when test="${currentPage>1}">
                                    <li class="page-item"><a class="page-link" href="queryManagerInfoByPageAction?pageNo=${currentPage-1}">上一页</a></li>
                                </c:when>
                            </c:choose>
                            <c:choose>
                                <c:when test="${currentPage<totalPage}">
                                    <li class="page-item"><a class="page-link" href="queryManagerInfoByPageAction?pageNo=${currentPage+1}">下一页</a></li>
                                </c:when>
                            </c:choose>
                            <li class="page-item"><a class="page-link" href="queryManagerInfoByPageAction?pageNo=${totalPage}">尾页</a></li>
                        </ul>
                    </div>
                    <span class="text-info" id="spanError"><s:property value="#session.managerInfoPageError"/></span>
                </div>
            </div>
        </div>
    </div>

        <% session.removeAttribute("managerInfoPageError"); %>
        <% session.removeAttribute("managerInfoShow"); %>
        <% session.removeAttribute("managerInfoError"); %>
</body>
</html>
