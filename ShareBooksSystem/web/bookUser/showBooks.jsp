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
</head>
<body>
    <header>

    </header>
    <div>
        <aside>

        </aside>
        <div>
            <%--aaadd--%>
            <%--<c:forEach items="bookAllInfo" var="bean">--%>
                <%--<c:forEach --%>
                <%----%>
            <%--</c:forEach>--%>
            <s:iterator value="personalbooks" status="st1" var="thebook">
                <%--111--%>
                <s:iterator value="books" status="st2" var="mybook">
                    <%--222--%>
                    <%--<s:iterator id="inner" value="top"></s:iterator>--%>
                    <%--<s:property value="#thebook.personalBookId"/>--%>
                    <%--<s:property value="#thebook.Book.bookId"/>aaa--%>
                    <%--<s:property value="#thebook.book.bookId"/>bbb--%>
                    <%--<s:property value="#thebook.shareCode"/>bbb--%>
                    <%--<s:property value="#mybook.bookId"/>bbb--%>
                <%--<s:if test="#thebook.book.bookId==#mybook.bookId">--%>
                <s:if test="#st1.count==#st2.count">
                    <%--<% if(%><s:property value="#mybook.bookId"/><%){--%>
                        <%--%>--%>
                        <%--<s:hidden value=""/>--%>
                        <%--<%  }--%>

                        <%--%>--%>
                <%--<s:property value="#thebook.personalBookId"/>bbb--%>
                <%--<s:property value="#thebook.book.bookId"/>sdas--%>
                <%--<s:property value="#thebook.Book.bookId"/>sdsdfas--%>
                <%--<s:property value="#thebook.User.userId"/>sdassdfds--%>
                <div class="card" style="width:300px;height: 600px" >
                    <%--<a href="javascript:showbookinfo('<s:property value="#mybook.bookId"/>')">--%>
                    <a href="javascript:showbookinfo('<s:property value="#thebook.personalBookId"/>')">
                            <%--<a href="ensureAddBookAction?book=+<s:property value='#mybook'/>">--%>
                        <img referrerpolicy ="no-referrer" alt="网络错误" src="<s:property value="#mybook.bookPicture"/>" class="card-img-top" style="width: 300px;height: 300px">
                        <div class="card-body">
                            <%--<s:property value="#mybook.bookPicture"/>--%>
                            <p class="card-text"><s:property value="#mybook.bookName"/></p>
                            <p class="card-text"><s:property value="#mybook.bookAuthor"/></p>
                            <p class="card-text"><s:property value="#mybook.bookCategory"/></p>
                            <p class="card-text"><s:property value="#mybook.bookPublish"/></p>
                            <p class="card-text"><s:property value="#mybook.bookPrice"/>元</p>

                        </div>
                    </a>
                </div>
                </s:if>
                </s:iterator>
            </s:iterator>
        </div>

    </div>
    <footer>

    </footer>
</body>
</html>
