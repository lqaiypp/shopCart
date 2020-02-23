<%@ page pageEncoding="utf-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="path" value="${pageContext.request.contextPath }">
</c:set>
<!DOCTYPE HTML>
<html>
<head>
    <meta charset="utf-8"/>
</head>
<body>&nbsp;
<!-- 头部 -->
<jsp:include page="/view/header.jsp"></jsp:include>
<div class="c2"> 欢迎${user.username } </div>

<!--  按条件搜索表单 -->
<center>
    <div>
        <form action="${path }/pro/pro_showAllProduct" method="post">
            ProductName:<input type="text" name="productName" value="${productName }"/>&nbsp;
            Price:<select name="opt">
            <option value="1">小于</option>
            <option value="2">大于</option>
        </select>
            <input type="text" name="price" size="6"/> &nbsp;&nbsp;
            <input type="submit" value="" class="b"/>
        </form>
    </div>
</center>

<table border="1" bordercolor="blue" cellspacing=0 align="center" width="70%">
    <tr align="center" bgcolor="lightblue">
        <td><b>Id</b></td>
        <td><b>Name</b></td>
        <td><b>图片</b></td>
        <td><b>Price</b></td>
        <td><b><img src="${path }/image/car_new.gif"/></b></td>
    </tr>
    <c:forEach items="${prods }" var="p">
        <tr align="center">
            <td>${p.id }</td>
            <td>${p.productName }</td>
            <td><img src="${path }${p.picpath }"/></td>
            <td>${p.price }</td>

            <td align="center"><a href="${path }/pro/pro_AddCart?productId=${p.id }"><img
                    src="${path }/image/car_new.gif"/></a></td>

        </tr>
    </c:forEach>
</table>
<p>&nbsp;</p>

<!-- 分页 -->
<center>
    <c:if test="${param.currentPage>1}">
        <a href="${path }/pro/pro_showAllProduct?currentPage=${param.currentPage-1}">上一页</a>
    </c:if>
    &nbsp;
    <!-- 前五页展示情况 -->
    <c:if test="${param.currentPage<=5 }">
        <c:forEach begin="1" end="10" var="p">
            <c:if test="${param.currentPage==p }">
                <a href="${path }/pro/pro_showAllProduct?currentPage=${p }"><font
                        style="color:red;font-size:24px;">${p }</font></a>
            </c:if>
            <c:if test="${param.currentPage!=p }">
                <a href="${path }/pro/pro_showAllProduct?currentPage=${p }">${p }</a>
            </c:if>
        </c:forEach>
    </c:if>
    <c:if test="${param.currentPage>5 }">
        <c:forEach begin="${param.currentPage-4 }" end="${param.currentPage+5 }" var="p">
            <c:if test="${param.currentPage==p }">
                <a href="${path }/pro/pro_showAllProduct?currentPage=${p }"><font
                        style="color:red;font-size:24px;">${p }</font></a>
            </c:if>
            <c:if test="${param.currentPage!=p }">
                <a href="${path }/pro/pro_showAllProduct?currentPage=${p }">${p }</a>
            </c:if>
        </c:forEach>
    </c:if>
    &nbsp;

    <a href="${path }/pro/pro_showAllProduct?currentPage=${param.currentPage+1}">下一页</a>
    <form action="${path }/pro/pro_showAllProduct" method>
        <input type="text" name="currentPage"/><input type="submit" value="到第几页"/>
    </form>
    &nbsp;

</center>

</body>
</html>