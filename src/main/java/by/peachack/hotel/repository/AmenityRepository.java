package by.peachack.hotel.repository;

import by.peachack.hotel.model.Amenity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AmenityRepository extends JpaRepository<Amenity, Integer> {
    Optional<Amenity> findByName(String name);
}
