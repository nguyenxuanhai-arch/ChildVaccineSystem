package edu.uth.childvaccinesystem.controller;

import edu.uth.childvaccinesystem.dao.PaymentDAO;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/payment")
public class PaymentServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int bookingId = Integer.parseInt(request.getParameter("bookingId"));
        double amount = Double.parseDouble(request.getParameter("amount"));

        PaymentDAO paymentDAO = new PaymentDAO();
        paymentDAO.processPayment(bookingId, amount);

        response.sendRedirect("payment_success.jsp");
    }
}
