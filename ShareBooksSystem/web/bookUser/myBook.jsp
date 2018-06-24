<%@ taglib prefix="s" uri="/struts-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: 10537
  Date: 2018/6/22
  Time: 16:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>MyBook</title>
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <script src="js/jquery-3.3.1.min.js"></script>
    <!-- Include all compiled plugins (below), or include individual files as needed -->
    <script src="js/bootstrap.min.js"></script>
    <script src="js/getMyBook.js"></script>
    <%--<script src="js/addInCar.js"></script>--%>
    <%--<script src="js/deleteFromCar.js"></script>--%>
    <link href="css/mycss.css" rel="stylesheet">
</head>
<body>
    <div>

            <s:iterator value="books" status="st1" var="book">
                <s:iterator value="personalbooks" status="st2" var="personalbook">
                    <s:if test="#st1.count==#st2.count">
                <div class="card mycard">
                    <%--<img src="<s:property value="#book.bookPicture">" class="card-img">--%>
                    <div class="bookImg">
                            <%--<img referrerpolicy="no-referrer" src="https://img3.doubanio.com/view/subject/m/public/s5968156.jpg"--%>
                            <%-->--%>
                        <img referrerpolicy="no-referrer" src="<s:property value="#book.bookPicture"/>">
                    </div>
                    <div class="bookInfo">

                        <h1 class="bookName">
                            <em><s:property value="#book.bookName"/></em>
                            <span><s:property value="#book.bookAuthor"/>&nbsp著</span>
                        </h1>
                        <p>计算机:<s:property value="#book.bookCategory"/></p>
                        <p>出版社:<s:property value="#book.bookPublish"/></p>
                        <p class="storeStatus">在库状态：<s:property value="#personalbook.bookStatus"/></p>
                        <p class="bookTodo">
                            <%--<a href="javascript:getMyBook('<s:property value="#personalbook.personalBookId"/>')" class="borrowBook">索回</a>--%>
                                <a href="javascript:getMyBook(<s:property value="#personalbook.personalBookId"/>,'<s:property value="#personalbook.bookStatus"/>')" class="borrowBook">索回</a>
                            <%--<a href="javascript:addInCar('<s:property value="#personalbook.personalBookId"/>')" class="addInCar">加入借阅车</a>--%>

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


    </div>

</body>
</html>
