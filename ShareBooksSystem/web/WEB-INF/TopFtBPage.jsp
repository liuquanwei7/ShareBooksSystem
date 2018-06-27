<%--
  Created by IntelliJ IDEA.
  User: Cammer
  Date: 2018/6/12
  Time: 16:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="s" uri="/struts-tags" %>
<%@ page import="java.util.List" %>
<html>
<head>
    <title>书籍借阅信息统计</title>
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
    <% List list = (List)session.getAttribute("topFtBData"); %>
    <div>
        <s:form action="initTopFtBPage" method="POST">
            <s:textfield name="startTime" label="最小日期边界"/>
            <s:textfield name="endTime" label="最大日期边界"/>
            <s:submit value="查询"/>
        </s:form>
    </div>
    <% if (session.getAttribute("topFtBData") == null && (int)session.getAttribute("topFtBPage") == 0){ %>
    <div style="color: blue; font-weight: bold">该时间段没有书籍被借阅</div>
    <% }else if (session.getAttribute("topFtBData") == null && (boolean)session.getAttribute("topFtBLastPage")){ %>
    <div style="color: blue; font-weight: bold">已是最后一页</div>
    <div>
        <table>
            <tr>
                <td><% if ((boolean)session.getAttribute("topFtBFirstPage")){ %>
                    <span>&nbsp;</span>
                    <% }else{ %>
                    <a href="firstTopFtBPage.action">首页</a>
                    <% } %>
                </td>
                <td>
                    <% if ((boolean)session.getAttribute("topFtBLastPage")){ %>
                    <span>&nbsp;</span>
                    <% }else{ %>
                    <a href="nextTopFtBPage.action">下一页</a>
                    <% } %>
                </td>
                <td>
                    第<%= (int)session.getAttribute("topFtBPage") + 1%>页
                </td>
                <td>
                    <% if ((boolean)session.getAttribute("topFtBFirstPage")){ %>
                    <span>&nbsp;</span>
                    <% }else {%>
                    <a href="formTopFtBPage.action">上一页</a>
                    <% } %>
                </td>
            </tr>
        </table>
    </div>
    <% }else {%>
    <div>
        <table border="1">
            <tr style="background-color: darkgray">
                <td>归属者姓名</td>
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
                <td><a href="initUserBooks_DPageT.action?which=<%=i%>"><%= line.get(2) %></a></td>
                <td><a href="initSameBook_BPage.action?which=<%=i%>"><%= line.get(3) %></a></td>
                <td><%= line.get(4) %></td>
                <td><%= line.get(5) %></td>
                <td><%= line.get(6) %></td>
                <td><%= line.get(7) %></td>
                <td><%= line.get(8) %></td>
            </tr>
            <% } %>
        </table>
    </div>
    <div>
        <table>
            <tr>
                <td><% if ((boolean)session.getAttribute("topFtBFirstPage")){ %>
                    <span>&nbsp;</span>
                    <% }else{ %>
                    <a href="firstTopFtBPage.action">首页</a>
                    <% } %>
                </td>
                <td>
                    <% if ((boolean)session.getAttribute("topFtBLastPage")){ %>
                    <span>&nbsp;</span>
                    <% }else{ %>
                    <a href="nextTopFtBPage.action">下一页</a>
                    <% } %>
                </td>
                <td>
                    第<%= (int)session.getAttribute("topFtBPage") + 1%>页
                </td>
                <td>
                    <% if ((boolean)session.getAttribute("topFtBFirstPage")){ %>
                    <span>&nbsp;</span>
                    <% }else {%>
                    <a href="formTopFtBPage.action">上一页</a>
                    <% } %>
                </td>
            </tr>
        </table>
    </div>
    <% } %>
</div>
</body>
</html>
