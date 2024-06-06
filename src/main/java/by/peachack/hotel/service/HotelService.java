package by.peachack.hotel.service;

import by.peachack.hotel.dto.HotelSearchCriteria;
import by.peachack.hotel.model.Amenity;
import by.peachack.hotel.model.Hotel;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

public interface HotelService {
    List<Hotel> findHotels();
    Hotel findHotel(Integer id);
    Hotel saveHotel(Hotel hotel);
    Hotel saveHotelAmenities(Integer id, List<Amenity> amenities);
    List<Hotel> searchHotel(HotelSearchCriteria hotelSearchCriteria);
    Map<String, Long> getHistogram(String param);
}
