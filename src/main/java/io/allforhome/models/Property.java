package io.allforhome.models;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
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

    @NotNull
    @NotBlank(message = "This field is required")
    private String pTitle;

    @NotNull
    @NotBlank(message = "This field is required")
    @Size(max = 2000)
    private String pDescription;

    @NotNull
    private String pStatus;
    @NotNull
    private String pCategory;

    @NotNull
    @NotBlank(message = "This field is required")
    private String pType;


    private String pBuiltYear;

    @NotNull
    @NotBlank(message = "This field is required")
    private String pPrice;

    @NotNull
    @NotBlank(message = "This field is required")
    private String pArea;

    @NotNull
    private int pBedrooms;

    @NotNull
    private int pBathrooms;

    private boolean hasGarage;
    private boolean hasBasement;
    private boolean hasBalcony;
    private boolean hasTerrace;
    private boolean hasSPool;
    private boolean hasGarden;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "Registration_id")
    private RegistrationDate pUpdateDate = new RegistrationDate();

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "location_id")
    private Location pLocation = new Location();

    @OneToMany
    @ToString.Exclude
    private List<Image> pImages;

    public Property(String pReference, String pTitle, String pDescription, String pStatus, String pCategory, String pType, String pBuiltYear, String pPrice, String pArea, int pBedrooms, int pBathrooms, boolean hasGarage, boolean hasBasement, boolean hasBalcony, boolean hasTerrace, boolean hasSPool, boolean hasGarden, RegistrationDate pUpdateDate, Location pLocation, List<Image> pImages) {
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
        this.hasGarage = hasGarage;
        this.hasBasement = hasBasement;
        this.hasBalcony = hasBalcony;
        this.hasTerrace = hasTerrace;
        this.hasGarden = hasGarden;
        this.hasSPool = hasSPool;
        this.pUpdateDate = pUpdateDate;
        this.pLocation = pLocation;
        this.pImages = pImages;
    }
}
