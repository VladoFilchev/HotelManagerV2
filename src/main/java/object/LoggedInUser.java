package object;

import enums.UserType;
import lombok.Getter;
import lombok.Setter;


@Setter
@Getter
public class LoggedInUser extends Person  {
    protected int id;
    private UserType userType;
    private String username;
    private String password;

    public LoggedInUser(String firstName, String lastName, int age, String phoneNumber, int id, String password, String username, UserType userType) {
        super();
        this.id = id;
        this.password = password;
        this.username = username;
        this.userType = userType;
    }
}
