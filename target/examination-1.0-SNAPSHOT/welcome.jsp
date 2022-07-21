<%--
  User: Mr_X
  Date: 2022/6/28
  Time: 15:24
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>主页</title>
</head>
<body>
<c:if test="${isStu == false}">
    <h1>${loginTeacher.name}老师，欢迎您~</h1>
    <span>详细信息</span>
    <span>${loginTeacher}</span>
</c:if>
<c:if test="${isStu == true}">
    <h1>${loginStu.name}同学，欢迎您~</h1>
    <span>详细信息</span>
    <span>${loginStu}</span>
</c:if>

</body>
</html>
