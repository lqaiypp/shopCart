<%@ page pageEncoding="utf-8" %>
<%
    request.setAttribute("path", request.getContextPath());
%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <meta charset="utf-8"/>
</head>
<body>&nbsp;

<!-- 头部 -->
<jsp:include page="/view/header.jsp"></jsp:include>
<!-- 正文 -->
<table width="100%" height="300" align="center" cellpadding="3" cellspacing="1" class="tableborder1">
    <tr>
        <td width="100%" height="25" align="center" valign="middle" bgcolor="lightblue">
            <font color="#ffffff"><b>用户管理</b></font></td>
    </tr>
    <tr>

        <td class="tablebody2" valign="middle" align="center">
            <table width="163" border="0" align="center">
                <c:if test="${user==null }">
                    <tr>
                        <td height="30" align="center"><a href="${path }/view/CreateUserView.jsp">用户注册</a></td>
                    </tr>
                </c:if>
                <c:if test="${user==null }">
                    <tr>
                        <td height="30" align="center"><a href="${path }/view/LoginView.jsp">用户登录</a></td>
                    </tr>
                </c:if>
                <tr>
                    <td height="30" align="center"><a href="${path }/view/ChangePasswordView.jsp">修改密码</a></td>
                </tr>
                <tr>
                    <td height="30" align="center"><a href="${path }/view/ChangeUserMessageView.jsp">修改个人信息</a></td>
                </tr>
            </table>

        </td>
    </tr>
</table>
</body>
</html>
