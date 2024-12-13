package data;

import object.Owner;

import java.sql.*;

public class OwnerDAO {

    public boolean authenticateUser(String username, String password) {
        String query = "SELECT * FROM owners WHERE username = ? AND password = ?";
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
    public boolean insertOwner(Owner owner) {
        String sql = "INSERT INTO owners (first_name, last_name, dateofbirth, phone_number, username, password, usertype) VALUES (?, ?, ?, ?, ?, ?, ?)";

        try (Connection conn = DatabaseConnection.connect(); // Assuming you have a DatabaseConnection class
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, owner.getFirstName());
            pstmt.setString(2, owner.getLastName());
            pstmt.setDate(3, Date.valueOf(owner.getDateOfBirth()));
            pstmt.setString(4, owner.getPhoneNumber());
            pstmt.setString(5, owner.getUsername());
            pstmt.setString(6, owner.getPassword());

            pstmt.setObject(7,owner.getUserType(),java.sql.Types.OTHER);
           // pstmt.setString(7, owner.getUserType().toString());

            int affectedRows = pstmt.executeUpdate();
            return affectedRows > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
