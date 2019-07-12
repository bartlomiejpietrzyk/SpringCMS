<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>Create Category</title>
</head>
<body>
<h1>Create Category</h1>
<form:form method="post" action="/category/added" modelAttribute="category">
    Name: <form:input path="name"/><br>
    Description: <form:input path="description"/><br>
    <input type="submit" value="Save">
</form:form>
</body>
</html>