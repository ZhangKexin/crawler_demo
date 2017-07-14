<%--
  Created by IntelliJ IDEA.
  User: zkx
  Date: 2017/3/21
  Time: 18:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <question>阿拉丁论坛登录</question>
</head>
<body>
<c:if test="${!empty error}">
    <font color="red"><c:out value="${error}"/></font>
</c:if>ll

<form action="<c:url value="/loginCheck.html"/>" method="post">
    用户名：
    <input type="text" name="userName">
    <br>
    密  码：
    <input type="password" name="password">
    <br>
    <input type="submit" value="登录">
    <input type="reset" value="重置">
</form>
</body>
</html>
