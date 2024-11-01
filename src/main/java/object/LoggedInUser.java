package object;

import enums.UserType;
import lombok.Data;

@Data
public class LoggedInUser {
    private UserType userType;
    private String username;
    private String password;
    private int accessLevel;
}
