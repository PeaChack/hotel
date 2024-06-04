package by.peachack.hotel.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "amenity")
@Data
public class Amenity {
    @Id
    @Column(name = "id")
    private Integer id;
    @Column(name = "name")
    private String name;
}
