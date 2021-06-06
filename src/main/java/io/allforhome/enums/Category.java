package io.allforhome.enums;

/**
 * @author mkemiche
 * @created 24/05/2021
 */
public enum Category {
    HOUSE("House"),
    APARTMENT("Apartment"),
    LOT("Lot"),
    GARAGE("Garage"),
    OTHER("Other");

    private String category;

    Category(String category) {
        this.category = category;
    }

    public String getCategory() {
        return category;
    }
}
