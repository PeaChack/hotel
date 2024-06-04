package by.peachack.hotel.dto;

import by.peachack.hotel.model.Address;
import by.peachack.hotel.model.Amenity;
import by.peachack.hotel.model.ArrivalTime;
import by.peachack.hotel.model.Contacts;

import java.util.List;

public class HotelDetailedDTO {
    private int id;
    private String name;
    private String brand;
    private Address address;
    private Contacts contacts;
    private ArrivalTime arrivalTime;
    private List<Amenity> amenities;
}
