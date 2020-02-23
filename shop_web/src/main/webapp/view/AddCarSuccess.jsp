<%@ page pageEncoding="utf-8" %>
<%
    request.setAttribute("path", request.getContextPath());
%>
<html>
<head>
    <meta charset="utf-8">
    <style type="text/css">
        body {
            background-image: url("${path}/image/2.jpg");
            background-repeat: repeat
        }
    </style>
</head>
<body>
&nbsp;
<center>
    <img src="${path}/image/success.gif"/>
    <h1>已成功将${prod.productName }商品添加至购物车</h1>
    <h1>
        <a href="${path }/pro/pro_showAllProduct">继续购物</a>&nbsp;&nbsp; <a
            href="${path }/view/ShopCarView.jsp">去购物车结算</a>
    </h1>
</center>
</body>
</html>
