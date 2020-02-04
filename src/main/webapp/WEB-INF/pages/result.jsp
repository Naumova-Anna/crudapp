<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Searched plan</title>
</head>
<body>
<div align="center">
<h1>Результаты поиска:</h1>
    <c:if test="${empty planResult.id}">
        <p>Записи с таким id не существует.</p>
        <p>Вернитесь к форме поиска и задайте существующий id.</p>
        <a href="/"><img src="/images/back.png" title="Вернуться к поиску"></a>
    </c:if>
<c:if test="${!empty planResult.id}">
<table border="1" cellpadding="5">
    <tr>
        <th>id</th>
        <th>Название</th>
        <th>Описание</th>
        <th>Статус</th>
        <th>Действие</th>
    </tr>
    <tr>
        <td>${planResult.id}</td>
        <td>${planResult.name}</td>
        <td>${planResult.description}</td>
        <td>${planResult.status}</td>
        <td>
            <a href="/edit/${planResult.id}"><img src="/images/dif.png"></a></a>
            <a href="/delete/${planResult.id}"><img src="/images/del.png"></a> </a>
        </td>
    </tr>
</table>
    <br>
    <a href="/"><img src="/images/back.png" title="Вернуться к списку планов"></a>
</div>
</c:if>
</body>
</html>
