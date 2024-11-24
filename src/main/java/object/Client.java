package object;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Client extends Person{
  private double clientRating=2.5;
  private boolean isStaying=false;

    public Client(String firstName, String lastName, int age, String phoneNumber) {
        super();
    }
}
