package io.allforhome.models;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
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
public class Property {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "int(11) UNSIGNED")
    private Long id;
    private String pReference;
    private String pTitle;

    @Column(length = 2000)
    private String pDescription;
    private String pStatus;
    private String pCategory;
    private String pType;
    private String pBuiltYear;

    private double pPrice;
    private double pArea;
    private int pBedrooms;
    private int pBathrooms;
    private boolean hasBasement;
    private boolean hasBalcony;
    private boolean hasTerrace;
    private boolean hasSPool;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "Registration_id")
    private RegistrationDate pUpdateDate = new RegistrationDate();

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "location_id")
    private Location pLocation = new Location();

    @OneToMany(
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    @ToString.Exclude
    private List<Image> pImages = new ArrayList<>();

    public Property(String pReference, String pTitle, String pDescription, String pStatus, String pCategory, String pType, String pBuiltYear, double pPrice, double pArea, int pBedrooms, int pBathrooms, boolean hasBasement, boolean hasBalcony, boolean hasTerrace, boolean hasSPool, RegistrationDate pUpdateDate, Location pLocation, List<Image> pImages) {
        this.pReference = pReference;
        this.pTitle = pTitle;
        this.pDescription = pDescription;
        this.pStatus = pStatus;
        this.pCategory = pCategory;
        this.pType = pType;
        this.pBuiltYear = pBuiltYear;
        this.pPrice = pPrice;
        this.pArea = pArea;
        this.pBedrooms = pBedrooms;
        this.pBathrooms = pBathrooms;
        this.hasBasement = hasBasement;
        this.hasBalcony = hasBalcony;
        this.hasTerrace = hasTerrace;
        this.hasSPool = hasSPool;
        this.pUpdateDate = pUpdateDate;
        this.pLocation = pLocation;
        this.pImages = pImages;
    }
}
