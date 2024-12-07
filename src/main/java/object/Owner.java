package object;

import enums.UserType;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Setter
@Getter
public class Owner extends LoggedInUser {
    private List<Hotel> hotels;

    public Owner(String firstName, String lastName, LocalDate dateOfBirth, String phoneNumber, int id, String password, List<Hotel> hotels, String username) {
        super(firstName, lastName, dateOfBirth, phoneNumber, id, password,username,UserType.OWNER);
        this.hotels = hotels;

    }
}
