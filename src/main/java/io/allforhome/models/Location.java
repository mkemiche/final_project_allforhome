package io.allforhome.models;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

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
    private String address;
    private String city;
    private int zipcode;
    private String state;

    public Location(String address, String city, int zipcode, String state) {
        this.address = address;
        this.city = city;
        this.zipcode = zipcode;
        this.state = state;
    }
}
