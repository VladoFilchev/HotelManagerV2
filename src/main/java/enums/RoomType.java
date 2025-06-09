package enums;

import lombok.Getter;

@Getter
public enum RoomType {
    SINGLE(70),
    DOUBLE(100),
    FAMILY(150),
    PENTHOUSE(300);

    private final int pricePerNight;

    // Constructor to accept price
    RoomType(int pricePerNight) {
        this.pricePerNight = pricePerNight;
    }

}
