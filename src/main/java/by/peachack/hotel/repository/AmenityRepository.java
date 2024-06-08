package by.peachack.hotel.repository;

import by.peachack.hotel.model.Amenity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;
import java.util.Set;

public interface AmenityRepository extends JpaRepository<Amenity, Integer> {
    List<Amenity> findByNameIn(Set<String> amenityNames);
}
