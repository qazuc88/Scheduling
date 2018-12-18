<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Hello</title>
</head>
<body>
Hello, we have ${count} visits:
<ul>
    <c:forEach var="user" items="${users}">
        <li>${user.name}</li>
    </c:forEach>
</ul>
</body>
</html>