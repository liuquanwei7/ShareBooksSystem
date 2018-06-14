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
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <script src="js/jquery-3.3.1.min.js"></script>
    <!-- Include all compiled plugins (below), or include individual files as needed -->
    <script src="js/bootstrap.min.js"></script>
    <script src="js/chooseBook.js"></script>

</head>
<body>
<header>

</header>
<div>
    <aside>

    </aside>
    <div>
        <s:iterator value="book" status="st" var="mybook">
            <div class="card" style="width:300px;height: 600px" >
                <a href="javascript:chooseBook('<s:property value="#mybook"/>')">
                <%--<a href="ensureAddBookAction?book=+<s:property value='#mybook'/>">--%>
                    <img referrerpolicy ="no-referrer" alt="网络错误" src="<s:property value="#mybook.bookPicture"/>" class="card-img-top" style="width: 300px;height: 300px">
                    <div class="card-body">
                        <p class="card-text"><s:property value="#mybook.bookName"/></p>
                        <p class="card-text"><s:property value="#mybook.bookAuthor"/></p>
                        <p class="card-text"><s:property value="#mybook.bookCategory"/></p>
                        <p class="card-text"><s:property value="#mybook.bookPublish"/></p>
                        <p class="card-text"><s:property value="#mybook.bookPrice"/>元</p>

                    </div>
                </a>
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
</body>
</html>
