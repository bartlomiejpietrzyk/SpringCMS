<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>Create Author</title>
</head>
<body>
<h1>Create Author</h1>
<form:form method="post" action="/authors/added" modelAttribute="author">
    Firstname: <form:input path="firstName"/><br>
    Lastname: <form:input path="lastName"/><br>
    <input type="submit" value="Save">
</form:form>
</body>
</html>