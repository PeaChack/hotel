package by.peachack.hotel.model;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Data;

@Data
@Embeddable
public class ArrivalTime {
    @Column(name = "check_in")
    private String checkIn;
    @Column(name = "check_out")
    private String checkOut;
}
