<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>Display Authors</title>
</head>
<body>
<h1>Display Authors</h1>
<table>
    <tbody>
    <c:forEach items="${author}" var="author">
        <tr>
            <td><c:out value="${author}"/>
                <a href="/authors/delete?id=${author.id}" name="delete>">DELETE</a>
                <a href="/authors/edit?id=${author.id}" name="edit>">EDIT</a>
            </td>

        </tr>
    </c:forEach>
    <td>
        <a href="/authors/add" name="add>">ADD AUTHOR</a>
    </td>
    </tbody>
</table>
</body>
</html>