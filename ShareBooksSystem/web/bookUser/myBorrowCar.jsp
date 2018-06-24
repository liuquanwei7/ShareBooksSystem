<%@ taglib prefix="s" uri="/struts-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: 10537
  Date: 2018/6/21
  Time: 20:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>myBorrowCar</title>
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <script src="js/jquery-3.3.1.min.js"></script>
    <!-- Include all compiled plugins (below), or include individual files as needed -->
    <script src="js/bootstrap.min.js"></script>
    <script src="js/borrowBook.js"></script>
    <script src="js/addInCar.js"></script>
    <script src="js/deleteFromCar.js"></script>
    <link href="css/mycss.css" rel="stylesheet">
</head>
<body>
<%--<a href="showMyBorrowCarAction" class="myCar">我的借阅车</a>--%>


<div>
    <%--aaadd--%>
    <%--<c:forEach items="bookAllInfo" var="bean">--%>
    <%--<c:forEach --%>
    <%----%>
    <%--</c:forEach>--%>
<%--<s:iterator value="collectCarItems" status="st3" var="collectCarItem">--%>
    <s:iterator value="personalbooks" status="st1" var="personalbook">
        <%--111--%>
        <s:iterator value="books" status="st2" var="book">
            <%--222--%>
            <%--<s:if test="#st1.count==#st2.count&&#st2.count==#st3.count">--%>
            <s:if test="#st1.count==#st2.count">
                <%--<% if(%><s:property value="#mybook.bookId"/><%){--%>
                <div class="card mycard">
                    <div class="bookImg">
                        <%--<img referrerpolicy="no-referrer" src="https://img3.doubanio.com/view/subject/m/public/s5968156.jpg>"--%>
                        <img referrerpolicy="no-referrer" src="<s:property value="#book.bookPicture"/>">
                    </div>
                    <div class="bookInfo">

                        <h1 class="bookName">
                            <em><s:property value="#book.bookName"/></em>
                            <span><s:property value="#book.bookAuthor"/>&nbsp著</span>
                        </h1>
                        <p>计算机:<s:property value="#book.bookCategory"/></p>
                        <p>出版社:<s:property value="#book.bookPublish"/></p>
                        <p id="storeStatus">在库状态：<s:property value="#personalbook.bookStatus"/></p>
                        <p class="bookTodo">
                            <%--<a href="javascript:borrowBook('<s:property value="#personalbook.personalBookId"/>')" class="borrowBook">借阅</a>--%>
                            <a href="javascript:borrowBook(<s:property value="#personalbook.personalBookId"/>,'<s:property value="#personalbook.bookStatus"/>')" class="borrowBook">借阅</a>

                            <%--<a onclick="borrowBook(<s:property value="#personalbook.personalBookId"/>--%>
                                <%--','<s:property value="#personalbook.bookStatus"/>)" class="borrowBook">借阅</a>--%>
                            <a href="javascript:deleteFromCar('<s:property value="#personalbook.personalBookId"/>')" class="addInCar">删除</a>

                        </p>


                    </div>
                    <div class="bookCommentSide">
                        <p><s:property value="personalBook.numberOfTimes"/></p>
                        <p>借阅热度</p>
                    </div>
                </div>
            </s:if>
        </s:iterator>
    </s:iterator>
<%--</s:iterator>--%>
</div>
</body>
</html>
