<%--
  Created by IntelliJ IDEA.
  User: Standard_lang
  Date: 2018/6/6
  Time: 15:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page import="java.util.*,com.sharebookssystem.bin.actions.*" contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%--<%@ taglib uri="/struts-tags" prefix="c" %>--%>
<!docType html>
<html>
<head>
    <title>showBooks</title>
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <script src="js/jquery-3.3.1.min.js"></script>
    <!-- Include all compiled plugins (below), or include individual files as needed -->
    <script src="js/bootstrap.min.js"></script>
    <script src="js/showInfo.js"></script>
    <link href="css/showBooks.css" rel="stylesheet">
</head>
<body>
    <header>

    </header>
    <div>
        <aside>

        </aside>
        <div class="allBook">
            <s:iterator value="personalbooks" status="st1" var="thebook">
                <%--111--%>
                <s:iterator value="books" status="st2" var="mybook">
                <s:if test="#st1.count==#st2.count">
                <div class="card oneBook" >
                    <%--<a href="javascript:showbookinfo('<s:property value="#mybook.bookId"/>')">--%>

                    <a class="bookImg" href="javascript:showbookinfobypersonalbookid('<s:property value="#thebook.personalBookId"/>')">
                            <%--<a href="ensureAddBookAction?book=+<s:property value='#mybook'/>">--%>
                        <%--<div class="bookImg">--%>
                            <img referrerpolicy ="no-referrer" alt="网络错误" src="<s:property value="#mybook.bookPicture"/>" class="card-img-top">
                        <%--</div>--%>
                    </a>
                        <div class="bookInfo">
                            <%--<s:property value="#mybook.bookPicture"/>--%>
                                <a class="bookName" href="javascript:showbookinfobypersonalbookid('<s:property value="#thebook.personalBookId"/>')">
                                    <img class="bookNameLeft" src="image/bookNamePic.png">
                                    <%--<img class="bookNameLeft" src="http://lorempixel.com/400/200/">--%>
                                    <div class="bookNameRight">
                                        <p class="realBookName"><s:property value="#mybook.bookName"/></p>
                                        <p class="bookAuthor"><s:property value="#mybook.bookAuthor"/></p>
                                    </div>
                                </a>
                                <p class="bookCategory">类别：<s:property value="#mybook.bookCategory"/></p>
                            <div class="bookBottom">
                                <img src="image/eyeTimes.png" class="eyeTimes" alt="">
                                <%--<img src="http://lorempixel.com/400/200/" class="eyeTimes" alt="">--%>
                                <span>
                                    <s:if test="#mybook.numberOfTimes">
                                        <s:property value="#mybook.numberOfTimes"/>
                                    </s:if>
                                    <s:else>0</s:else>

                                </span>
                                <img src="image/comment.png" class="comment" alt="">
                                <span>5</span>
                            </div>

                        </div>


                </div>
                </s:if>
                </s:iterator>
            </s:iterator>
        </div>

        <nav aria-label="Page navigation example" class="myNavPage" >
            <ul class="pagination justify-content-end">
                <c:choose>
                    <c:when test="${currentPage>1}">
                        <li class="page-item myPage">
                            <a class="page-link myPage" href="checkBookAction?pageNo=${currentPage-1}" tabindex="-1">
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
                                <a class="page-link myPage" style="background: #ed4259;color: #fff;" href="checkBookAction?pageNo=<s:property/>"><s:property/>
                                </a>
                            </li>
                        </s:if>
                        <s:else>
                            <li class="page-item myPage">
                                <a class="page-link myPage" href="checkBookAction?pageNo=<s:property/>"><s:property/>
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
                            <a class="page-link myPage" href="checkBookAction?pageNo=${currentPage+1}" >
                                &gt;</a>
                        </li></c:when>
                </c:choose>
            </ul>
        </nav>



    </div>
    <footer>

    </footer>
</body>
</html>
