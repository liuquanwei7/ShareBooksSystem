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
    <%--<script src="//unpkg.com/vue/dist/vue.js"></script>--%>
    <%--<script src="//unpkg.com/iview/dist/iview.min.js"></script>--%>
    <%--<link href="//unpkg.com/iview/dist/styles/iview.css" rel="stylesheet">--%>

    <link href="css/bootstrap.min.css" rel="stylesheet">
    <script src="js/jquery-3.3.1.min.js"></script>
    <!-- Include all compiled plugins (below), or include individual files as needed -->
    <script src="js/bootstrap.min.js"></script>
    <script src="js/getMyBook.js"></script>
    <script src="js/showInfo.js"></script>
    <%--<script src="js/deleteFromCar.js"></script>--%>
    <link href="css/myBookCss.css" rel="stylesheet">
</head>
<body>
<header>
    <s:include value="newNav.jsp"/>
</header>
<p style="text-align: center;font-size: 22px;margin-top: 20px;margin-bottom: 10px;">我的书籍</p>
    <div class="book-content">

            <s:iterator value="books" status="st1" var="book">
                <s:iterator value="personalbooks" status="st2" var="personalbook">
                    <s:if test="#st1.count==#st2.count">
                <div class="card mycard">
                    <%--<img src="<s:property value="#book.bookPicture">" class="card-img">--%>
                        <a class="toBook" href="javascript:showbookinfobypersonalbookid('<s:property value="#personalbook.personalBookId"/>')">
                            <div class="bookImg">
                            <%--<img referrerpolicy="no-referrer" src="https://img3.doubanio.com/view/subject/m/public/s5968156.jpg"--%>
                            <%-->--%>
                        <img referrerpolicy="no-referrer" src="<s:property value="#book.bookPicture"/>">
                        </div></a>
                    <div class="bookInfo">

                        <h1 class="bookName">
                            <a class="toBook" href="javascript:showbookinfobypersonalbookid('<s:property value="#personalbook.personalBookId"/>')">
                            <em><s:property value="#book.bookName"/></em></a>
                            <span><s:property value="#book.bookAuthor"/>&nbsp著</span>

                        </h1>
                        <p>计算机:<s:property value="#book.bookCategory"/></p>
                        <p>出版社:<s:property value="#book.bookPublish"/></p>
                        <p class="storeStatus">在库状态：<s:property value="#personalbook.bookStatus"/></p>



                    </div>
                    <div class="bookCommentSide">
                        <%--<p><s:property value="personalBook.numberOfTimes"/></p>--%>
                        <%--<p>借阅热度</p>--%>
                            <p class="bookTodo">
                                    <%--<a href="javascript:getMyBook('<s:property value="#personalbook.personalBookId"/>')" class="borrowBook">索回</a>--%>
                                <a href="javascript:getMyBook(<s:property value="#personalbook.personalBookId"/>,'<s:property value="#personalbook.bookStatus"/>')" class="borrowBook">索回</a>
                                    <%--<a href="javascript:addInCar('<s:property value="#personalbook.personalBookId"/>')" class="addInCar">加入借阅车</a>--%>
                            </p>
                    </div>
                </div>
                    </s:if>
                </s:iterator>
            </s:iterator>

        <nav aria-label="Page navigation example" class="myNavPage" >
            <ul class="pagination justify-content-end">
                <c:choose>
                    <c:when test="${currentPage>1}">
                    <li class="page-item myPage">
                        <a class="page-link myPage" href="showMyBookAction?pageNo=${currentPage-1}" tabindex="-1">
                            &lt;</a>
                    </li></c:when>
                </c:choose>
                <%--<s:set value="#totalPage"  name="totalPage" var="totalPage"/>--%>
                <s:bean name="org.apache.struts2.util.Counter">
                    <s:param name="first" value="1" />
                    <%--<s:param name="last" value="${totalPage}" />--%>
                    <s:param name="last" value='totalPage'/>
                    <%--#totalPage--%>
                    <s:iterator>
                        <%--<s:if test="%{#currentPage==current}">--%>
                        <%--<c:when test="${currentPage==(current-1)}">--%>
                            <s:if test="%{currentPage==(current-1)}">
                            <%--current--%>
                            <li class="page-item myPage" style="background: #ed4259;color: #fff;">
                                <a class="page-link myPage" style="background: #ed4259;color: #fff;" href="showMyBookAction?pageNo=<s:property/>"><s:property/>
                                </a>
                            </li>
                            </s:if>
                        <s:else>
                            <li class="page-item myPage">
                                <a class="page-link myPage" href="showMyBookAction?pageNo=<s:property/>"><s:property/>
                                </a>
                            </li>
                        </s:else>
                    </s:iterator>
                </s:bean>

                <%--<li class="page-item myPage"><a class="page-link myPage" href="#">2</a></li>--%>
                <%--<li class="page-item myPage"><a class="page-link myPage" href="#">3</a></li>--%>
                <c:choose>
                    <c:when test="${currentPage<totalPage}">
                        <li class="page-item  myPage">
                            <a class="page-link myPage" href="showMyBookAction?pageNo=${currentPage+1}" >
                                &gt;</a>
                        </li></c:when>
                </c:choose>
            </ul>
        </nav>


    </div>

</body>
</html>
