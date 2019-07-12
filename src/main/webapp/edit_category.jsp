<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>Edit Category</title>
</head>
<body>
<h1>Create Article</h1>
<form:form method="post" action="/category/edited" modelAttribute="category">
    Name: <form:input path="name"/><br>
    Description: <form:input path="description"/><br>
    <input type="submit" value="Save">
</form:form>
</body>
</html>