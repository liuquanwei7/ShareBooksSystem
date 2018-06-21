<%@ taglib prefix="s" uri="/struts-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: Standard_lang
  Date: 2018/6/14
  Time: 16:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page  import="com.sharebookssystem.bin.actions.ShowBookInfoAction" contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>bookInfo</title>
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <script src="js/jquery-3.3.1.min.js"></script>
    <!-- Include all compiled plugins (below), or include individual files as needed -->
    <script src="js/bootstrap.min.js"></script>
    <script src="js/borrowBook.js"></script>
    <link href="css/mycss.css" rel="stylesheet">
</head>
<body>
    <header></header>
    <div>
        <div class="card mycard">
            <s:iterator value="mybook" status="st" var="book">
                <s:iterator value="personalBook" status="st" var="personalbook">
                <%--<img src="<s:property value="#book.bookPicture">" class="card-img">--%>
                <div class="bookImg">
                    <img referrerpolicy="no-referrer" src="https://img3.doubanio.com/view/subject/m/public/s5968156.jpg"
                     >
                </div>
                <div class="bookInfo">

                    <h1 class="bookName">
                        <em><s:property value="#book.bookName"/></em>
                        <span><s:property value="#book.bookAuthor"/>&nbsp著</span>
                    </h1>
                    <p>计算机:<s:property value="#book.bookCategory"/></p>
                    <p>出版社:<s:property value="#book.bookPublish"/></p>
                    <p>在库状态：<s:property value="#personalbook.bookStatus"/></p>
                    <p class="bookTodo">
                        <a href="javascript:borrowBook('<s:property value="#personalbook.personalBookId"/>')" class="borrowBook">借阅</a>
                        <a href="" class="addInCar">加入借阅车</a>

                    </p>

                
                </div>
                <div class="bookCommentSide">
                    <p><s:property value="personalBook.numberOfTimes"/></p>
                    <p>借阅热度</p>
                </div>
                </s:iterator>
            </s:iterator>
        </div>

    </div>

    <footer></footer>
</body>
</html>
