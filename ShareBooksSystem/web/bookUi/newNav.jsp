<%--
  Created by IntelliJ IDEA.
  User: 10537
  Date: 2018/6/25
  Time: 23:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <%--<script src="//unpkg.com/vue/dist/vue.js"></script>--%>
    <script src="js/vue.js"></script>
    <script src="//unpkg.com/iview/dist/iview.min.js"></script>
    <link href="//unpkg.com/iview/dist/styles/iview.css" rel="stylesheet">
    <link href="css/newNav.css" rel="stylesheet">

</head>
<body>
<div id="app" class="apps">

    <i-menu mode="horizontal" :theme="theme1" active-name="1" >
        <img class="uiImg" src="img/logo.png"/>
        <div id="logo_text"><a href="aheadhome.jsp"><span class="himb">&nbsp;HIMB</span></a></div>
        <%--<menu-item name="1" style="float: right;">--%>
        <%--<icon type="ios-paper"></icon>--%>
        <%--内容管理--%>
        <%--</menu-item>--%>
        <%--<menu-item name="2"  style="float: right;">--%>
        <%--<icon type="ios-people"></icon>--%>
        <%--用户管理--%>
        <%--</menu-item>--%>
        <menu-item name="3" style="float: right;">
            <icon type="exit"></icon>
            <a href="homepage.jsp"> 退出</a>
        </menu-item>
        <menu-item name="3" style="float: right;">
            <icon type="settings"></icon>
            借阅车
        </menu-item>


        <submenu name="2" style="float: right;">
            <template slot="title">
                <icon type="stats-bars"></icon>
                个人信息
            </template>
            <a href="UserInfor.jsp"><menu-item name="2-1">个人中心</menu-item></a>
            <a href="ChangePerson.jsp"><menu-item name="2-2">管理信息</menu-item></a>
            <%--<menu-group title="使用">--%>
            <%--<a href="addBook.jsp"><menu-item name="3-1">新增和启动</menu-item></a>--%>
            <%--<menu-item name="3-2">活跃分析</menu-item>--%>
            <%--<menu-item name="3-3">时段分析</menu-item>--%>
            <%--</menu-group>--%>
            <%--<menu-group title="留存">--%>
            <%--<menu-item name="3-4">用户留存</menu-item>--%>
            <%--<menu-item name="3-5">流失用户</menu-item>--%>
            <%--</menu-group>--%>
        </submenu>
        <submenu name="1" style="float: right;">
            <template slot="title">
                <icon type="stats-bars"></icon>
                图书
            </template>
            <a href="borrows.jsp"><menu-item name="1-1">已借图书</menu-item></a>
            <a href="addBook.jsp"><menu-item name="1-2">个人图书</menu-item></a>
            <a href="addBook.jsp"><menu-item name="1-3">添加图书</menu-item></a>
            <%--<menu-group title="使用">--%>
            <%--<a href="addBook.jsp"><menu-item name="3-1">新增和启动</menu-item></a>--%>
            <%--<menu-item name="3-2">活跃分析</menu-item>--%>
            <%--<menu-item name="3-3">时段分析</menu-item>--%>
            <%--</menu-group>--%>
            <%--<menu-group title="留存">--%>
            <%--<menu-item name="3-4">用户留存</menu-item>--%>
            <%--<menu-item name="3-5">流失用户</menu-item>--%>
            <%--</menu-group>--%>
        </submenu>


    </i-menu>
    <br>
    <%--<p>Change theme</p>--%>
    <%--<radio-group v-model="theme1">--%>
    <%--<radio label="light"></radio>--%>
    <%--<radio label="dark"></radio>--%>
    <%--<radio label="primary"></radio>--%>
    <%--</radio-group>--%>
</div>
<script>
    var Main = {
        data () {
            return {
                theme1: 'light'
            }
        }
    }

    var Component = Vue.extend(Main)
    new Component().$mount('#app')
</script>
</body>
</html>
