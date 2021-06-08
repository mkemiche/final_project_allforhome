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
@DiscriminatorValue("lot")
public class Lot extends Property{

    public Lot(String pReference, String pTitle, String pDescription, String pCategory, double pPrice, double pArea, LocalDateTime postedDate, Location pLocation, List<Image> pImages) {
        super(pReference, pTitle, pDescription, pCategory, pPrice, pArea, postedDate, pLocation, pImages);
    }
}
