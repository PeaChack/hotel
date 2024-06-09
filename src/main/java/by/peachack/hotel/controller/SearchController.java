package by.peachack.hotel.controller;

import by.peachack.hotel.dto.HotelSearchCriteria;
import by.peachack.hotel.dto.HotelSummaryDTO;
import by.peachack.hotel.mapper.HotelMapper;
import by.peachack.hotel.model.Hotel;
import by.peachack.hotel.service.HotelService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;
@Tag(name = "Search", description = "The Search API for hotels")
@RestController
@RequestMapping("/search")
@RequiredArgsConstructor
@Validated
public class SearchController {
    private final HotelService hotelService;
    private final HotelMapper hotelMapper;
    @Operation(summary = "Search hotels",
            description = "Search hotels based on the provided criteria.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Hotels successfully retrieved"),
            @ApiResponse(responseCode = "404", description = "No hotels found")
    })
    @GetMapping
    List<HotelSummaryDTO> searchHotel(@Valid @ModelAttribute HotelSearchCriteria searchCriteria) {
        List<Hotel> hotels = hotelService.searchHotel(searchCriteria);
        return hotels.stream().map(hotelMapper::mapToSummaryDTO).collect(Collectors.toList());
    }
}
