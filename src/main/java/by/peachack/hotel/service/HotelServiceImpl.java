package by.peachack.hotel.service;

import by.peachack.hotel.dto.HotelSearchCriteria;
import by.peachack.hotel.exception.HotelNotFoundException;
import by.peachack.hotel.model.Amenity;
import by.peachack.hotel.model.Hotel;
import by.peachack.hotel.repository.AmenityRepository;
import by.peachack.hotel.repository.HotelRepository;
import by.peachack.hotel.specification.HotelSpecification;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class HotelServiceImpl implements HotelService {
    private final HotelRepository hotelRepository;
    private final AmenityRepository amenityRepository;

    @Override
    public List<Hotel> findHotels() {
        return hotelRepository.findAll();
    }

    @Override
    public Hotel findHotel(Integer id) {
        return hotelRepository.findById(id).orElseThrow(() -> new HotelNotFoundException(id));
    }

    @Override
    public Hotel saveHotel(Hotel hotel) {
        return hotelRepository.save(hotel);
    }

    @Override
    public Hotel saveHotelAmenities(Integer id, List<Amenity> amenities) {
        Hotel hotel = hotelRepository.findById(id).orElseThrow(() -> new HotelNotFoundException(id));
        List<Amenity> updatedAmenities = amenities.stream().map(amenity -> amenityRepository.findByName(amenity.getName())
                        .orElseGet(() -> amenityRepository.save(amenity)))
                .collect(Collectors.toList());
        hotel.setAmenities(updatedAmenities);
        return hotelRepository.save(hotel);
    }

    @Override
    public List<Hotel> searchHotel(HotelSearchCriteria hotelSearchCriteria) {
        HotelSpecification hotelSpecification = new HotelSpecification(hotelSearchCriteria);
        return hotelRepository.findAll(hotelSpecification);
    }

    @Override
    public Map<String, Integer> getHistogram(String param) {
        throw new UnsupportedOperationException();
    }
}
