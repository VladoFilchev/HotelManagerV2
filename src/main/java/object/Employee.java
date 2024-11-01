package object;

import enums.UserType;
import lombok.Getter;
import lombok.Setter;


@Setter
@Getter
public class Employee extends Person  {
    protected int id;
    protected String username;
    protected String password;

    public Employee(String firstName, String lastName, int age, String phoneNumber, int id, String password,String username) {
        super(firstName, lastName, age, phoneNumber);
        this.id = id;
        this.password = password;
        this.username=username;
    }
}
