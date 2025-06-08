package services;

import data.DatabaseConnection;
import object.Manager;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserService {

    public static List<Manager> getAllManagers() {
        List<Manager> managers = new ArrayList<>();
        String sql = "SELECT * FROM managers";

        try (Connection conn = DatabaseConnection.connect();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Manager manager = new Manager(
                        rs.getString("first_name"),
                rs.getString("last_name"),
                rs.getDate("dateofbirth").toLocalDate(),
                rs.getString("phone_number"),
                rs.getInt("manager_id"),
                rs.getString("password"),
                        rs.getString("username")
                );
                // You can set more fields here as needed

                managers.add(manager);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return managers;
    }
}
