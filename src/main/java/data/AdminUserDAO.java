package data;

import object.AdminUser;
import object.Manager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AdminUserDAO {

    public boolean authenticateUser(String username, String password) {
        String query = "SELECT * FROM admin WHERE username = ? AND password = ?";
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

    public AdminUser getLoggedInUser(String username) {
        String query = "SELECT * FROM admin WHERE username = ?";
        try (Connection conn = DatabaseConnection.connect();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setString(1, username);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                return new AdminUser(
                        rs.getString("first_name"),
                        rs.getString("last_name"),
                        rs.getDate("date_of_birth").toLocalDate(),
                        rs.getString("phone_number"),
                        rs.getInt("id"),
                        rs.getString("password"),
                        rs.getString("username")
                        //UserType.ADMIN
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
