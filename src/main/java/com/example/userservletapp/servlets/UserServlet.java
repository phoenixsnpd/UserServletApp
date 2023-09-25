package com.example.userservletapp.servlets;


import com.example.userservletapp.dao.UserDAO;
import com.example.userservletapp.model.User;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "userServlet", value = "/users")
public class UserServlet extends HttpServlet {
    private final UserDAO userDAO;

    public UserServlet() {
        userDAO = new UserDAO();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) {
        String action = request.getParameter("action");
        try {
            if (action == null) {
                getUsers(request, response);
            } else if (action.equals("add")) {
                addUser(request, response);
            } else if (action.equals("delete")) {
                userDelete(request, response);
            } else if (action.equals("update")) {
                userUpdate(request, response);
            }
        } catch (IOException | ServletException e) {
            e.printStackTrace();

        }
    }

    private void userUpdate(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/updateUserForm.jsp").forward(request, response);
        String idFromForm = request.getParameter("id");
        String name = request.getParameter("name");
        String ageFromForm = request.getParameter("age");
        String lastName = request.getParameter("lastname");
        if (idFromForm != null && ageFromForm != null && name != null && lastName != null) {
            int age = Integer.parseInt(ageFromForm);
            int userId = Integer.parseInt(idFromForm);
            User updatedUser = new User(userId, name, age, lastName);
            userDAO.updateUser(updatedUser);
        }
    }

    private void userDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/deleteUserForm.jsp").forward(request, response);
        int userId = Integer.parseInt(request.getParameter("id"));
        userDAO.deleteUser(userId);
    }

    private void addUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/addUserForm.jsp").forward(request, response);
        String name = request.getParameter("name");
        String ageParam = request.getParameter("age");
        String lastName = request.getParameter("lastname");
        if (name != null && ageParam != null && lastName != null) {
            int age = Integer.parseInt(ageParam);
            User newUser = new User(name, age, lastName);
            userDAO.addUser(newUser);
            response.sendRedirect("/UserServletApp_war_exploded/users");
        }
    }

    private void getUsers(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<User> users = userDAO.getAllUsers();
        request.setAttribute("users", users);
        request.getRequestDispatcher("/userList.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) {
        doGet(request, response);
    }
}
