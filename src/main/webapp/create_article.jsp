<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>Create Article</title>
</head>
<body>
<h1>Create Article</h1>
<form:form method="post" action="/articles/add" modelAttribute="article">
    Author: <form:select items="${authors}" path="author"/><br>
    Title: <form:input path="title"/><br>
    Description: <form:textarea path="content"/><br>
    <input type="submit" value="Save">
</form:form>
</body>
</html>