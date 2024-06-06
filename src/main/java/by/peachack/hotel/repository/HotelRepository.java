package by.peachack.hotel.repository;

import by.peachack.hotel.model.HistogramResult;
import by.peachack.hotel.model.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Map;

public interface HotelRepository extends JpaRepository<Hotel, Integer>, JpaSpecificationExecutor<Hotel> {
    String HISTOGRAM_RESULT_PATH = "by.peachack.hotel.model.HistogramResult";

    @Query("SELECT new " + HISTOGRAM_RESULT_PATH + "(h.brand, COUNT(h)) FROM Hotel h GROUP BY h.brand")
    List<HistogramResult> countByBrand();

    @Query("SELECT new " + HISTOGRAM_RESULT_PATH + "(h.address.city, COUNT(h)) FROM Hotel h GROUP BY h.address.city")
    List<HistogramResult> countByAddressCity();

    @Query("SELECT new " + HISTOGRAM_RESULT_PATH + "(h.address.country, COUNT(h)) FROM Hotel h GROUP BY h.address.country")
    List<HistogramResult> countByAddressCountry();

    @Query("SELECT new " + HISTOGRAM_RESULT_PATH + "(a.name, COUNT(h)) FROM Hotel h JOIN h.amenities a GROUP BY a.name")
    List<HistogramResult> countByAmenities();
}
