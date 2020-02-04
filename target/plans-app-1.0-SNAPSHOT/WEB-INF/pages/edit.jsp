<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <div align="center">
    <c:if test="${empty plan.name}">
        <h1>Добавить план</h1>
    </c:if>
    <c:if test="${!empty plan.name}">
        <h1>Изменить план</h1>
    </c:if>
    </div>
</head>
<body>
<div align="center">
<c:if test="${empty plan.name}">
    <c:url value="/add" var="var"/>
</c:if>
<c:if test="${!empty plan.name}">
    <c:url value="/edit" var="var"/>
</c:if>
<form action="${var}" method="POST">
    <c:if test="${!empty plan.name}">
        <input type="hidden" name="id" value="${plan.id}">
    </c:if>
    <label for="name">Название</label>
    <input required type="text" name="name" id="name" maxlength="100">
    <label for="description">Описание</label>
    <input required type="text" name="description" id="description" maxlength="300">
    <label for="status">Статус</label>
    <select required name="status" id="status">
        <option>Ready</option>
        <option>Failed</option>
        <option>In progress</option>
        <option>Passed to</option>
        <option>Complete</option>
    </select>
    <c:if test="${!empty plan.name}">
        <input type="submit" value="Изменить план">
    </c:if>
    <c:if test="${empty plan.name}">
        <input type="submit" value="Добавить план">
    </c:if>
</form>
    <a href="/"><img src="/images/back.png" title="Вернуться к списку планов"></a>
</div>
</body>
</html>
