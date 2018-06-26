<%@ taglib prefix="s" uri="/struts-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: Standard_lang
  Date: 2018/6/7
  Time: 17:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>addBook</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <script src="js/bootstrap.min.js"></script>
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <script src="js/jquery-3.3.1.min.js"></script>
    <%--<link rel="stylesheet" href="/bookUi/css/UserInfor.css"/>--%>
    <%--<link rel="stylesheet" href="/bookUi/css/home.css">--%>
    <script src="js/getBookInfoByISBN.js"></script>



</head>
<body>
<%--<div class="">--%>
<%--<div>--%>
    <%--&lt;%&ndash;<s:include value="newNav.jsp"/>&ndash;%&gt;--%>
    <%--&lt;%&ndash;&lt;%&ndash;<jsp:include page="nav.jsp"/>&ndash;%&gt;<script src="/bookUi/js/homepage.js"></script>&ndash;%&gt;--%>
    <%--&lt;%&ndash;<s:include value="nav.jsp"/>&ndash;%&gt;--%>
    <%--&lt;%&ndash;<link rel="stylesheet" href="css/nav.css">&ndash;%&gt;--%>
    <%--&lt;%&ndash;<link rel="stylesheet" href="/bookUi/css/fixed.css" />&ndash;%&gt;--%>

    <%--&lt;%&ndash;<link href="css/bootstrap.min.css" rel="stylesheet">&ndash;%&gt;--%>
    <%--&lt;%&ndash;<script src="js/jquery-3.3.1.min.js"></script>&ndash;%&gt;--%>
    <%--&lt;%&ndash;&lt;%&ndash;<!-- Include all compiled plugins (below), or include individual files as needed -->&ndash;%&gt;&ndash;%&gt;--%>
    <%--&lt;%&ndash;&lt;%&ndash;<script src="https://unpkg.com/popper.js/dist/umd/popper.min.js"></script>&ndash;%&gt;&ndash;%&gt;--%>

    <%--&lt;%&ndash;<script src="https://cdn.bootcss.com/popper.js/1.12.5/umd/popper.min.js"></script>&ndash;%&gt;--%>

    <%--&lt;%&ndash;<script src="js/popper.min.js"></script>&ndash;%&gt;--%>




<%--</div>--%>
<div>
    <form class="form-inline my-2 my-lg-0" >
        <input id="isbndata" class="form-control mr-sm-2" type="search" placeholder="输入书籍条形码上ISBN码（纯数字）"
               aria-label="Search" name="check_data">
        <button class="btn btn-outline-success my-2 my-sm-0" type="button" onclick="getBookInfo()">
            搜索
        </button>
    </form>
</div>
<%--</div>--%>
</body>
</html>
