package by.peachack.hotel.model;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Data;

@Data
@Embeddable
public class Address {
    @Column(name = "house_number")
    private int houseNumber;
    @Column(name = "street")
    private String street;
    @Column(name = "city")
    private String city;
    @Column(name = "county")
    private String county;
    @Column(name = "post_code")
    private String postCode;
}
