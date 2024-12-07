package object;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class Client extends Person{
  private double clientRating=2.5;
  private boolean isStaying=false;

    public Client(String firstName, String lastName, LocalDate DOB, String phoneNumber) {
        super(firstName, lastName, DOB, phoneNumber);
    }
}
