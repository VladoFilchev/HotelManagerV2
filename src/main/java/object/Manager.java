package object;

import enums.UserType;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Manager extends Employee{
    private final int accessLevel = 1;
    private UserType employeePosition=UserType.ADMIN;

    public Manager(String firstName, String lastName, int age, String phoneNumber, int id, String password,String username) {
        super(firstName, lastName, age, phoneNumber, id, password,username);
    }
}
