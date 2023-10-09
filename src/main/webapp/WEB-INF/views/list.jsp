<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html lang="pl">
<head>
    <meta charset="UTF-8"/>
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
    <meta http-equiv="X-UA-Compatible" content="ie=edge"/>
    <title>Lista Użytkowników</title>
    <link rel="stylesheet" href="resources/css/style.css"/>
</head>
<body>
<header>
    <!-- Nagłówek, nawigacja itp. -->
</header>

<section class="user-list">
    <h2>Lista Użytkowników</h2>
    <table>
        <thead>
        <tr>
            <th>ID</th>
            <th>Nazwa Użytkownika</th>
            <th>Email</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${users}" var="user">
            <tr>
                <td>${user.id}</td>
                <td>${user.username}</td>
                <td>${user.email}</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</section>

<footer>
    <!-- Stopka itp. -->
</footer>
</body>
</html>
