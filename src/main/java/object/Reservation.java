package object;

import enums.ReservationEndType;
import enums.ReservationType;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;
@Data
public class Reservation {
    private int reservationId;
    private ReservationType reservationType;
    private ReservationEndType reservationEndType;
    private List<Room> reservationRoomsList;
    private LocalDate startDate;
    private LocalDate endDate;
    private Client client;
    private Receptionist receptionist;
    private double totalCost;


}
