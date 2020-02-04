<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Список планов</title>
    <style>
        #ids {
            width: 75px;
        }
    </style>
</head>
<body>
<div align="center">
    <h1>Список планов</h1>
    <%--https://ru.wikipedia.org/wiki/POST_(HTTP)--%>
    <form action="/search" method="get">
        <label for="ids">Поиск плана по ID:</label>
        <input required type="number" name="id" id="ids" maxlength="300" min="1">
        <input type="submit" name="submit" value="Искать"/>
    </form>

<table border="1" cellpadding="5">
    <tr>
        <th>id</th>
        <th>Название</th>
        <th>Описание</th>
        <th>Статус</th>
        <th>Действие</th>
    </tr>
    <c:forEach var="plan" items="${theWholeList}">
        <tr>
            <td>${plan.id}</td>
            <td>${plan.name}</td>
            <td>${plan.description}</td>
            <td>${plan.status}</td>
            <td>
                <a href="/edit/${plan.id}"><img src="/images/dif.png"></a></a>
                <a href="/delete/${plan.id}"><img src="/images/del.png"></a> </a>
            </td>
        </tr>
    </c:forEach>
</table>
    <c:url value="/add" var="add"/>
    <a href="${add}"><h2>Добавить новый план</h2></a>
</div>

</body>
</html>
