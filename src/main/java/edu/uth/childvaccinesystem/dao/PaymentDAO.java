package edu.uth.childvaccinesystem.dao;

import edu.uth.childvaccinesystem.util.DBConnection;
import java.sql.*;

public class PaymentDAO {
    public void processPayment(int bookingId, double amount) {
        String query = "INSERT INTO payments (bookingId, amount, paymentDate) VALUES (?, ?, NOW())";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setInt(1, bookingId);
            stmt.setDouble(2, amount);

            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
