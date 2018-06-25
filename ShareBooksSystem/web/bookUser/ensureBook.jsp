<%--
  Created by IntelliJ IDEA.
  User: Standard_lang
  Date: 2018/6/6
  Time: 15:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page import="java.util.*,com.sharebookssystem.bin.actions.*" contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!docType html>
<html>
<head>
    <title>ensureBook</title>

    <%--<style rel="stylesheet">--%>

        <%--/*#app{padding: 32px;}*/--%>
    <%--</style>--%>
    <%--<script src="js/homepage.js"></script>--%>
    <%--<script src="//unpkg.com/vue/dist/vue.js"></script>--%>
    <%--<script src="js/vue.js"></script>--%>
    <%--<script src="//unpkg.com/iview/dist/iview.min.js"></script>--%>
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <script src="js/jquery-3.3.1.min.js"></script>
    <!-- Include all compiled plugins (below), or include individual files as needed -->
    <script src="js/bootstrap.min.js"></script>
    <script src="js/chooseBook.js"></script>

    <script src="js/getBookInfoByISBN.js"></script>
    <%--<link href="//unpkg.com/iview/dist/styles/iview.css" rel="stylesheet">--%>
    <link href="css/ensureBook.css" rel="stylesheet" >
</head>
<body>
<header>
    <%--<s:include value="addBook.jsp"/>--%>
    <s:include value="newNav.jsp"/>
    <%--<s:include value="addBookNoNav.jsp"/>--%>

</header>
<div>
    <%--<aside>--%>

    <%--</aside>--%>
        <div class="searchIsbn">
            <form class="form-inline my-2 my-lg-0" >
                <input id="isbndata" class="form-control mr-sm-2" type="search" placeholder="输入书籍条形码上ISBN码（纯数字）"
                       aria-label="Search" name="check_data">
                <button class="btn btn-outline-success my-2 my-sm-0" type="button" onclick="getBookInfo()">
                    搜索
                </button>
            </form>
        </div>
    <div class="book-content">
        <s:iterator value="#session.book" status="st" var="mybook">
            <div class="card mycard" >

                    <%--'<s:property value="#mybook"/>'--%>
                <%--<a href="ensureAddBookAction?book=+<s:property value='#mybook'/>">--%>
                        <div class="bookImg">
                        <img referrerpolicy ="no-referrer" alt="网络错误" src="<s:property value="#mybook.bookPicture"/>">
                        </div>
                        <div class="bookInfo">
                            <h1 class="bookName">
                                <em><s:property value="#mybook.bookName"/></em>
                                <span><s:property value="#mybook.bookAuthor"/>&nbsp著</span>
                            </h1>
                            <p>类别:<s:property value="#mybook.bookCategory"/></p>
                            <p>出版社:<s:property value="#mybook.bookPublish"/></p>

                            <div id="app1">
                                <tooltip placement="top">
                                    <p class="bookSummary">简介：
                                        <s:property value="#mybook.bookSummary"/>
                                    </p>
                                    <div slot="content" style="white-space: normal;" >
                                        <p><s:property value="#mybook.bookSummary"/></p>
                                        <%--<p><i>Can customize the style</i></p>--%>
                                    </div>
                                </tooltip>
                            </div>
                            <%--<p class="bookSummary"></p>--%>
                            <%--<p class="storeStatus">在库状态：<s:property value="#personalbook.bookStatus"/></p>--%>
                            <%--<p class="card-text"><s:property value="#mybook.bookName"/></p>--%>
                            <%--<p class="card-text"><s:property value="#mybook.bookAuthor"/></p>--%>
                            <%--<p class="card-text"><s:property value="#mybook.bookCategory"/></p>--%>
                            <%--<p class="card-text"><s:property value="#mybook.bookPublish"/></p>--%>


                        </div>
                        <div class="bookCommentSide">
                                <%--<p><s:property value="personalBook.numberOfTimes"/></p>--%>
                                <%--<p>借阅热度</p>--%>
                            <p class="bookTodo">
                                    <%--<a href="javascript:getMyBook('<s:property value="#personalbook.personalBookId"/>')" class="borrowBook">索回</a>--%>
                                        <a href="javascript:chooseBook()" class="chooseBook">选择
                                        </a><%--<a href="javascript:getMyBook(<s:property value="#personalbook.personalBookId"/>,'<s:property value="#personalbook.bookStatus"/>')" class="borrowBook">索回</a>--%>
                                    <%--<a href="javascript:addInCar('<s:property value="#personalbook.personalBookId"/>')" class="addInCar">加入借阅车</a>--%>
                            </p>
                        </div>

                <%--</a>--%>
            </div>
        </s:iterator>
            <%--<div class="card" style="width:18rem;" >--%>
            <%--<a href="javascript:chooseBook('<s:property value="#book"/>')">--%>
            <%--<img src="" class="card-img-top">--%>
            <%--<div class="card-body">--%>
            <%--<p class="card-text"><s:property value="#book.bookName"/></p>--%>

            <%--</div>--%>
            <%--</a>--%>
            <%--</div>--%>
    </div>

</div>
<footer>

</footer>
<script>

    var Main = {

    }

    var Component = Vue.extend(Main)
    new Component().$mount('#app1')
</script>
</body>
</html>
