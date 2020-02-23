<%@ page pageEncoding="utf-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="path" value="${pageContext.request.contextPath }">
</c:set>
<html>
<head>
    <meta charset="utf-8"/>
    <script src="${path }/js/shopcar.js"></script>

</head>
<body>&nbsp;
<!-- 头部 -->
<jsp:include page="/view/header.jsp"></jsp:include>

<!-- 正文 -->
<form action="${path }/pro/pro_UpdateMount" method="post">
    <table border="1" bordercolor="blue" cellspacing="0" align="center" width="80%">
        <tbody id="tbody">
        <tr bgcolor="lightblue" align="center">
            <td><b>&nbsp;</b></td>
            <td><b>商品编号</b></td>
            <td><b>商品名称</b></td>
            <td><b>图片</b></td>
            <td><b>商品单价</b></td>
            <td><b>数量</b></td>
            <td><b>总价</b></td>
            <td><b>删除</b></td>
        </tr>
        <c:forEach items="${sessionScope.cart }" var="c">
            <tr align="center">
                <td><input type="checkbox" name="pIds" value="${c.value.product.id }"/></td>
                <td>${c.value.product.id }</td>
                <td>${c.value.product.productName }</td>
                <td><img src="..${c.value.product.picpath }"/></td>
                <td>${c.value.product.price }</td>
                <td>
                    <input type="button" value="-" onclick="sub(this);"/><input type="text" name="pAmounts"
                                                                                value="${c.value.mount }" size="1"
                                                                                maxlength="1" name="1"/><input
                        type="button" value="+" onclick="add(this);"/>
                </td>
                <td>${c.value.totlePrice }</td>
                <td><a href="${path }/pro/pro_DeleteOne?productId=${c.value.product.id }"><input type="button"
                                                                                                 value="delete"/></a>
                </td>
            </tr>
        </c:forEach>
        <tr align="center">
            <td colspan="7">
                <input type="button" value="选中所有行" onclick="selectAll();"/>
                <input type="button" value="取消选中" onclick="quxiao();"/>
                <input type="button" value="删除选中的行" onclick="deleteSelected();"/>
            </td>
        </tr>
        </tbody>
    </table>
    <center><p><input type="submit" onclick="selectAll();" value="提交修改"/></p></center>
</form>

<table border="1" bordercolor="blue" cellspacing="0" align="center" width="80%">
    <tbody id="tbody">
    <tr bgcolor="lightblue" align="center">
        <td><b>&nbsp;</b></td>
        <td><b>商品编号</b></td>
        <td><b>商品名称</b></td>
        <td><b>图片</b></td>
        <td><b>商品单价</b></td>
        <td><b>数量</b></td>
        <td><b>总价</b></td>
        <td><b>删除</b></td>
    </tr>
    <c:forEach items="${sessionScope.deleteCart }" var="c">
        <tr align="center">
            <td><input type="checkbox" name="productId" value="${c.value.product.id }"/></td>
            <td>${c.value.product.id }</td>
            <td>${c.value.product.productName }</td>
            <td><img src="..${c.value.product.picpath }"/></td>
            <td>${c.value.product.price }</td>
            <td>
                <input type="button" value="-" onclick="sub(this);"/><input type="text" name="pId"
                                                                            value="${c.value.mount }" size="1"
                                                                            maxlength="1" name="1"/><input type="button"
                                                                                                           value="+"
                                                                                                           onclick="add(this);"/>
            </td>
            <td>${c.value.totlePrice }</td>
            <td><a href="${path }/pro/pro_RecoveryOneCart?productId=${c.value.product.id }"><input type="button"
                                                                                                   value="恢复"/></a></td>
        </tr>
    </c:forEach>
    <tr align="center">
        <td colspan="7">
            <input type="button" value="选中所有行" onclick="selectAll();"/>
            <input type="button" value="取消选中" onclick="quxiao();"/>
            <input type="button" value="删除选中的行" onclick="deleteSelected();"/>
        </td>
    </tr>
    </tbody>
</table>

</body>
</html>