<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<title>Display Categories</title>
</head>
<body>
<h1>Display Categories</h1>
<table>
    <tbody>
    <c:forEach items="${category}">
        <tr>
            <td><c:out value="${category}"/>
                <a href="/category/delete?id=${category.id}" ename="delete>">DELETE</a>
                <a href="/category/edit?id=${category.id}" name="edit>">EDIT</a>
            </td>

        </tr>
    </c:forEach>
    <td>
        <a href="/category/add" name="add>">ADD CATEGORY</a>
    </td>
    </tbody>
</table>