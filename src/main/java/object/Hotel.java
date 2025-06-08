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


    public Hotel(int hotelId, String hotelName, Owner hotelOwner, Manager hotelManager, List<Receptionist> hotelReceptionistsList, List<Room> hotelRoomsList) {
        this.hotelId = hotelId;
        this.hotelName = hotelName;
        this.hotelOwner = hotelOwner;
        this.hotelManager = hotelManager;
        this.hotelReceptionistsList = hotelReceptionistsList;
        this.hotelRoomsList = hotelRoomsList;
    }

    public Hotel() {
    }
}

