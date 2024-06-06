package by.peachack.hotel.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Generated;

import java.util.List;

@Entity
@Table(name = "hotel")
@Data
public class Hotel {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "name")
    private String name;
    @Column(name = "description")
    private String description;
    @Column(name = "brand")
    private String brand;
    @Embedded
    private Address address;
    @Embedded
    private Contacts contacts;
    @Embedded
    private ArrivalTime arrivalTime;
    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinTable(
            name = "hotel_amenity",
            joinColumns = @JoinColumn(name = "hotel_id"),
            inverseJoinColumns = @JoinColumn(name = "amenity_id"))
    private List<Amenity> amenities;
}
