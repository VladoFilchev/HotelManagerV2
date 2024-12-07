package object;

import enums.UserType;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;


@Setter
@Getter
public class LoggedInUser extends Person  {
    protected int id;
    private UserType userType;
    private String username;
    private String password;

    public LoggedInUser(String firstName, String lastName, LocalDate localDate, String phoneNumber, int id, String password, String username, UserType userType) {
        super();
        this.id = id;
        this.password = password;
        this.username = username;
        this.userType = userType;
    }
}
