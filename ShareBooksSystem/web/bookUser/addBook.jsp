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
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <script src="js/jquery-3.3.1.min.js"></script>
    <!-- Include all compiled plugins (below), or include individual files as needed -->
    <script src="js/bootstrap.min.js"></script>
    <script src="js/getBookInfoByISBN.js"></script>
</head>
<body>

    <form class="form-inline my-2 my-lg-0" >
        <input id="isbndata" class="form-control mr-sm-2" type="search" placeholder="输入书籍条形码上ISBN码（纯数字）"
               aria-label="Search" name="check_data">
        <button class="btn btn-outline-success my-2 my-sm-0" type="button" onclick="getBookInfo()">
            搜索
        </button>
    </form>
</body>
</html>
