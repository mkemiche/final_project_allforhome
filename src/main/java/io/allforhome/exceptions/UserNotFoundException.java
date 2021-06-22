package io.allforhome.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @author mkemiche
 * @created 05/06/2021
 */

@ResponseStatus(HttpStatus.NOT_FOUND)
@ResponseBody
public class UserNotFoundException extends RuntimeException{

    private static final long serialVersionUID = 1L;
    private String msg;
    public UserNotFoundException(String msg) {
        this.msg=msg;
    }

    public String getMsg(){
        return msg;
    }
}
