<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Update user</title>
</head>
<body>
<h2>Update user</h2>

<form method="POST" action="http://localhost:8080/UserServletApp_war_exploded/users?action=update">
    <label for="id">ID:</label>
    <input type="number" id="id" name="id" required value="${user.id}"><br><br>

    <label for="name">Name:</label>
    <input type="text" id="name" name="name" required value="${user.name}"><br><br>

    <label for="age">Age:</label>
    <input type="number" id="age" name="age" required value="${user.age}"><br><br>

    <label for="lastname">Last name:</label>
    <input type="text" id="lastname" name="lastname" required value="${user.lastname}"><br><br>

    <input type="submit" value="Update">
</form>
<br>
<a href="users">User list</a>
</body>
</html>