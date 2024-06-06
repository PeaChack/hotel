package by.peachack.hotel.dto;

import by.peachack.hotel.model.Address;
import by.peachack.hotel.model.ArrivalTime;
import by.peachack.hotel.model.Contacts;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class HotelPostDTO {
    private String name;
    private String description;
    private String brand;
    private Address address;
    private Contacts contacts;
    private ArrivalTime arrivalTime;
}
