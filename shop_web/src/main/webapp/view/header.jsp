<%@ page pageEncoding="utf-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="path" value="${pageContext.request.contextPath }">
</c:set>
<!DOCTYPE HTML>
<html>
<head>

    <style type="text/css">
        .c1 {
            text-align: right;
            margin-right: 50px
        }

        .c2 {
            text-align: right;
            margin-right: 50px;
            color: blue;
            font-size: 150%
        }

        body {
            background-image: url("${path}/image/2.jpg");
            background-repeat: repeat
        }

        span {
            font-size: 30px;
            color: lightblue;
            font-weight: bolder;
            margin-left: 300px
        }

        .f {
            width: 150px;
            height: 70px
        }

        .d {
            text-align: center;
            word-spacing: 20px;
            width: 70%
        }

        img {
            border: none
        }

        .b {
            background-color: yellow;
            background-image: url("${path}/image/button12.gif");
            width: 60px;
            height: 30px;
            border: none
        }

    </style>
</head>
<body>&nbsp;

<!-- Title -->
<img src="${path }/image/zgc_px.jpg" align="middle" class="f"/>
<span>欢迎访问我的购物网站</span>
<hr/>


<!--  Menu Bar  -->
<center>
    <div class="d">
        <a href="${path }/pro/pro_showAllProduct"><img src="${path }/image/index.gif"/></a>
        <a href="${path }/view/UserManageView.jsp"><img src="${path }/image/reg.gif"/></a>
        <a href="${path }/view/ShopCarView.jsp"><img src="${path }/image/cart.gif"/></a>
        <a href=""><img src="${path }/image/order.gif"/></a>
        <a href="${path }/user/user_safeOut"><img src="${path }/image/exit.gif"/></a>
    </div>
</center>

</body>
</html>