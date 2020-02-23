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


    <form method="post" action="${path }/a/ChangeUserAction">
        <table cellpadding="3" cellspacing="1" align="center" class="tableborder1" id="table1">
            <tr>
                <td valign="middle" colspan="2" align="center" height="25" bgcolor="lightblue">
                    <font color="#ffffff"><b>修改个人信息</b></font></td>
            </tr>


            <tr>
                <td width="40%" class="tablebody1"><b>用户名</b>：</td>
                <td width="60%" class="tablebody1">
                    <input type="text" name="username" maxlength="16" size="32" value="luxw"
                           style="font-family: Tahoma,Verdana,宋体; font-size: 12px; line-height: 15px; color: #000000">
                </td>
            </tr>
            <tr>
                <td width="40%" class="tablebody1"><b>密码</b>:</td>
                <td width="60%" class="tablebody1">
                    <input type="text" name="password" size="32" value="1234"
                           style="font-family: Tahoma,Verdana,宋体; font-size: 12px; line-height: 15px; color: #000000">
                </td>
            </tr>
            <tr>
                <td class="tablebody1"><b>真实姓名</b>：</td>
                <td class="tablebody1">
                    <input type="text" name="name" maxlength="32" size="64" value="luxiaowei"
                           style="font-family: Tahoma,Verdana,宋体; font-size: 12px; line-height: 15px; color: #000000">
                </td>
            </tr>
            <tr>
                <td class="tablebody1"><b>联系地址</b>：</td>
                <td class="tablebody1">
                    <input type="text" name="address" maxlength="32" size="64" value="亮马桥"
                           style="font-family: Tahoma,Verdana,宋体; font-size: 12px; line-height: 15px; color: #000000">
                </td>
            </tr>
            <tr>
                <td class="tablebody1"><b>邮编</b>：</td>
                <td class="tablebody1">
                    <input type="text" name="zip" maxlength="8" size="32" value="100000"
                           style="font-family: Tahoma,Verdana,宋体; font-size: 12px; line-height: 15px; color: #000000">
                </td>
            </tr>
            <tr>
                <td class="tablebody2" valign="middle" colspan="2" align="center">
                    <input type="submit" value="修改"></td>
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