package object;

import enums.RoomStatus;
import enums.RoomType;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Room {
    private int hotelId;
    private int roomNumber;
    private RoomType roomType;
    private RoomStatus roomStatus;
    private int price;

    public Room(int hotelId, int roomNumber, RoomType roomType, RoomStatus roomStatus) {
        this.hotelId = hotelId;
        this.roomNumber = roomNumber;
        this.roomType = roomType;
        this.roomStatus = roomStatus;
        this.price = roomType.getPricePerNight();
    }


    public Room() {

    }
}
