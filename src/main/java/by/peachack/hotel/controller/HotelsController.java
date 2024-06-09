package by.peachack.hotel.controller;

import by.peachack.hotel.dto.HotelDetailedDTO;
import by.peachack.hotel.dto.HotelPostDTO;
import by.peachack.hotel.dto.HotelSummaryDTO;
import by.peachack.hotel.mapper.HotelMapper;
import by.peachack.hotel.model.Amenity;
import by.peachack.hotel.model.Hotel;
import by.peachack.hotel.service.HotelService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/hotels")
@RequiredArgsConstructor
public class HotelsController {
    private final HotelService hotelService;
    private final HotelMapper hotelMapper;

    @GetMapping
    List<HotelSummaryDTO> findHotels() {
        List<Hotel> hotels = hotelService.findHotels();
        return hotels.stream().map(hotelMapper::mapToSummaryDTO).toList();
    }

    @GetMapping("/{id}")
    HotelDetailedDTO findHotel(@PathVariable Integer id) {
        return hotelMapper.mapToDetailedDTO(hotelService.findHotel(id));
    }

    @PostMapping
    HotelSummaryDTO saveHotel(@Valid @RequestBody HotelPostDTO hotelPostDTO) {
        Hotel hotelToSave = hotelMapper.mapToDetailedDTO(hotelPostDTO);
        Hotel savedHotel = hotelService.saveHotel(hotelToSave);
        return hotelMapper.mapToSummaryDTO(savedHotel);
    }

    @PostMapping("/{id}/amenities")
    HotelSummaryDTO saveHotelAmenities(@PathVariable Integer id, @RequestBody List<@NotEmpty String> amenities) {
        List<Amenity> amenityList = amenities.stream().map(Amenity::new).collect(Collectors.toList());
        return hotelMapper.mapToSummaryDTO(hotelService.saveHotelAmenities(id, amenityList));
    }
}
