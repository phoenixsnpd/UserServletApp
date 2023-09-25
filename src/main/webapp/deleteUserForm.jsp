<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Delete User</title>
</head>
<body>
<h2>Delete User</h2>
<form method="POST" action="http://localhost:8080/UserServletApp_war_exploded/users?action=delete">
    <label for="id">User ID:</label>
    <input type="number" id="id" name="id" required><br><br>

    <input type="submit" value="Delete">
</form>
<br>
<a href="users">User list</a>
</body>
</html>