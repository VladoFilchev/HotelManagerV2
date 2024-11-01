package object;

import enums.UserType;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Receptionist extends Employee {
    private final UserType employeePosition= UserType.USER;
    public Receptionist(String firstName, String lastName, int age, String phoneNumber, int id,String password,String username) {
        super(firstName, lastName, age, phoneNumber, id, password,username);

    }
}
