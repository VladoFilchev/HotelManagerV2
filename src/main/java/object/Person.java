package object;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Person {
    protected String firstName;
    protected String lastName;
    protected int age;
    protected String phoneNumber;

    public Person() {

    }
}
