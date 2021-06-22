package io.allforhome.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @author mkemiche
 * @created 05/06/2021
 */

@ResponseStatus(HttpStatus.NOT_FOUND)
public class PropertyNotFoundException extends RuntimeException {

    private static final long serialVersionUID = 1L;
    private String msg;
    public PropertyNotFoundException(String msg) {
        this.msg=msg;
    }

    public String getMsg(){
        return msg;
    }
}
