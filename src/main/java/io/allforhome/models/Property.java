package io.allforhome.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * @author mkemiche
 * @created 30/04/2021
 */

@Data
@NoArgsConstructor
@Entity
@Table(name = "property")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="property_category")
public class Property implements Serializable {



    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "int(11) UNSIGNED")
    private Long id;


    private String pReference;


    private String pTitle;

    @Column(length = 2000)

    private String pDescription;

    private String pCategory;


    private double pPrice;

    private double pArea;


    private LocalDateTime postedDate = LocalDateTime.now();

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "location_id")
    @JsonIgnoreProperties(value = {"applications", "hibernateLazyInitializer"})

    private Location pLocation = new Location();

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @ToString.Exclude
    @JsonIgnoreProperties(value = {"applications", "hibernateLazyInitializer"})

    private List<Image> pImages = new ArrayList<>();

    public Property(String pReference, String pTitle, String pDescription, String pCategory, double pPrice, double pArea, LocalDateTime postedDate, Location pLocation, List<Image> pImages) {
        this.pReference = pReference;
        this.pTitle = pTitle;
        this.pDescription = pDescription;
        this.pCategory = pCategory;
        this.pPrice = pPrice;
        this.pArea = pArea;
        this.postedDate = postedDate;
        this.pLocation = pLocation;
        this.pImages = pImages;
    }
}
