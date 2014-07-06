<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<html>
<head>
    <title>shiro demo</title>
</head>
<body>
<form action="${ctx}/login" method="post">
    User name:<input name="username" type="text" value="${username}">
    Password:<input name="password" type="password">
    <input type="submit" value="login">
</form>
</body>
</html>
