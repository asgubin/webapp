<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>

<head>
    <title>Lesson_02</title>
    <style><%@include file="/WEB-INF/css/style.css"%></style>
</head>

<body>
<h1>Aston Trainee, Lesson_02</h1><br />
<h2>All Users</h2><br />
    <table>
        <tr>
            <th>Name</th>
            <th>Age</th>
        </tr>

        <c:forEach var="user" items="${requestScope.users}">
        <tr>
            <td><c:out value="${user.name}"/></td>
            <td><c:out value="${user.age}"/></td>
        </tr>
        </c:forEach>
    </table>

    <hr />

<h2>Create a new user</h2><br />
    <form method="post" action="">
        <label><input type="text" name="name"></label>Name<br>
        <label><input type="number" name="age"></label>Age<br>
        <input type="submit" value="Create" name="Create"><br>
    </form>

</body>
</html>