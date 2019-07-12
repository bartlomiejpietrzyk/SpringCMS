<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
    <title>Display Articles</title>
</head>
<body>
<h1>Display Articles</h1>
<table>
    <tbody>
    <c:forEach items="${article}" var="article">
        <tr>
            <td><c:out value="${article}"/>
                <a href="/articles/delete?id=${article.id}" name="delete>">DELETE</a>
                <a href="/articles/edit?id=${article.id}" name="edit>">EDIT</a>
            </td>

        </tr>
    </c:forEach>
    <td>
        <a href="/articles/add" name="add>">ADD ARTICLE</a>
    </td>
    </tbody>
</table>
</body>
</html>