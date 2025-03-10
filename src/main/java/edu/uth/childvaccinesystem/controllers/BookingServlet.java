package edu.uth.childvaccinesystem.controller;

import edu.uth.childvaccinesystem.dao.BookingDAO;
import edu.uth.childvaccinesystem.model.Booking;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/booking")
public class BookingServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        int userId = Integer.parseInt(request.getParameter("userId"));
        int vaccineId = Integer.parseInt(request.getParameter("vaccineId"));
        String bookingDate = request.getParameter("bookingDate");

        BookingDAO bookingDAO = new BookingDAO();
        bookingDAO.addBooking(new Booking(id, userId, vaccineId, bookingDate));

        response.sendRedirect("booking_list.jsp");
    }
}
