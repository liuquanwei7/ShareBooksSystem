<%@ taglib prefix="s" uri="/struts-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: Standard_lang
  Date: 2018/6/11
  Time: 18:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>ensureBookSuccess</title>
    <script type="text/javascript">
        window.onload=function ( ){
            shareCode=sessionStorage.shareCode;
            console.log(shareCode);
            document.getElementById("showCode").innerText="您的分享码为："+shareCode;
        }
    </script>
</head>
<body>
<s:include value="newNav.jsp"/>
<p style="margin: 0 auto;width: 500px;height: 100px;text-align: center;font-size: 20px;">
    加入购物车成功！！！
<h3>添加图书成功！！！</h3>
<p id="showCode"></p>
<p>请持分享码找操作员分享您的图书。</p>
</p>
</body>
</html>
