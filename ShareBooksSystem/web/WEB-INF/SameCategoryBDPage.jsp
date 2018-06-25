<%--
  Created by IntelliJ IDEA.
  User: Cammer
  Date: 2018/6/13
  Time: 22:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="s" uri="/struts-tags" %>
<%@ page import="java.util.List" %>
<html>
<head>
    <title>同一类别书籍的借阅统计</title>
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
    <div><a href="nowTopCategoryPage.action"><--返回</a></div>
    <% List list = (List)session.getAttribute("sameCategoryBData");%>

    <% if (session.getAttribute("sameCategoryBData") == null && (int)session.getAttribute("sameCategoryBDPage") == 0){ %>
    <div style="color: blue; font-weight: bold">查询出错</div>
    <% }else if (session.getAttribute("sameCategoryBData") == null && (boolean)session.getAttribute("sameCategoryBDLastPage")){ %>
    <div style="color: blue; font-weight: bold">已是最后一页</div>
    <div>
        <table>
            <tr>
                <td><% if ((boolean)session.getAttribute("sameCategoryBDFirstPage")){ %>
                    <span>&nbsp;</span>
                    <% }else{ %>
                    <a href="firstSameCategoryBDPage.action">首页</a>
                    <% } %>
                </td>
                <td>
                    <% if ((boolean)session.getAttribute("sameCategoryBDLastPage")){ %>
                    <span>&nbsp;</span>
                    <% }else{ %>
                    <a href="nextSameCategoryBDPage.action">下一页</a>
                    <% } %>
                </td>
                <td>
                    第<%= (int)session.getAttribute("sameCategoryBDPage") + 1%>页
                </td>
                <td>
                    <% if ((boolean)session.getAttribute("sameCategoryBDFirstPage")){ %>
                    <span>&nbsp;</span>
                    <% }else {%>
                    <a href="formSameCategoryBDPage.action">上一页</a>
                    <% } %>
                </td>
            </tr>
        </table>
    </div>
    <% }else if (session.getAttribute("sameCategoryBData") == null) { %>
    <div style="color: blue; font-weight: bold">你所查询的同样信息的书本借出情况为空</div>
    <% }else {%>
    <div>
        <table border="1">
            <tr style="background-color: darkgray">
                <td>书籍归属</td>
                <td>书名</td>
                <td>作者</td>
                <td>出版社</td>
                <td>价格</td>
                <td>类别</td>
                <td>次数</td>
            </tr>
            <% for (int i = 0; i < list.size(); i++) {%>
            <% List line = (List) list.get(i); %>
            <tr>
                <%--把每一列的值取出来并显示--%>
                <td><%= line.get(0) %></td>
                <td><%= line.get(1) %></td>
                <td><%= line.get(2) %></td>
                <td><%= line.get(3) %></td>
                <td><%= line.get(4) %></td>
                <td><%= line.get(5) %></td>
                <td><%= line.get(6) %></td>
            </tr>
            <% } %>
        </table>
    </div>
    <div>
        <table>
            <tr>
                <td><% if ((boolean)session.getAttribute("sameCategoryBDFirstPage")){ %>
                    <span>&nbsp;</span>
                    <% }else{ %>
                    <a href="firstSameCategoryBDPage.action">首页</a>
                    <% } %>
                </td>
                <td>
                    <% if ((boolean)session.getAttribute("sameCategoryBDLastPage")){ %>
                    <span>&nbsp;</span>
                    <% }else{ %>
                    <a href="nextSameCategoryBDPage.action">下一页</a>
                    <% } %>
                </td>
                <td>
                    第<%= (int)session.getAttribute("sameCategoryBDPage") + 1%>页
                </td>
                <td>
                    <% if ((boolean)session.getAttribute("sameCategoryBDFirstPage")){ %>
                    <span>&nbsp;</span>
                    <% }else {%>
                    <a href="formSameCategoryBDPage.action">上一页</a>
                    <% } %>
                </td>
            </tr>
        </table>
    </div>
    <% } %>
</div>
</body>
</html>
