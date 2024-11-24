package object;

import enums.UserType;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Receptionist extends LoggedInUser {
    public Receptionist(String firstName, String lastName, int age, String phoneNumber, int id,String password,String username,UserType userType) {
        super(firstName, lastName, age, phoneNumber, id, password,username,UserType.RECEPTIONIST);

    }
}
