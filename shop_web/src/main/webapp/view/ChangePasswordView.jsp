<%@ page pageEncoding="utf-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="path" value="${pageContext.request.contextPath }">
</c:set>
<html>
<head>
    <meta charset="utf-8"/>
</head>
<body>&nbsp;
<c:if test="${user!=null }">
    <!-- 头部 -->
    <jsp:include page="/view/header.jsp"></jsp:include>


    <form method="post" action="${path }/a/ChangePasswordAction">
        <table cellpadding=3 cellspacing=1 align=center class=tableborder1>

            <tr bgcolor="lightblue">
                <td height=25 colspan=2 align="center" valign="middle"><font color="#ffffff"><b>输入您的原有密码,新密码</b></font>
                </td>
            </tr>
            <tr>
                <td valign="middle" class="tablebody1">请输入您的旧密码</td>
                <td valign="middle" class="tablebody1"><input name="oldPass" type="text"/></td>
            </tr>
            <tr>
                <td valign="middle" class="tablebody1">请输入您的新密码</td>
                <td valign="middle" class="tablebody1"><input name="newPass1" type="password"> &nbsp;</td>
            </tr>
            <tr>
                <td valign="middle" class="tablebody1">请再次输入您的新密码</td>
                <td valign="middle" class="tablebody1"><input name="newPass2" type="password"> &nbsp;</td>
            </tr>
            <tr>
                <td class="tablebody2" valign="middle" colspan=2 align=center><input type="submit" value="修改"></td>
            </tr>
        </table>
    </form>
    &nbsp;<br/>
</c:if>
<c:if test="${user==null }">
    <span>您还未登陆,请登录!!!</span>
</c:if>
</body>
</html>