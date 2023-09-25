<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Add user</title>
</head>
<body>
<h2>Add user</h2>
<form method="POST" action="http://localhost:8080/UserServletApp_war_exploded/users?action=add">
    <label for="name">Name:</label>
    <input type="text" id="name" name="name" required><br><br>

    <label for="age">Age:</label>
    <input type="number" id="age" name="age" required><br><br>

    <label for="lastname">Last name:</label>
    <input type="text" id="lastname" name="lastname" required><br><br>

    <input type="submit" value="Add">
</form>
<br>
<a href="users">User List</a>
</body>
</html>