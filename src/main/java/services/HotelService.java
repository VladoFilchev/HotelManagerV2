package services;

import data.DatabaseConnection;
import object.Hotel;
import object.Room;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class HotelService {
    public static boolean saveHotel(Hotel hotel) {
        try (Connection conn = DatabaseConnection.connect();) {
            String sql = "INSERT INTO hotels (name, owner_id, manager_id) VALUES (?, ?, ?) RETURNING hotel_id";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, hotel.getHotelName());
            stmt.setInt(2, hotel.getHotelOwner().getId());
            stmt.setInt(3, hotel.getHotelManager().getId());

            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                int hotelId = rs.getInt("hotel_id");
                for (Room room : hotel.getHotelRoomsList()) {
                    RoomService.saveRoom(room, hotelId);
                }
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}
