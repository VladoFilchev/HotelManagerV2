package object;

import enums.UserType;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Setter
@Getter
public class Manager extends LoggedInUser {


    public Manager(String firstName, String lastName, LocalDate dateOfBirth, String phoneNumber, int id, String password, String username) {
        super(firstName, lastName, dateOfBirth, phoneNumber, id, password,username,UserType.MANAGER);
    }

    @Override
    public String toString() {
        return getFirstName() + " " + getLastName();
    }
}
