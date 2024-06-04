package by.peachack.hotel.model;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Data;

@Data
@Embeddable
public class Contacts {
    @Column(name = "phone")
    private String phone;
    @Column(name = "email")
    private String email;
}
