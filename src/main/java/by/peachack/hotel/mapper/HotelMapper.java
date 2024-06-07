package by.peachack.hotel.mapper;

import by.peachack.hotel.dto.HotelDetailedDTO;
import by.peachack.hotel.dto.HotelPostDTO;
import by.peachack.hotel.dto.HotelSummaryDTO;
import by.peachack.hotel.model.Address;
import by.peachack.hotel.model.Amenity;
import by.peachack.hotel.model.Hotel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.Named;

import java.util.List;
import java.util.stream.Collectors;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public abstract class HotelMapper {
    @Mapping(source = "address", target = "address", qualifiedByName = "addressToString")
    @Mapping(source = "contacts.phone", target = "phone")
    public abstract HotelSummaryDTO mapToSummaryDTO(Hotel hotel);

    public abstract Hotel mapToDetailedDTO(HotelPostDTO dto);

    @Mapping(source = "amenities", target = "amenities")
    public abstract HotelDetailedDTO mapToDetailedDTO(Hotel hotel);

    public List<String> mapAmenities(List<Amenity> amenities) {
        return amenities.stream()
                .map(Amenity::getName)
                .collect(Collectors.toList());
    }
    @Named("addressToString")
    public String addressToString(Address value) {
        return value.getHouseNumber() + " " +
                value.getStreet() + ", " +
                value.getCity() + ", " +
                value.getPostCode() + ", " +
                value.getCountry();
    }

    @Named("stringToAddress")
    public Address stringToAddress(String address) {
        String[] parts = address.split(", ");
        String[] houseStreet = parts[0].split(" ");
        int houseNumber = Integer.parseInt(houseStreet[0]);
        String street = houseStreet[1];
        String city = parts[1];
        String postCode = parts[2];
        String country = parts[3];
        return new Address(houseNumber, street, city, postCode, country);
    }
}
