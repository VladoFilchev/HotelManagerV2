package object;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Setter
@Getter
public class Person {
    protected String firstName;
    protected String lastName;
    protected LocalDate dateOfBirth;
    protected String phoneNumber;

    public Person(String firstName, String lastName, LocalDate dateOfBirth, String phoneNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        this.phoneNumber = phoneNumber;

    }
}
