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
    <script src="js/addInCar.js"></script>
    <link href="css/mycss.css" rel="stylesheet">
    <link href="css/bookInfo.css" rel="stylesheet">
    <%--<style>--%>
        <%--#a_comment{--%>
            <%--display: inline-block;--%>
            <%--border: 1px solid #3f5a93;--%>
            <%--color: #3f5a93;--%>
            <%--text-align: center;--%>
            <%--width: 120px;--%>
            <%--height: 34px;--%>
            <%--text-decoration: none;--%>
            <%--vertical-align: middle;--%>
            <%--font-size: 14px;--%>
            <%--line-height: 28px;--%>
            <%--margin-right: 20px;--%>
        <%--}--%>
    <%--</style>--%>
</head>
<body>
    <header>
        <s:include value="newNav.jsp"/>
    </header>
    <div class="myBook" style="margin-top: 30px;">

            <s:iterator value="mybook" status="st" var="book">
                <s:iterator value="personalBook" status="st" var="personalbook">
                <%--<img src="<s:property value="#book.bookPicture">" class="card-img">--%>
                <div class="card mycard">
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
                        <p id="storeStatus">在库状态：<s:property value="#personalbook.bookStatus"/></p>
                        <p class="bookTodo">

                            <%--<a href="javascript:borrowBook('<s:property value="#personalbook.personalBookId"/>')" class="borrowBook">借阅</a>--%>
                            <a href="javascript:borrowBook(<s:property value="#personalbook.personalBookId"/>,'<s:property value="#personalbook.bookStatus"/>')" class="borrowBook">借阅</a>

                            <%--<a href="javascript:borrowBook('<s:property value="#personalbook.personalBookId"/>')" class="borrowBook">借阅</a>--%>
                            <a href="javascript:addInCar('<s:property value="#personalbook.personalBookId"/>')" class="addInCar">加入借阅车</a>
                            <%--<a href="" class="addInCar">加入借阅车</a>--%>




                            <%--<a onclick="borrowBook(<s:property value="#personalbook.personalBookId"/>--%>
                            <%--','<s:property value="#personalbook.bookStatus"/>)" class="borrowBook">借阅</a>--%>



                        </p>

                    </div>
                    <div class="bookCommentSide">
                        <p class="number"><s:property value="#personalbook.numberOfTimes"/></p>
                        <p style="font-size: 16px;margin-top: 10px;">借阅热度</p>
                    </div>
                </div>
                    <div class="bookSummary">
                        <p class="bookSummaryLeft">书籍信息</p>

                            <p class="bookSummaryRight">
                                <a href="../bookUi/aheadComment.jsp" id="a_comment">书籍评论</a>
                            </p>

                    </div>
                    <div class="bookSummaryInfo">
                        <s:property value="#book.bookSummary"/>
                    </div>
                </s:iterator>
            </s:iterator>


    </div>

    <footer></footer>
<%--<%session.removeAttribute("mybook");--%>
<%--session.removeAttribute("personalBook");%>--%>
</body>
</html>
