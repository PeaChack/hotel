package by.peachack.hotel.service;

import by.peachack.hotel.model.Amenity;
import by.peachack.hotel.model.Hotel;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public interface HotelService {
    List<Hotel> findHotels();
    Hotel findHotel(Integer id);
    Hotel saveHotel(Hotel hotel);
    Hotel saveHotelAmenities(Integer id, List<Amenity> amenities);
    List<Hotel> searchHotel(Map<String, String> params);
    Map<String, Integer> getHistogram(String param);
}
