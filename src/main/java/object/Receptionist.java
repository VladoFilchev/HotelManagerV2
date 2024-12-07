package object;

import enums.UserType;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Setter
@Getter
public class Receptionist extends LoggedInUser {
    public Receptionist(String firstName, String lastName, LocalDate dateOfBirth, String phoneNumber, int id, String password, String username, UserType userType) {
        super(firstName, lastName, dateOfBirth, phoneNumber, id, password,username,UserType.RECEPTIONIST);

    }
}
