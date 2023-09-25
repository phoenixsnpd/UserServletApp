<%@ page import="com.example.userservletapp.model.User" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>User List</title>
</head>
<body>
<h2>User List</h2>
<ul>
    <%
        List<User> users = (List<User>) request.getAttribute("users");
        for (User user : users) {
    %>
    <li><%= user.getName() %>, <%= user.getAge() %>, <%= user.getLastName() %></li>
    <%
        }
    %>
</ul>
<br>
<a href="?action=add">Add user</a>
<br>
<a href="?action=delete">Delete user</a>
<br>
<a href="?action=update">Update user</a>
</body>
</html>