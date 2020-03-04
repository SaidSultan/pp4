<%--
  Created by IntelliJ IDEA.
  User: Said
  Date: 017. 17.02.2020
  Time: 2:13
  To change this template use File | Settings | File Templates.
--%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Title JSP</title>
</head>
<body>
<!--<c:if test="${!empty listUsers}">
</c:if>-->
    <table cellpadding="5" cellspacing="0">
        <tr>
            <td>ID</td>
            <td>Name</td>
            <td>LastName</td>
            <td>Age</td>
            <td>Edit</td>
            <td>Delete</td>
        </tr>
        <c:forEach var="usersList" items="${list}">
        <tr valign="middle">
            <td>${usersList.id}</td>
            <td>${usersList.name}</td>
            <td>${usersList.lastName}</td>
            <td>${usersList.age}</td>
            <td valign="bottom">
                <form action="/edit" method="get">
                    <button type="submit" name="editBtn" value="${usersList.id}">Edit</button>
                </form>
            </td>
            <td>
                <form action="/del" method="post">
                    <button type="submit" name="deleteBtn" value="${usersList.id}">Delete</button>
                </form>
            </td>
        </tr>
        </c:forEach>
    </table>

<form action="/users" method="post" style="margin-top: 30px;">

    <table cellpadding="5" cellspacing="1">
        <tr>
            <td><label>Добавить существо:</label></td>
        </tr>
        <tr>
    <td><label>Введите Имя:</label></td>  <td><input type="text" name="name"></td>
        </tr>
        <tr>
            <td><label>Введите Фалимию:</label></td> <td><input type="text" name="lastname"></td>
        </tr>
        <tr>
            <td> <label>Введите Возраст:</label></td> <td><input type="text" name="age"></td>
        </tr>
        <tr>
            <td>
    <input type="submit" value="Добавить">
            </td>
        </tr>
    </table>
</form>
</body>
</html>
