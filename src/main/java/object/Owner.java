package object;

import enums.UserType;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
public class Owner extends Employee {
    private final int accessLevel = 2;
    private List<Hotel> hotels;
    private final UserType employeePosition=UserType.ADMIN;

    public Owner(String firstName, String lastName, int age, String phoneNumber, int id, String password, List<Hotel> hotels,String username) {
        super(firstName, lastName, age, phoneNumber, id, password,username);
        this.hotels = hotels;

    }
}
