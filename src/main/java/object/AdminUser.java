package object;

import enums.UserType;

import java.time.LocalDate;

public class AdminUser extends LoggedInUser{
    public AdminUser(String firstName, String lastName, LocalDate dateOfBirth, String phoneNumber, int id, String password, String username) {
        super(firstName, lastName,dateOfBirth, phoneNumber, id, password, username,UserType.ADMIN);
    }
}
