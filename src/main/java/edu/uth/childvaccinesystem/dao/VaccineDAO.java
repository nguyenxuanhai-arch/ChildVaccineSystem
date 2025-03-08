package edu.uth.childvaccinesystem.dao;

import edu.uth.childvaccinesystem.model.Vaccine;
import edu.uth.childvaccinesystem.util.DBConnection;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class VaccineDAO {
    public List<Vaccine> getAllVaccines() {
        List<Vaccine> vaccines = new ArrayList<>();
        String query = "SELECT * FROM vaccines";
        try (Connection conn = DBConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {

            while (rs.next()) {
                vaccines.add(new Vaccine(rs.getInt("id"), rs.getString("name"), rs.getString("description"), rs.getInt("ageRequired")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return vaccines;
    }

    public boolean addVaccine(Vaccine vaccine) {
        String query = "INSERT INTO vaccines (name, description, ageRequired) VALUES (?, ?, ?)";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setString(1, vaccine.getName());
            stmt.setString(2, vaccine.getDescription());
            stmt.setInt(3, vaccine.getAgeRequired());

            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public void deleteVaccine(int id) {

    }

    public void updateVaccine(Vaccine vaccine) {

    }
}
