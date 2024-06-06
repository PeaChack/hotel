package by.peachack.hotel.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class HotelSearchCriteria {
    private String name;
    private String brand;
    private String city;
    private String country;
    private List<String> amenities;
}
