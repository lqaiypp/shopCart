<%@ page pageEncoding="utf-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
    request.setAttribute("path", request.getContextPath());
%>

<!DOCTYPE HTML>
<html>
<head>
    <meta charset="utf-8">
</head>
<body>&nbsp;

<jsp:include page="/view/header.jsp"></jsp:include>
<!-- 正文  -->

<form method="post" action="${path }/user/user_Login">
    <table cellpadding=3 cellspacing=1 align=center class=tableborder1>

        <tr bgcolor="lightblue">
            <td height=25 colspan=2 align="center" valign="middle"><font color="#ffffff"><b>输入您的用户名、密码登录</b></font></td>
        </tr>
        <tr>
            <td valign="middle" class="tablebody1">请输入您的用户名</td>
            <td valign="middle" class="tablebody1"><input name="username" type="text"/>
                &nbsp; <a href="${path }/view/CreateUserView.jsp">没有注册？</a></td>
        </tr>
        <tr>
            <td valign="middle" class="tablebody1">请输入您的密码</td>
            <td valign="middle" class="tablebody1"><input name="password" type="password"> &nbsp;
                <c:if test="${param.errorMsg!=null }">
                    <span color='#422993'>${param.errorMsg }</span>
                </c:if>
            </td>
        </tr>
        <tr>
            <td class="tablebody2" valign="middle" colspan=2 align=center><input type="submit" value="登 录"></td>
        </tr>
    </table>
</form>
&nbsp;<br/>
</body>
</html>