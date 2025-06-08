package services;

import data.DatabaseConnection;
import object.Room;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class RoomService {
    public static void saveRoom(Room room, int hotelId) throws SQLException {
        String sql = "INSERT INTO rooms (room_number, hotel_id, type, status, price) VALUES (?, ?, ?, ?, ?)";
        try (Connection conn = DatabaseConnection.connect();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, room.getRoomNumber());
            stmt.setInt(2, hotelId);
            stmt.setObject(3,room.getRoomType(),java.sql.Types.OTHER);
            stmt.setObject(4, room.getRoomStatus(),java.sql.Types.OTHER);
            stmt.setInt(5, room.getPrice());
            stmt.executeUpdate();
        }
    }
}
