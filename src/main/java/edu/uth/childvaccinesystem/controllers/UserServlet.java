package edu.uth.childvaccinesystem.controller;

import edu.uth.childvaccinesystem.dao.UserDAO;
import edu.uth.childvaccinesystem.model.User;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet("/user")
public class UserServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<User> users = new UserDAO().getAllUsers();
        request.setAttribute("users", users);
        request.getRequestDispatcher("user_list.jsp").forward(request, response);
    }
}
