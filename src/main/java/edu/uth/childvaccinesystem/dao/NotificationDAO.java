package edu.uth.childvaccinesystem.dao;

import edu.uth.childvaccinesystem.model.Booking;
import edu.uth.childvaccinesystem.util.DBConnection;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class NotificationDAO {
    public List<Booking> getReminders() {
        List<Booking> reminders = new ArrayList<>();
        String query = "SELECT * FROM bookings WHERE bookingDate = CURDATE() + INTERVAL 1 DAY";
        try (Connection conn = DBConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {

            while (rs.next()) {
                reminders.add(new Booking(rs.getInt("id"), rs.getInt("userId"), rs.getInt("vaccineId"), rs.getString("bookingDate")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return reminders;
    }
}
