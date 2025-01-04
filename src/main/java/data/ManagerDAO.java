package data;

import object.Manager;

import java.sql.*;

public class ManagerDAO {

    public boolean authenticateUser(String username, String password) {
        String query = "SELECT * FROM managers WHERE username = ? AND password = ?";
        try (Connection conn = DatabaseConnection.connect();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setString(1, username);
            stmt.setString(2, password);

            ResultSet rs = stmt.executeQuery();
            return rs.next();  // Returns true if user exists with matching credentials
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean insertManager(Manager manager) {
        String sql = "INSERT INTO managers (first_name, last_name, dateofbirth, phone_number, username, password, usertype) VALUES (?, ?, ?, ?, ?, ?, ?)";

        try (Connection conn = DatabaseConnection.connect(); // Assuming you have a DatabaseConnection class
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, manager.getFirstName());
            pstmt.setString(2, manager.getLastName());
            pstmt.setDate(3, Date.valueOf(manager.getDateOfBirth()));
            pstmt.setString(4, manager.getPhoneNumber());
            pstmt.setString(5, manager.getUsername());
            pstmt.setString(6, manager.getPassword());

            pstmt.setObject(7,manager.getUserType(),java.sql.Types.OTHER);

            int affectedRows = pstmt.executeUpdate();
            return affectedRows > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
