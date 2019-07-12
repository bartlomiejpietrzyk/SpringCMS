
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>Edit Article</title>
</head>
<body>
<form:form method="post" action="/articles/edited" modelAttribute="article">
    Title: <form:input path="title"/><br>
    Description: <form:textarea path="content"/><br>
    <input type="submit" value="Save">
</form:form>
</body>
</html>