package by.peachack.hotel.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class HotelSearchCriteria {
    private String name;
    private String brand;
    private String city;
    private String country;
    private List<String> amenities;

    @JsonCreator
    public HotelSearchCriteria(@JsonProperty("name") String name,
                               @JsonProperty("brand") String brand,
                               @JsonProperty("city") String city,
                               @JsonProperty("country") String country,
                               @JsonProperty("amenities") List<String> amenities) {
        if (name == null && brand == null && city == null && country == null && amenities == null)
            throw new IllegalArgumentException("At least one search criteria must be provided");
        this.name = name;
        this.brand = brand;
        this.city = city;
        this.country = country;
        this.amenities = amenities;
    }
}
