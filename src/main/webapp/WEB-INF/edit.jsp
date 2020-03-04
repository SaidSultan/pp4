<%--
  Created by IntelliJ IDEA.
  User: Said
  Date: 018. 18.02.2020
  Time: 2:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
</head>
<body>
<table class="text-center border-secondary container-xl bg-gradient-light text-dark" border="2">
    <tr>
        <th>ID</th>
        <th>Имя</th>
        <th>Фамилия</th>
        <th>Возраст</th>
        <th>Действие</th>
    </tr>
    <form method="post" action="/edit">
        <td>
            <input class="text-center pr-5 pl-5" type="text" name="id" required value="${user.id}">
        </td>
        <td>
            <input class="text-center pr-5 pl-5" type="text" name="name" required value="${user.name}">
        </td>
        <td>
            <input class="text-center pr-5 pl-5" type="text" name="lastname" required value="${user.lastName}">
        </td>
        <td>
            <input class="text-center pr-5 pl-5" type="text" name="age" required value="${user.age}">
        </td>
        <td>
            <button class="d-inline pr-5 pl-5 bg-info text-white" type="submit" name="addbtn">Изменить</button>
        </td>
    </form>
</table>
</body>
</html>
