package io.allforhome.models;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.time.LocalDateTime;
import java.util.List;

/**
 * @author mkemiche
 * @created 08/06/2021
 */

@Data
@NoArgsConstructor
@Entity
@DiscriminatorValue("apartment")
public class Apartment extends Property{


    private String pStatus;

    private String pType;

    private String pBuiltYear;

    private int pBedrooms;

    private int pBathrooms;

    private boolean hasBalcony;

    public Apartment(String pReference, String pTitle, String pDescription, String pCategory, double pPrice, double pArea, LocalDateTime postedDate, Location pLocation, List<Image> pImages, String pStatus, String pType, String pBuiltYear, int pBedrooms, int pBathrooms, boolean hasBalcony) {
        super(pReference, pTitle, pDescription, pCategory, pPrice, pArea, postedDate, pLocation, pImages);
        this.pStatus = pStatus;
        this.pType = pType;
        this.pBuiltYear = pBuiltYear;
        this.pBedrooms = pBedrooms;
        this.pBathrooms = pBathrooms;
        this.hasBalcony = hasBalcony;
    }
}
