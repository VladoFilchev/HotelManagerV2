package object;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Setter
@Getter
public class Person {
    protected String firstName;
    protected String lastName;
    protected LocalDate DOB;
    protected String phoneNumber;

    public Person() {
    }
    public Person(String firstName, String lastName, LocalDate DOB, String phoneNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.DOB = DOB;
        this.phoneNumber = phoneNumber;

    }
}
