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
@DiscriminatorValue("garage")
public class Garage extends Property{


    private String pStatus;

    public Garage(String pReference, String pTitle, String pDescription, String pCategory, double pPrice, double pArea, LocalDateTime postedDate, Location pLocation, List<Image> pImages, String pStatus) {
        super(pReference, pTitle, pDescription, pCategory, pPrice, pArea, postedDate, pLocation, pImages);
        this.pStatus = pStatus;
    }
}
