package edu.uth.childvaccinesystem.controller;

import edu.uth.childvaccinesystem.dao.BookingDAO;
import edu.uth.childvaccinesystem.dao.UserDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/dashboard")
public class DashboardServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int totalUsers = new UserDAO().getTotalUsers();
        int totalBookings = new BookingDAO().getTotalBookings();

        request.setAttribute("totalUsers", totalUsers);
        request.setAttribute("totalBookings", totalBookings);

        request.getRequestDispatcher("dashboard.jsp").forward(request, response);
    }
}
