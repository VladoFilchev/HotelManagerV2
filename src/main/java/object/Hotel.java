package object;

import lombok.Data;

import java.util.List;
@Data

public class Hotel {
    private int hotelId;
    private String hotelName;
    private Owner hotelOwner;
    private Manager hotelManager;
    private List<Receptionist> hotelReceptionistsList;
    private List<Room> hotelRoomsList;

}
