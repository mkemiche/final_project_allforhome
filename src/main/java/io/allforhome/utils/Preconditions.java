package io.allforhome.utils;

import io.allforhome.exceptions.ResourceNotFoundException;

/**
 * @author mkemiche
 * @created 05/06/2021
 */
public class Preconditions {

    public Preconditions(){
        throw new AssertionError();
    }


    public static void checkFound(final boolean expression) {
        if (!expression) {
            throw new ResourceNotFoundException();
        }
    }


    /**
     *
     * @param resource
     * @param <T>
     * @return
     * @throws ResourceNotFoundException
     */
    public static <T> T checkFound(final T resource) {
        if (resource == null) {
            throw new ResourceNotFoundException();
        }
        return resource;
    }


}
