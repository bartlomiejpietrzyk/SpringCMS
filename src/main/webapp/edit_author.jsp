<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>Edit Author</title>
</head>
<body>
<form:form method="post" action="/authors/edited" modelAttribute="author">
    Firstname: <form:input path="firstName"/><br>
    Lastname: <form:input path="lastName"/><br>
    <input type="submit" value="Save">
</form:form>
</body>
</html>