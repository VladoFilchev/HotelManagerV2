package object;

import enums.UserType;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Manager extends LoggedInUser {

    public Manager(String firstName, String lastName, int age, String phoneNumber, int id, String password,String username) {
        super(firstName, lastName, age, phoneNumber, id, password,username,UserType.MANAGER);
    }
}
