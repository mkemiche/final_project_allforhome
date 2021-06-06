package io.allforhome.exceptions;

/**
 * @author mkemiche
 * @created 05/06/2021
 */
public class PropertyNotFoundException extends RuntimeException {

    private final String message;
    public PropertyNotFoundException(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
