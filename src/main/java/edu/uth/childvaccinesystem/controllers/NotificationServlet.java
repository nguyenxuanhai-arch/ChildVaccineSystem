package edu.uth.childvaccinesystem.controller;

import edu.uth.childvaccinesystem.dao.BookingDAO;
import edu.uth.childvaccinesystem.model.Booking;
import edu.uth.childvaccinesystem.util.EmailUtil;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet("/notification")
public class NotificationServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        List<Booking> bookings = new BookingDAO().getUpcomingBookings();

        for (Booking booking : bookings) {
            EmailUtil.sendEmail(booking.getUserEmail(), "Nhắc lịch tiêm chủng", "Bạn có lịch tiêm vào " + booking.getBookingDate());
        }

        response.sendRedirect("notification_success.jsp");
    }
}
