package io.allforhome.models;

import java.time.LocalDateTime;
import java.util.List;

/**
 * @author mkemiche
 * @created 03/05/2021
 */
public class PropertyManager {


    public Property createProperty(String pReference, String pTitle, String pDescription, String pCategory, double pPrice, double pArea, LocalDateTime postedDate, Location pLocation, List<Image> pImages, String pStatus, String pType, String pBuiltYear, int pBedrooms, int pBathrooms, boolean hasBalcony) {
        return new Apartment(pReference, pTitle, pDescription, pCategory, pPrice, pArea, postedDate, pLocation, pImages, pStatus, pType, pBuiltYear, pBedrooms, pBathrooms, hasBalcony);
    }

    public Property createProperty(String pReference, String pTitle, String pDescription, String pCategory, double pPrice, double pArea, LocalDateTime postedDate, Location pLocation, List<Image> pImages, String pStatus, String pType, String pBuiltYear, int pBedrooms, int pBathrooms, boolean hasBasement, boolean hasTerrace, boolean hasSPool) {
        return new House(pReference, pTitle, pDescription, pCategory, pPrice, pArea, postedDate, pLocation, pImages, pStatus, pType, pBuiltYear, pBedrooms, pBathrooms, hasBasement, hasTerrace, hasSPool);
    }

}
