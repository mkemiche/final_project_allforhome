package io.allforhome.models;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * @author mkemiche
 * @created 30/04/2021
 */

@Data
@NoArgsConstructor
@Entity
@Table(name = "location")
public class Location {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "int(11) UNSIGNED")
    private Long id;

    @NotNull
    @NotBlank(message = "This field is required")
    private String address;

    @NotNull
    @NotBlank(message = "This field is required")
    private String city;

    @NotNull
    @NotBlank(message = "This field is required")
    private String zipcode;

    @NotNull
    @NotBlank(message = "This field is required")
    private String state;

    public Location(String address, String city, String zipcode, String state) {
        this.address = address;
        this.city = city;
        this.zipcode = zipcode;
        this.state = state;
    }
}
