package io.allforhome.enums;

/**
 * @author mkemiche
 * @created 30/04/2021
 */
public enum Status {
    RENT("For Rent"),
    SALE("For Sale");

    private String value;
    Status(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
