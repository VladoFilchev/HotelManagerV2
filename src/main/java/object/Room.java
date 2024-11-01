package object;

import enums.RoomStatus;
import enums.RoomType;
import lombok.Data;

@Data
public class Room {
    private int roomNumber;
    private RoomType roomType;
    private RoomStatus roomStatus;

}
