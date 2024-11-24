package object;

import enums.UserType;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
public class Owner extends LoggedInUser {
    private List<Hotel> hotels;

    public Owner(String firstName, String lastName, int age, String phoneNumber, int id, String password, List<Hotel> hotels,String username) {
        super(firstName, lastName, age, phoneNumber, id, password,username,UserType.OWNER);
        this.hotels = hotels;

    }
}
