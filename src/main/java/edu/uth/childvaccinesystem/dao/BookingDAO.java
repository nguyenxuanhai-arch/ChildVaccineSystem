package edu.uth.childvaccinesystem.dao;

import edu.uth.childvaccinesystem.model.Booking;
import edu.uth.childvaccinesystem.util.DBConnection;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BookingDAO {
    public void addBooking(Booking booking) {
        String query = "INSERT INTO bookings (userId, vaccineId, bookingDate) VALUES (?, ?, ?)";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setInt(1, booking.getUserId());
            stmt.setInt(2, booking.getVaccineId());
            stmt.setString(3, booking.getBookingDate());

            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Booking> getUpcomingBookings() {
        List<Booking> bookings = new ArrayList<>();
        String query = "SELECT * FROM bookings WHERE bookingDate >= CURDATE()";
        try (Connection conn = DBConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {

            while (rs.next()) {
                bookings.add(new Booking(rs.getInt("id"), rs.getInt("userId"), rs.getInt("vaccineId"), rs.getString("bookingDate")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return bookings;
    }

    public int getTotalBookings() {
        return 0;
    }
}
