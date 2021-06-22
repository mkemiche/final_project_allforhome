package io.allforhome.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @author mkemiche
 * @created 21/06/2021
 */

@ResponseStatus(HttpStatus.NOT_FOUND)
public class CompanyNotFoundException extends RuntimeException {

    private static final long serialVersionUID = 1L;
    private String msg;
    public CompanyNotFoundException(String msg) {
        this.msg=msg;
    }

    public String getMsg(){
        return msg;
    }
}
