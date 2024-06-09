package by.peachack.hotel.dto;

import by.peachack.hotel.model.Address;
import by.peachack.hotel.model.ArrivalTime;
import by.peachack.hotel.model.Contacts;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class HotelPostDTO {
    @NotEmpty(message = "Name cannot be empty string")
    @Size(max = 100, message = "Name cannot be longer than 100 characters")
    private String name;
    @NotEmpty(message = "Description cannot be empty string")
    @Size(max = 255, message = "Description cannot be longer than 255 characters")
    private String description;
    @Size(max = 100, message = "Brand cannot be longer than 100 characters")
    private String brand;
    @NotNull(message = "Address cannot be null")
    private Address address;
    @NotNull(message = "Contacts cannot be null")
    private Contacts contacts;
    @NotNull(message = "Arrival time cannot be null")
    private ArrivalTime arrivalTime;
}
