package by.peachack.hotel.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Data;

@Data
@Embeddable
public class ArrivalTime {
    @Column(name = "check_in")
    private String checkIn;
    @Column(name = "check_out")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String checkOut;
}
