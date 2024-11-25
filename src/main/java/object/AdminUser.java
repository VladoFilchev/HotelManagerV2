package object;

import enums.UserType;

public class AdminUser extends LoggedInUser{
    public AdminUser(String firstName, String lastName, int age, String phoneNumber, int id, String password, String username) {
        super(firstName, lastName, age, phoneNumber, id, password, username,UserType.ADMIN);
    }
}
